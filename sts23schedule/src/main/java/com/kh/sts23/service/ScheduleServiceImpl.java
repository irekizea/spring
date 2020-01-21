package com.kh.sts23.service;

import java.time.LocalDateTime;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ScheduleServiceImpl implements ScheduleService{
	
	 
	/*
	 * 크론 표현식
	 * 
	 * 형식 : 초 분 시 일 월 요일
	 * 
	 * 사용 기호
	 *  - *: 매애버언
	 *  - / :주기(회차)
	 *  - - : 범위설정
	 *  
	 *  요일
	 *  - 월요일 :1 mon
	 *  
	 */
	
	
	@Override
//	@Scheduled(fixedRate = 1000)
	public void work() {
		log.info("work work work work work work work work");
		log.info("시각={}", LocalDateTime.now());
	}

	@Override
//	@Scheduled(cron="* * * * * *")
	public void work2() {
		log.info("work more work more work work work work work work: every seconds do work");
		
	}

	@Override
//	@Scheduled(cron="*/5 * * * * *")
	public void work3() {
		log.info("work more work more work work work work work work: every 5seconds do work more more");
		
	}

	@Override
//	@Scheduled(cron="*5-10 * * * * *")
	public void work4() {
		log.info("every 5to 10 sec");
		
	}

	@Override
//	@Scheduled(cron="0 0 * * * *")
	public void work5() {
		log.info("every on time");
		
	}

	@Override
//	@Scheduled(cron="* * * * * 7")
	@Scheduled(cron ="* * * L * ?")
	public void work6() {
		log.info("work6");
		
	}

}
