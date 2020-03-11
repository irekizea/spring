package com.kh.sts28;

import java.net.URISyntaxException;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.kh.sts28.repository.PayDao;
import com.kh.sts28.service.PayService;
import com.kh.sts28.vo.KakaoPayReadyReturnVO;
import com.kh.sts28.vo.KakaoPayReadyVO;

import lombok.extern.slf4j.Slf4j;


// 스프링 환견 연동해서 KakaoPayService 의 ready 가 정상 작동하는지 테스트

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {
	"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
@WebAppConfiguration
@Slf4j
public class Test02 {
	
	@Autowired
	private PayDao payDao;
	
	@Autowired
	private PayService payService;
	
	@Test
	public void test() throws URISyntaxException {
		
		KakaoPayReadyVO vo = KakaoPayReadyVO.builder()
				.partner_order_id(UUID.randomUUID().toString())
				.partner_user_id("흥")
				.item_name("비싼거")
				.quantity(2)
				.total_amount(500)
				.vat_amount(10)
				.build();
		
		KakaoPayReadyReturnVO result = (KakaoPayReadyReturnVO) payService.ready(vo);
		log.info("주소 = {}", result.getNext_redirect_pc_url());
		
		log.info("{}", payDao.getList());
	}

}
