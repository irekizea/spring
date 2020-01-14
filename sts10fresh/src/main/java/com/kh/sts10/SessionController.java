package com.kh.sts10;


import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/session")
public class SessionController {

//	@GetMapping("")//		/session
//	@GetMapping("/")//	/session/
	@GetMapping({"", "/"})//둘다
	public String home() {
		return "session/home";
	}

	@GetMapping("/set")
	public String set(HttpSession session) {
		session.setAttribute("id", "admin");
//		return "session/home";
//		return "redirect:./";
		return "redirect:/session/";
	}

	@GetMapping("/remove")
	public String remove(HttpSession session) {
		session.removeAttribute("id");
		return "redirect:./";
	}
}
