package com.kh.sts28.controller;

import java.net.URISyntaxException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.sts28.entity.PayDto;
import com.kh.sts28.repository.PayDao;
import com.kh.sts28.service.PayService;
import com.kh.sts28.vo.KakaoPayReadyVO;
import com.kh.sts28.vo.KakaoPayRevokeReturnVO;
import com.kh.sts28.vo.KakaoPaySuccessReadyVO;
import com.kh.sts28.vo.KakaoPaySuccessReturnVO;
import com.kh.sts28.vo.PayReadyReturnVO;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/pay/kakao")
@Slf4j
public class KakaoPayController {
	
	@Autowired
	private PayService payService;
	
	@GetMapping("/confirm")
	public String confirm() {
		return "pay/confirm";
	}
	
	// 결제 준비(요청)
	@PostMapping("/confirm")
	public String confirm(@ModelAttribute KakaoPayReadyVO vo, HttpSession session) throws URISyntaxException {
		PayReadyReturnVO result = payService.ready(vo);
		
		
		
		session.setAttribute("tid", result.getTid());
		session.setAttribute("ready", vo);
		log.info("tid ={}",  result.getTid());
//		db 필요내용 저장 success 쓸 수 있게 세션 추가
		return "redirect:"+result.getNext_redirect_pc_url();
		
		
	}
	
	@GetMapping("/success")
	public String success(@RequestParam String pg_token, HttpSession session, Model model) throws URISyntaxException  {
//		세션 전달 값 꺼내고 세션 값 삭제
		String tid = (String)session.getAttribute("tid");
		KakaoPayReadyVO vo = (KakaoPayReadyVO)  session.getAttribute("ready");
		log.info("tid ={}", tid);
		log.info("vo = {}", vo);
		session.removeAttribute("tid");
		session.removeAttribute("ready");
		
		
		log.info("pg_token={}", pg_token);
		
//		payService 를 이ㅛㅇㅇ하여 결제 승인 처리를 수행
//		-KakaoPaySuccessReadyVo 형태의 매개변수 필요
//		-KakaoPaySuccessREturnVO 형태 반환값 저장 필요
		KakaoPaySuccessReadyVO data = KakaoPaySuccessReadyVO.builder().
																							cid("TC0ONETIME")
																							.tid(tid)
																							.partner_order_id(vo.getPartner_order_id())
																							.partner_user_id(vo.getPartner_user_id())
																							.pg_token(pg_token)
																							.build();
		
		KakaoPaySuccessReturnVO result = payService.approve(data);
		
		model.addAttribute("result", result);
		
		
		return "pay/success";
	}
//	@GetMapping("/fail")
//	public String fail() {
//		
//	}
//	@GetMapping("/cancel")
//	public String cancel() {
//		
//	}
	
	@Autowired
	private PayDao payDao;
	
	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("list", payDao.getList());
		return "pay/list";
		
	}
	
	@GetMapping("/revoke")
	public String revoke(@RequestParam int no) throws URISyntaxException {

		KakaoPayRevokeReturnVO vo = payService.revoke(no);
		return "redirect:list";
	}
	
	
	
}
