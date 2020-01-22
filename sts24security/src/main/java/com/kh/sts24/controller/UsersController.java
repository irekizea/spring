package com.kh.sts24.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kh.sts24.entity.UserDto;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
public class UsersController {
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private SqlSession sqlSession;
	
	@GetMapping("join")
	public String join() {

		return "join";
	}
	
	
	@PostMapping("join")
	public String join(@ModelAttribute UserDto user) {
		
//		[1]user 들어있는 pw암호화(bcrypt(from secret core))
//		String origin = user.getPw();
//		String result = encoder.encode(origin);
//		user.setPw(result);
		user.setPw(encoder.encode(user.getPw()));

		
//		[2] db 저장
		sqlSession.insert("users.join", user);
		
		
		return "redirect:/login";
	}
	@GetMapping("login")
	public String login() {
		return "login";
	}
	@PostMapping("login")
	public String login(@ModelAttribute UserDto user) {
		
		UserDto find = sqlSession.selectOne("users.get", user);
		log.info("find = {}", find);
		if(find==null) {
			return "redirect:/login?error";
		}else {//id가 있으면 비밀번호 매칭 검사 : encoder.matches()
			
			boolean correct = encoder.matches(user.getPw(), find.getPw());
			log.info("user={}", user.getPw());
			log.info("find={}", find.getPw());
			log.info("correct = {}", correct);
			if(correct==true) {
			return "redirect:/";
			}else {
				return "redirect:/login?error";
			}
		}
	}
	

}


