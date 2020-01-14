package com.kh.sts13.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.kh.sts13.entity.Product;

@Repository
public class ProductDaoImp {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private RowMapper<Product> mapper = new RowMapper<Product>() {
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException{
		return Product.builder()
				.no(rs.getInt("no"))
				.when(rs.getString("when"))
				.price(rs.getInt("price"))
				.name(rs.getString("name"))
			.build();
	}
	};

	public void pRegist(Product product) {
		String sql = "insert into product values(product_seq.nextval, ?, ?, sysdate)";
		Object[] param = {
				product.getName(),
				product.getPrice()
		};
		jdbcTemplate.update(sql, param);
	}
	
		
		
		
	
}
