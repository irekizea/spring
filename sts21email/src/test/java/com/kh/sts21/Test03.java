package com.kh.sts21;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
@WebAppConfiguration
public class Test03 {
	@Autowired
	private JavaMailSender sender;
	
	@Test
	public void sendMimeMessage() throws MessagingException, UnsupportedEncodingException {
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper =
					new MimeMessageHelper(message, true, "UTF-8");
		
		String[] to = {"irekizea@gmail.com"};
		helper.setTo(to);
		
		helper.setSubject("테스트");
		helper.setText("<h1>test</h1>", true);

		DataSource source = new FileDataSource("D:/img3.jpg");
		helper.addAttachment("흥", source);
		
		helper.addInline("test", source);
		
		sender.send(message);
	}

}
