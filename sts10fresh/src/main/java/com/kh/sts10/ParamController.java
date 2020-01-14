package com.kh.sts10;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.sts10.entity.StudentVO;

@Controller
@RequestMapping("/param")
public class ParamController {
	
	@RequestMapping("/test")
	public String param() {
		return "param";
	}

//	@RequestMapping(value="/test", method=RequestMethod.POST)
	public String param(HttpServletRequest request) {
		String name = request.getParameter("name");
		int korean = Integer.parseInt(request.getParameter("korean"));
		int english = Integer.parseInt(request.getParameter("english"));
		
		System.out.println(name + "dd"+korean+"dd"+english);
//		return "redirect:/param/test";
		return "redirect:test";
	}
	
//	automatic spring
//	@RequestMapping(value="/test", method=RequestMethod.POST)
	public String param(
			@RequestParam String name,
			@RequestParam(required = false, defaultValue = "0") int korean,
			@RequestParam int english) {
		System.out.println(name + "  "+korean+"  "+english);
		return "redirect:test";
		
	}
	@RequestMapping(value="/test", method=RequestMethod.POST)
	public String param(@ModelAttribute StudentVO studentVO){
			System.out.println(studentVO);
			return "redirect:test";
	}
//	Pathvariable 사용 방법
//	 past address :/param/test?name=aaa&korean=100&english=50
//	 now address : /param/test/aaa/100/50
	@RequestMapping("/test2/{name}/{korean}/{english}")
	public String path(
			@PathVariable String name, 
			@PathVariable int korean, 
			@PathVariable int english) {
		
		System.out.println(name + "  "+korean+"  "+english);
		
		return "redirect:/param/test";
	} 
	
}
