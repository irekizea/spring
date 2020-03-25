package com.kh.sts25.restcontroller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.sts25.entity.ChatDto;


@RestController
@RequestMapping("chatt")
public class ChatrController {

	
	@Autowired
	private SqlSession sqlSession;
	
	@PostMapping("/chatin")
	public void chatin(@RequestParam String id, String text, int room) {
			ChatDto chat = ChatDto.builder()
					.id(id)
					.text(text)
					.room(room)
					.build();

			sqlSession.insert("chat.text", chat);
	}
	}
