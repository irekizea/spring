package com.kh.sts21;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
@WebAppConfiguration
public class Test02 {

	@Autowired
	private JavaMailSender sender;
	
	@Test
	public void sendMail() {
		
		SimpleMailMessage message = new SimpleMailMessage();
		String[] to = {"whitefier@naver.com"};
		message.setTo(to);
		
		String[] cc = {"whitefier@hanmail.net"};
		message.setCc(cc);
		
		String[] bcc= {"irekizea@gmail.com"};
		message.setBcc(bcc);
		
		message.setSubject("cmond");
		
		message.setText("testd");
		
		sender.send(message);
	}
}
