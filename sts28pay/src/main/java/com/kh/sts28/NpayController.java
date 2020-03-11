package com.kh.sts28;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class NpayController {
	
	@GetMapping("pay0")
	public String home() {
		return "npay";
	}
	@GetMapping("test0")
	public String test() {
		return "test";
	}

}
