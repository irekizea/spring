package com.kh.sts25.websocket;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * 전체에게 메시지 뿌리는 서버
 * -필요한 내용 : 다수의 접속 사용자 WebSocket 정보
 * 
 */

@Slf4j
public class BroadCastServer extends TextWebSocketHandler{
	//사용자 저장용 저장소
	private Set<WebSocketSession> userList = new HashSet<>();
	
	
	
	private void broadcast(String msg) throws IOException {
		TextMessage message = new TextMessage(msg);
		for(WebSocketSession user : userList) {
			user.sendMessage(message);
		}
	}
	// 연결 수립 메소드
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		userList.add(session);
		log.info("사용자 접속-현재사용자{}명", userList.size());
		
		String text = "집갈래";
		broadcast(text);
		
	}
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		userList.remove(session);
		String text = "잘가"+userList.size()+"명남았어";
		broadcast(text);
	}
	
}

