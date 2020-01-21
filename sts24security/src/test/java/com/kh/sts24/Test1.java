package com.kh.sts24;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Test1 {

	
//	@Test
	public void test1() {
		char a= 65;                                                                                                                                                                                                                                                                                                                                                                                                               
		log.info("전"+a);
		a+=5;
		log.info("후"+a);
		
		a-=5;
		
		log.info("복"+a);
		
		String text = "fu";
		
		log.info("암호전={}", text);
		StringBuffer buffer = new StringBuffer();
		for(int i =0; i<text.length(); i++) {
		
		
		char c = text.charAt(i);
		c += 5;
		buffer.append(c);
		}
		
		text = buffer.toString();
		log.info("암호시켰어={}", text);
		
		buffer = new StringBuffer();
		for(int i =0; i<text.length(); i++) {
		
		
		char c = text.charAt(i);
		c -= 5;
		buffer.append(c);
		}
		text = buffer.toString();
		log.info("암호풀었어={}", text);
		
		
	}
	
	@Test
	public void test2() {
		int a = 7;
		log.info("before={}", a);
		a ^=5;
		
		log.info("after={}", a);
		a ^=5;
		
		log.info("restore={}", a);
		
		String text = "fu";
		
		log.info("암호전={}", text);
		StringBuffer buffer = new StringBuffer();
		for(int i =0; i<text.length(); i++) {
		
		
		char c = text.charAt(i);
		c ^= 5;
		buffer.append(c);
		}
		
		text = buffer.toString();
		log.info("암호시켰어={}", text);
		
		buffer = new StringBuffer();
		for(int i =0; i<text.length(); i++) {
		
		
		char c = text.charAt(i);
		c ^= 5;
		buffer.append(c);
		}
		text = buffer.toString();
		log.info("암호풀었어={}", text);
		
		
	}
}
