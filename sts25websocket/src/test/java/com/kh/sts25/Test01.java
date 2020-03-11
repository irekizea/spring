package com.kh.sts25;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kh.sts25.vo.ChatData;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class Test01 {
	//jackson-databind 사용 JSON 형식 제어
	
	@Test
	
	public void test() throws JsonMappingException, JsonProcessingException {
		//"{"no":1, "text":"hello"}";
		
		String text = "{\"no\":1, \"text\":\"hello\"}";
		log.info("text ={}", text);
		
		ObjectMapper mapper = new ObjectMapper();
		ChatData data = mapper.readValue(text, ChatData.class);
		log.info("data = {}", data);
	}
	
	
}
