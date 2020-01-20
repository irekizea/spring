package com.kh.sts21.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class GmailService implements EmailService{

	@Autowired
	private JavaMailSender sender;

	@Override
	public String sendCertMessage(String email, String cert) {
		try {
		
			SimpleMailMessage message = new SimpleMailMessage();
			String[] to = {email};
			String cer = cert;
			message.setTo(to);
			
			
			message.setSubject("인증이야");
			
			message.setText(cer);
			
			sender.send(message);
			
			return "success";
		}
		catch(Exception e) {
			e.printStackTrace();
			return "fail";
		}
		}
	}
	
