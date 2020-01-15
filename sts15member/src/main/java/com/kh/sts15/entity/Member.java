package com.kh.sts15.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {
	private int member_no;
	private String member_id ;
	private String member_pw;
	private String member_nick;
	
	
	
}
