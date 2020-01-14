package com.kh.sts10;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {
	@RequestMapping("/test")
	public String home () {
		return "test";
	}
	
	@RequestMapping(value="/test2", method=RequestMethod.GET)
	public String home2() {
		return "test2";
	}
	
}
