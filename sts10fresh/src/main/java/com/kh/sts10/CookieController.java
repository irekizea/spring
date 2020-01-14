package com.kh.sts10;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ck")
public class CookieController {

	@GetMapping("/home")
	public String home() {
			return "cookie/home";
		
	}
	
	@GetMapping("/create")
	public String createCookie(HttpServletResponse response) throws UnsupportedEncodingException {
			// making cookie: similar with file
			// cookie 객체 생성	
//			Cookie ck = new Cookie("id", "spika"); 
			Cookie ck = new Cookie("id", URLEncoder.encode("글자", "UTF-8"));
		
			// 객체 정보 설정
			// 유효 시간, 사용범위, 
			ck.setMaxAge(24*60*60);
			// 응답 객체 출력 request
			response.addCookie(ck);
			
			return "redirect:./home";
		
			
	
	}
	
	@GetMapping("/remove")
	public String removeCookie(HttpServletResponse response) throws UnsupportedEncodingException {
		Cookie ck = new Cookie("id", URLEncoder.encode("글자", "UTF-8"));
		ck.setMaxAge(0);
		response.addCookie(ck);
		
		return "redirect:./home";

	}

}
