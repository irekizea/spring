package com.kh.home.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.home.entity.MemberDto;
import com.kh.home.repository.MemberDao;



@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private MemberDao memberDao;

	@GetMapping("/regist")
	public String regist() {
		return"member/regist";
	}
	
	@PostMapping("/regist")
	public String regist(@ModelAttribute MemberDto memberDto) {
		memberDao.regist(memberDto);
		return "redirect:regist_success";
	}
	
	@GetMapping("/regist_success")
	public String regist_success() {
		return "member/regist_success";
	}
	
	@GetMapping("/login")
	public String login() {
		return "member/login";
	}
	@PostMapping("/login")
	public String login(HttpSession session, @ModelAttribute MemberDto memberDto) {
		
		MemberDto find = memberDao.login(memberDto);
		if(find == null) {
			return "redirect:login?error";
		}else {
			session.setAttribute("id", find.getId());
			session.setAttribute("grade", find.getGrade());
			memberDao.updateLastLogin(find.getId());
			return "redirect:/";
		}
		
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("id");
		session.removeAttribute("grade");
		return "redirect:/";
	}
}
