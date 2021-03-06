package com.kh.sts08;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.kh.sts08.repository.MemberDao;
import com.kh.sts8.entity.MemberDto;

public class TestController implements Controller{
	
	private MemberDao memberDao;
	public void setMemberDaoImpl(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if(request.getMethod().equalsIgnoreCase("get")) {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("test");
			return mv;
		}else if(request.getMethod().equalsIgnoreCase("post")){
			request.setCharacterEncoding("UTF-8");
					MemberDto memberDto = new MemberDto();
					memberDto.setId(request.getParameter("id"));
					memberDto.setPw(request.getParameter("pw"));
					memberDto.setName(request.getParameter("name"));
					memberDto.setPhone(request.getParameter("phone"));
					System.out.println(memberDto.getPhone()+"폰 확인");
			ModelAndView mv = new ModelAndView();
			mv.setViewName("redirect:/");
			return mv;
		}
		return null;
	}
	
	

}
