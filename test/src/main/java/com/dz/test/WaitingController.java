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
}
