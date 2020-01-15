package com.kh.sts15;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.sts15.entity.Member;
import com.kh.sts15.repository.MemberDao;
import com.kh.sts15.service.MemberService;
import com.kh.sts15.vo.MemberVo;

@Controller
public class MemberController {

	@Autowired
	private MemberDao memberDao;
	
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
//	@PostMapping("regist")
	public String regist(@RequestParam String member_id, String member_pw, String member_nick){
		
		Member m = new Member();
		m.setMember_id(member_id);
		m.setMember_pw(member_pw);
		m.setMember_nick(member_nick);
		memberDao.regist(m);
		
		
		return "welcome";
	}
	
	@Autowired
	private MemberService memberService;

	@PostMapping("regist")
	public String regist2(@ModelAttribute MemberVo vo) throws IllegalStateException, IOException {
	 memberService.store(vo);
	 return "welcome";
	}
	
	
}
