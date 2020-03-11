package com.kh.sts28.service;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.kh.sts28.entity.PayDto;
import com.kh.sts28.repository.PayDao;
import com.kh.sts28.vo.KakaoPayReadyReturnVO;
import com.kh.sts28.vo.KakaoPayRevokeReturnVO;
import com.kh.sts28.vo.KakaoPaySuccessReadyVO;
import com.kh.sts28.vo.KakaoPaySuccessReturnVO;
import com.kh.sts28.vo.PayReadyReturnVO;
import com.kh.sts28.vo.PayReadyVO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class KakaoPayservice implements PayService{

	@Autowired
	private PayDao payDao;
	
	
	@Override
	public PayReadyReturnVO ready(PayReadyVO vo) throws URISyntaxException {
		
		RestTemplate template = new RestTemplate();
		

		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "KakaoAK 80a1800fa42c30d9191e0af0f2c2c97d");

		headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE+"; charset=utf-8");
		headers.add("Accept", MediaType.APPLICATION_JSON_UTF8_VALUE);
		

		MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
		body.add("cid", "TC0ONETIME");//가맹점번호(개발자용 테스트값)
		body.add("partner_order_id", vo.getPartner_order_id());//주문번호(랜덤)
		body.add("partner_user_id", vo.getPartner_user_id());//사용자번호
		body.add("item_name", vo.getItem_name());//상품명
		body.add("quantity", String.valueOf(vo.getQuantity()));//상품수량
		body.add("total_amount", String.valueOf(vo.getTotal_amount()));//상품판매가
		body.add("vat_amount", String.valueOf(vo.getVat_amount()));//부가세액(생략가능)
		body.add("tax_free_amount", String.valueOf(vo.getTax_free_amount()));//비과세액
		
		String baseUrl = ServletUriComponentsBuilder
										.fromCurrentContextPath()
										.port(8080)
										.path("/pay/kakao/")
										.toUriString();
		body.add("approval_url", baseUrl + "success");
		body.add("fail_url", baseUrl + "fail");
		body.add("cancel_url", baseUrl + "cancel");

//		테스트용 코드
//		body.add("approval_url", "http://localhost:8080/sts28/success");
//		body.add("fail_url", "http://localhost:8080/sts28/fail");
//		body.add("cancel_url", "http://localhost:8080/sts28/cancel");
//		헤더+바디
		HttpEntity<MultiValueMap<String, String>> entity
											= new HttpEntity<>(body, headers);
		
		URI uri = new URI("https://kapi.kakao.com/v1/payment/ready");

		KakaoPayReadyReturnVO returnVO = 
				template.postForObject(uri, entity, KakaoPayReadyReturnVO.class);
		log.info("vo = {}", vo);

		
//		DB처리 (카카오페이 결제 준비 요청 전송 이후)
		PayDto payDto = PayDto.builder()
										.cid("TC0ONETIME")
										.tid(returnVO.getTid())
										.partner_order_id(vo.getPartner_order_id())
										.partner_user_id(vo.getPartner_user_id())
										.process_time(returnVO.getCreated_at())
										.item_name(vo.getItem_name())
										.quantity(vo.getQuantity())
										.total_amount(vo.getTotal_amount())
										.status("준비")
										.build();
		
		
		
		payDao.insertReady(payDto);
		return returnVO;
	}

	@Override
	public KakaoPaySuccessReturnVO approve(KakaoPaySuccessReadyVO vo) throws URISyntaxException {
	RestTemplate template = new RestTemplate();
		

		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "KakaoAK 80a1800fa42c30d9191e0af0f2c2c97d");
		headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE+"; charset=utf-8");
		headers.add("Accept", MediaType.APPLICATION_JSON_UTF8_VALUE);
		

		MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
		body.add("cid", vo.getCid());//가맹점번호(개발자용 테스트값)
		body.add("tid", vo.getTid());//주문번호(랜덤)
		body.add("partner_order_id", vo.getPartner_order_id());
		body.add("partner_user_id", vo.getPartner_user_id());
		body.add("pg_token", vo.getPg_token());
		
		
		HttpEntity<MultiValueMap<String, String>> entity
											= new HttpEntity<>(body, headers);
		
		URI uri = new URI("https://kapi.kakao.com/v1/payment/approve");

		KakaoPaySuccessReturnVO returnVO = 
				template.postForObject(uri, entity, KakaoPaySuccessReturnVO.class);
		log.info("vo = {}", vo);

//		DB승인 완료 처리
		
		PayDto payDto = PayDto.builder()
												.aid(returnVO.getAid())
												.cid("TC0ONETIME")
												.tid(returnVO.getTid())
												.partner_order_id(vo.getPartner_order_id())
												.partner_user_id(vo.getPartner_user_id())
												.process_time(returnVO.getCreated_at())
												.item_name(returnVO.getItem_name())
												.quantity(returnVO.getQuantity())
												.total_amount(returnVO.getAmount().getTotal())
												.status("완료")
												.build();

		
		payDao.insertSuccess(payDto);
		
		return returnVO;
	}

	@Override
	public KakaoPayRevokeReturnVO revoke(int no) throws URISyntaxException {
		// template = uri +entity
		
		PayDto payDto = payDao.get(no);
		
		RestTemplate template = new RestTemplate();
		
		HttpHeaders header = new HttpHeaders();
		header.add("Authorization", "KakaoAK 80a1800fa42c30d9191e0af0f2c2c97d");
		header.add("Content-Type", "application/x-www-form-urlencoded; charset = UTF-8"); 
		header.add("accept", "application/json; charset=UTF-8");
		
		MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
		body.add("cid", payDto.getCid());
		body.add("tid", payDto.getTid());
		body.add("cancel_amount", String.valueOf(payDto.getTotal_amount()));
		body.add("cancel_tax_free_amount", "0");
//		body.add("cancel_vat_amount", "");
		body.add("cancel_available_amount", String.valueOf(payDto.getTotal_amount()));
		
		HttpEntity<MultiValueMap<String, String>> entity= new HttpEntity<>(body, header);
		URI uri = new URI("https://kapi.kakao.com/v1/payment/cancel");
	
		
		KakaoPayRevokeReturnVO returnVO=
				template.postForObject(uri, entity, KakaoPayRevokeReturnVO.class);
		
		
		PayDto payDto2=PayDto.builder()
											.aid(returnVO.getAid())
											.cid(returnVO.getCid())
											.tid(returnVO.getTid())
											.partner_order_id(returnVO.getPartner_order_id())
											.partner_user_id(returnVO.getPartner_user_id())
											.process_time(returnVO.getCreated_at())
											.item_name(returnVO.getItem_name())
											.quantity(returnVO.getQuantity())
											.total_amount(-1*returnVO.getCanceled_amount().getTotal())
											.status("취소")
										.build();
		
		payDao.insertRevoke(payDto2);
		
		
		return returnVO;
	}

}
