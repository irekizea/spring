package com.kh.sts03;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HomeController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
//		신규 생성 페이지 해결 위한 일
//		처리 끝 뷰 전달 req담기
//  	뷰페이지 위치 변환시 자동 연동 출력
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		
		return mv;
		
		
		
	}
	
	

}
