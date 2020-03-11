package com.kh.sts28;

import java.net.URISyntaxException;
import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.kh.sts28.entity.PayDto;
import com.kh.sts28.service.PayService;
import com.kh.sts28.vo.KakaoPayReadyReturnVO;
import com.kh.sts28.vo.KakaoPayReadyVO;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {
	"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
@WebAppConfiguration
@Slf4j
public class Test03 {

	@Autowired
	private SqlSession sqlSession; 
	
	@Autowired
	private PayService payService;
	
	@Test
	public void test() throws URISyntaxException{
//		KakaoPayReadyVO vo = KakaoPayReadyVO.builder()
//				.partner_order_id(UUID.randomUUID().toString())
//				.partner_user_id("흥")
//				.item_name("비싼거")
//				.quantity(2)
//				.total_amount(500)
//				.vat_amount(10)
//				.build();
//		KakaoPayReadyReturnVO result = (KakaoPayReadyReturnVO) payService.ready(vo);
//		log.info("tid={}", result.getTid());
	 
		PayDto payDto = PayDto.builder()
									
									.cid("TC0ONETIME")
									.tid("T2721329697647291082")
									.partner_order_id("null")
									.partner_user_id("비싼곳")
									.process_time("2020-01-29T10:29:06")
									.item_name("비싼거")
									.quantity(1)
									.total_amount(1000)
									.aid("A2721335547393221802")
									.build();
		
		sqlSession.insert("pay.ready", payDto);
	}

	

}
