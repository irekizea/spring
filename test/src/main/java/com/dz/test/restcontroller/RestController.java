package com.dz.test.restcontroller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dz.test.entity.RowDto;


@RequestMapping("/waiting")
@org.springframework.web.bind.annotation.RestController
public class RestController {

	@Autowired
	private SqlSession sqlSession;
	
	@PostMapping("getlist")
	public List<RowDto> getList(){
		
		
		
		return null;
	}
	
	
}
