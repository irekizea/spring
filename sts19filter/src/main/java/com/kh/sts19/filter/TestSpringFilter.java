package com.kh.sts19.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

//스프링 이용 가능케 bean 형태 생성
@Slf4j @Service("testFilter")
public class TestSpringFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		log.info("Spring test");
		chain.doFilter(request, response);
		
	}

}
