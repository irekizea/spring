package com.kh.sts18;


import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test01 {
	/**
	 * 로깅(logging)
	 * 기록 남기는 행위
	 * sysout과 같은 행위
	 * log4j, logback 등이 대표적
	 * 로그 확인 위한 각종 도구들(시간, 날짜, 형식 지원)
	 * 
	 * Logging Level
	 * 메시지 심각도 6단계 라이브러리마다 다름
	 * fatal 심각
	 * error 오류
	 * warn 경고
	 * info 정보
	 * debug 개발용
	 * trace 모든 상태
	 */
	
//	Logger logger= LoggerFactory.getLogger(Test01.class);
	Logger logger= LoggerFactory.getLogger(getClass());
	
	
	@Test
	public void test() {
		logger.debug("debug test");
		logger.info("info test");
		logger.warn("warn test");
		logger.error("error test");
	
	int a = 10;
	System.out.println("a=" +a);
	int b = 20;
	
	logger.debug("a ={}", a);
	logger.debug("a={}, b={}", a, b);
	
	}

}
