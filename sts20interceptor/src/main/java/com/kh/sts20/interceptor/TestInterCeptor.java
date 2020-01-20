package com.kh.sts20.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import lombok.extern.slf4j.Slf4j;

/**
 *		 Interceptor
 *		-요청 가로채는 도구
 * 		- 총 3군데를 가로챌 수 있음
 *		- preHandle : DispatcherServlet 도착전
 *		  return true 속행, return false 는 차단
 *		- postHandle : Controller 수행 후
 *		- afterCompletion : view 생성 후
 *
 *
 */

@Slf4j
public class TestInterCeptor extends HandlerInterceptorAdapter{
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
		log.info("prehandle 실행");
		log.info("handler={}",handler.getClass());
		if(handler instanceof HandlerMethod) {
			HandlerMethod h = (HandlerMethod) handler;
			log.info("method = {}", h.getMethod().getName());
			log.info("annotation = {}", h.getMethodAnnotation(RequestMapping.class));
		}
		return true;
	}
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		log.info("postHandle이고");
		log.info("handler = {}", handler);
		log.info("mode&view = {}", modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

		log.info("afterCompletion 이야");
		log.info("handler = {}", handler);
		log.error("exception = {}", ex);
		
		// redirect 로 보내기 전 return false or true 반드시
		// 
	}
	
}


