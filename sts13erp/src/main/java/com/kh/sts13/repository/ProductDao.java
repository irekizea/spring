package com.kh.sts13.repository;

import java.util.List;

import com.kh.sts13.entity.Product;

public interface ProductDao {
	void pRegist(Product product);
	List<Product> getList(String type, String keyword);
}
