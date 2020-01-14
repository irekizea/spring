package com.kh.sts11.repository;

import java.util.List;

import com.kh.sts11.entity.GuestBook;

public interface GuestBookDao {
	void gRegist(GuestBook guestBook);
	List<GuestBook> getList();

}
