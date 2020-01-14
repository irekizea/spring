package com.kh.sts13.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.sts13.entity.Product;
import com.kh.sts13.repository.ProductDao;

@Controller
public class ProductController {
	
	@Autowired
	private ProductDao productDao;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/insert")
	public String insert(
			@RequestParam String name, int price
			) {
		Product p = new Product();
		p.setName(name);
		p.setPrice(price);
		productDao.pRegist(p);
		return "redirect:/";
	}
	
	@GetMapping("/regist")
	public String regist() {
		return "regist";
	}
	
	@GetMapping("/search")
	public String search() {
		
		return "search";
	}
	
	@PostMapping("/search")
	public String searchlist(Model model, String keyword) {
		System.out.println(keyword);
		List<Product> list = productDao.getList(keyword);
		model.addAttribute("list", list);
		return "searchlist";
	}
	

	
	
}
