package com.kh.sts15.repository;

import com.kh.sts15.entity.Member;

public interface MemberDao {
	void regist(Member member);
	int getSequence();
}
