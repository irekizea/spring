package com.kh.sts21.controller;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.sts21.entity.CertDto;
import com.kh.sts21.repository.CertDao;
import com.kh.sts21.service.RandomService;

@Controller
@RequestMapping("/pw")
public class EmailPasswordController {
	
	@Autowired
	private RandomService randomService;
	
	@Autowired
	private JavaMailSender sender;
	
	@Autowired
	private CertDao certDao;
	
	@GetMapping("/input")
	public String input() {
		
		return "pw/input";
	}
	@PostMapping("/input")
	public String input(@RequestParam String email) throws MessagingException {
		String cert = randomService.generateCertificationNumber(3);
		
		certDao.regist(CertDto.builder().email(email).cert_no(cert).build());
	
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
		
		helper.setTo(email);
		helper.setSubject("변경 메일 왔어");
		
		String url = "http://localhost:8080/sts21/pw/change?cert="+cert;

		StringBuffer buffer = new StringBuffer();
		buffer.append("<h1>비밀번호 변경을 위해 하단 링크를 누르세요</h1>");
		buffer.append("<h2>");
		buffer.append("<a href='");
		buffer.append(url);
		buffer.append("'>");
		buffer.append("이동");
		buffer.append("</a>");
		buffer.append("</h2>");
		helper.setText(buffer.toString(), true);
		
		sender.send(message);
		
		return "redirect:result";
	}
	
	@GetMapping("/result")
	public String result() {
		return "pw/result";
	}
	
	@GetMapping("/change")
	public String change(@RequestParam String cert) {
		return "pw/change";
	}

}
