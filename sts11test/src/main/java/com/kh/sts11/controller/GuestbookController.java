package com.kh.sts11.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.sts11.entity.GuestBook;
import com.kh.sts11.repository.GuestBookDao;

@Controller
@RequestMapping("/guestbook")
public class GuestbookController {
	
	@Autowired
	private GuestBookDao guestBookDao;
	
	@GetMapping("/home")
	public String home() {
		return "guestbook/home";
	}
	
	@GetMapping("/insert")
	public String insert( 
		@RequestParam String content) {
		GuestBook g = new GuestBook();
		g.setContent(content);
		guestBookDao.gRegist(g);
		
		return "guestbook/home";
		
	}
	@GetMapping("/write")
	public String write() {
			return "guestbook/write";
	}
	@GetMapping("/list")
	public String list(Model model) {
		List<GuestBook> list = guestBookDao.getList();
		model.addAttribute("list", list);
		return "guestbook/list";
	}
	

}
