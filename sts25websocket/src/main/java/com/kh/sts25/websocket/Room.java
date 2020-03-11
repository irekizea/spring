package com.kh.sts25.websocket;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

// 채팅방 클래스
public class Room {
	
	// 방 접속 사용자 목록
	private Set<WebSocketSession> userList = new HashSet<>();
	
	// 신규 인원 추가 하는 메소드
	public void add(WebSocketSession session) throws IOException {
		userList.add(session);
		broadcast(session, "안녕");
	}
	
	public void remove(WebSocketSession session) throws IOException {
		userList.remove(session);
		broadcast(session, "잘가");
	}

	// 방 인원 메시지 전송 메소드
	
	public void broadcast(WebSocketSession user, String text) throws IOException {
		
		String id = (String)user.getAttributes().get("id");
		TextMessage message = new TextMessage("["+id+"]"+text);
		for(WebSocketSession session :userList) {
			session.sendMessage(message);
		}
		
	}
	
	public int count() {
		return userList.size();
		
	}
	
	public boolean isEmpty() {
		
		return count()==0;
	}
	
	
}
