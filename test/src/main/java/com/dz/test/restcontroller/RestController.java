package com.dz.test.restcontroller;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dz.test.entity.RowDto;

import lombok.extern.slf4j.Slf4j;


@RequestMapping("/waiting")
@Slf4j
@org.springframework.web.bind.annotation.RestController
public class RestController {

	@Autowired
	private SqlSession sqlSession;
	
	@PostMapping("getlist")
	public List<RowDto> getList(){
		
		List<RowDto> list = new ArrayList<>();
		
		log.info("check1");
		
		list = sqlSession.selectList("waiting.getList");

		return list;
	}
	
	@PostMapping("getQueNum")
	public int getQue(@RequestParam String cusname) {
		log.info("check={}", cusname);
		 sqlSession.selectOne("waiting.getQue", cusname);
		
		return 1;
	}
	
	
}
