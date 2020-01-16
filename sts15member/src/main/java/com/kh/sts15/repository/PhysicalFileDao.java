package com.kh.sts15.repository;

import java.io.IOException;

import com.kh.sts15.entity.FileDto;

public interface PhysicalFileDao {
	void regist(FileDto fileDto);

	byte[] get(int profile_no) throws IOException;
}
