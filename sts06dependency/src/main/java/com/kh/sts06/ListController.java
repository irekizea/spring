package com.kh.sts06;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.kh.sts06.beans.MemberDao;
import com.kh.sts06.beans.MemberDto;

public class ListController implements Controller{

	private MemberDao memberDao;
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
			List<MemberDto> list = memberDao.search("id", null);
			
			ModelAndView mv = new ModelAndView();
			mv.setViewName("list");//WEB-INF/views/list.jsp
			mv.addObject("list", list);
			
		return mv;
	}

}
