package com.kh.sts15.repository;

import com.kh.sts15.entity.MemberProfileDto;

public interface MemberProfileDao {
	void regist(MemberProfileDto memberProfileDto);

	MemberProfileDto get(int profile_no);
}