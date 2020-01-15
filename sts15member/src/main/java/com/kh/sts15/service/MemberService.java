package com.kh.sts15.service;

import java.io.IOException;

import com.kh.sts15.vo.MemberVo;

public interface MemberService {
	void store(MemberVo vo) throws IllegalStateException, IOException;
		
}
