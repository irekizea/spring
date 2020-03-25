package com.kh.sts25.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class ChatDto {
	
	private String id;
	private String text;
	private int room;
	
	
}
