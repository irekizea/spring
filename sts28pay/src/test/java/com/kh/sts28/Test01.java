package com.kh.sts28;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.UUID;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.kh.sts28.vo.KakaoPayReadyReturnVO;

import lombok.extern.slf4j.Slf4j;

//PG사(카카오페이)에 결제 준비를 요청
// - 문제 : 서버에서 다른 서버로 신호를 보내야 하는데... 어떻게?
@Slf4j
public class Test01 {
	
//	private Logger log = LoggerFactory.getLogger(getClass());

	@Test
	public void requestPay() throws URISyntaxException {
		log.info("결제 요청 시작!");
		
//		요청 전송 및 응답 수신 도구
//		- 필요한 모든 정보를 설정한 뒤 전송(POST)
//		- 헤더 : Authorization 정보(admin 키 추가)
//		- 바디 : 결제와 관련된 정보(가맹점, 거래번호, 사용자번호, 상품명, ...)
		RestTemplate template = new RestTemplate();
		
//		헤더 생성
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "KakaoAK 80a1800fa42c30d9191e0af0f2c2c97d");
//		headers.add("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
		headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE+"; charset=utf-8");
		headers.add("Accept", MediaType.APPLICATION_JSON_UTF8_VALUE);
		
//		바디 생성
		MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
		body.add("cid", "TC0ONETIME");//가맹점번호(개발자용 테스트값)
		body.add("partner_order_id", UUID.randomUUID().toString());//주문번호(랜덤)
		body.add("partner_user_id", "1000");//사용자번호
		body.add("item_name", "비싼거");//상품명
		body.add("quantity", "1");//상품수량
		body.add("total_amount", "1000");//상품판매가
		body.add("vat_amount", "10");//부가세액(생략가능)
		body.add("tax_free_amount", "0");//비과세액
		body.add("approval_url", "http://localhost:8080/sts28/success");
		body.add("fail_url", "http://localhost:8080/sts28/fail");
		body.add("cancel_url", "http://localhost:8080/sts28/cancel");
		
//		헤더+바디
		HttpEntity<MultiValueMap<String, String>> entity
											= new HttpEntity<>(body, headers);
		
//		요청주소 생성
		URI uri = new URI("https://kapi.kakao.com/v1/payment/ready");
		
//		전송 및 응답 저장(KakaoPayReadyReturnVO)
		KakaoPayReadyReturnVO vo = 
				template.postForObject(uri, entity, KakaoPayReadyReturnVO.class);
		log.info("vo = {}", vo);
	}
	
}

