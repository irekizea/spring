package com.dz.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/waiting")
public class WaitingController {

	@GetMapping("admin")
	public String admin() {
		return "waiting/admin";
	}
	@GetMapping("cus1")
	public String cus1() {
		return "waiting/cus1";
	}
	@GetMapping("cus2")
	public String cus2() {
		return "waiting/cus2";
	}
	@GetMapping("cus3")
	public String cus3() {
		return "waiting/cus3";
	}
	@GetMapping("cus4")
	public String cus4() {
		return "waiting/cus4";
	}
	@GetMapping("cus5")
	public String cus5() {
		return "waiting/cus5";
	}
}
