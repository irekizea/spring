package com.kh.sts25.websocket;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
//public class WebSocketServer implements WebSocketHandler{
public class WebSocketServer extends TextWebSocketHandler{

	/**
	 * 접속 기능
	 * - WebSocketSession
	 * 		- 웹소켓 통신에서 사용자(브라우저) 정보를 저장하는 영역
	 * 		-id : 식별자(고유번호)
	 * 		-uri : 접속주소
	 */
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		log.info("안녕안녕 : session = {}", session);
	}

	/**
	 * 수신 기능
	 * - WebSocketSession
	 * 		- 보낸 사람의 웹소켓 정보
	 * - TextMessage
	 * 		- 사용자가 보낸 메시지 객체
	 * 		-payload : 메시지 본문
	 * byteCount : 수신한 내용의 크기
	 * 
	 */
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		log.info("수신");
		log.info("session = {}", session);
		log.info("message = {}", message);
		
		//메시지 전송 어떻게 하는가?
		// 대상 : session(WebSocketSession)
		// 내용 : message
		session.sendMessage(message);
	}

	/**
	 * 종료 기능
	 * - WebSocketSession
	 * 		- 나간 사람의 웹소켓 정보
	 * - CloseStatus
	 * 		- 나간 사람의 종료 상태 객체
	 */
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		log.info("바이!");
		log.info("session = {}", session);
		log.info("status = {}", status);
	}

}

	
	

