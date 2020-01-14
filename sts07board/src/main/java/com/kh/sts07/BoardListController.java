package com.kh.sts07;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.kh.sts07.entity.BoardDto;
import com.kh.sts07.repository.BoardDao;

public class BoardListController implements Controller{

		private BoardDao boardDao;
		public void setBoardDao(BoardDao boardDao) {
			this.boardDao = boardDao;
		}
		
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<BoardDto> list = boardDao.list(1, 10);
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("list", list);
		mv.setViewName("boardlist");
		
		
		return mv;
	}

}
