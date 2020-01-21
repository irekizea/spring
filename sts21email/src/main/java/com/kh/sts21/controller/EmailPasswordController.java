package com.kh.sts21.controller;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.sts21.repository.CertDao;
import com.kh.sts21.service.EmailService;

@Controller
@RequestMapping("/pw")
public class EmailPasswordController {
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private CertDao certDao;
	
	@GetMapping("/input")
	public String input() {
		
		return "pw/input";
	}
	@PostMapping("/input")
	public String input(@RequestParam String email) throws MessagingException {
		emailService.sendChangePasswordMail(email);
		return "redirect:result";
	}
	
	@GetMapping("/result")
	public String result() {
		return "pw/result";
	}
	
	@GetMapping("/change")
	public String change(
			@RequestParam String cert,
			@RequestParam String email,
			HttpServletResponse response) {
		//사용자 이메일 링크 누르면 들어옴
		//-들어오면서 정상적 링크시 cert와 파라미트 email이라는 파라미터 가지고옴
		// 위의 두 파라미터 받아서 db검증 실시
		boolean enter = certDao.check(email, cert);
		certDao.delete(email);
		if(!enter) {
			response.setStatus(403);
		}
		return "pw/change";
	}

}
