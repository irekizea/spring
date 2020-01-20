package com.kh.sts21;

import java.util.Properties;

import org.junit.Before;
import org.junit.Test;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

public class Test01 {
	private JavaMailSender sender;
	
	@Before
	public void prepare() {
		//sender준비
		JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();
		senderImpl.setHost("smtp.gmail.com");
		senderImpl.setPort(587);
		senderImpl.setUsername("irekizea2@gmail.com");
		senderImpl.setPassword("gardenpleasure1!");
		
		Properties prop = new Properties();
		prop.put("mail.smtp.auth", true);
		prop.put("mail.smtp.starttls.enable", true);
		senderImpl.setJavaMailProperties(prop);
		
		sender = senderImpl;
	}
	
	@Test
	public void sendMail() {
		SimpleMailMessage message = new SimpleMailMessage();
		String[] to = {"whitefier@naver.com"};
		message.setTo(to);
		
		String[] cc = {"whitefier@hanmail.net"};
		message.setCc(cc);
		
		String[] bcc= {"irekizea@gmail.com"};
		message.setBcc(bcc);
		
		message.setSubject("cmosn");
		
		message.setText("tesst");
		
		sender.send(message);
	}
}
