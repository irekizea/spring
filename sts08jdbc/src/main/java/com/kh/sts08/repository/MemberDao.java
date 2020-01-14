package com.kh.sts08.repository;
//used Dao Summary
//제어 위한 상위 형태
// 추상화 구조 사용 권장(스프링 제공 기능 적용 가능)

import com.kh.sts8.entity.MemberDto;

public interface MemberDao {
	void regist(MemberDto memberDto);
	
	
	
}
