package com.kh.sts11.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.kh.sts11.entity.GuestBook;

@Repository
public class GuestBookDaoImp implements GuestBookDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;

		private RowMapper<GuestBook> mapper = new RowMapper<GuestBook>() {
		
			@Override
			public GuestBook mapRow(ResultSet rs, int rowNum) throws SQLException{
				GuestBook g = new GuestBook();
				g.setContent(rs.getString("content"));
				return g;
			}
};
	public void gRegist(GuestBook guestBook) {
		String sql = "insert into guestbook values(sysdate, ?)";
		Object[] param = {guestBook.getContent()};
		jdbcTemplate.update(sql, param);
	}
	public List<GuestBook> getList(){
		String sql = "select * from guestbook order by wdate desc";
		List<GuestBook> list = jdbcTemplate.query(sql, mapper);
		return list;
	}

}
