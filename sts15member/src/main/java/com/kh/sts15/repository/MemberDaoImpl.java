package com.kh.sts15.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.kh.sts15.entity.Member;

@Repository
public class MemberDaoImpl implements MemberDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private RowMapper<Member> mapper = (rs, rowNum)->
																	Member.builder()
																	.member_no(rs.getInt("member_no"))
																	.member_id("member_id")
																	.member_pw("member_pw")
																	.member_nick("member_nick")
																	.build();
	
	
																	
																	
		@Override
		public int getSequence() {
		String sql = "select member_seq.nextval from dual";
		int no = jdbcTemplate.queryForObject(sql,  Integer.class);
		return no;
//		return jdbcTemplate.queryForObject(sql,  int.class);
		}
	@Override
	public void regist(Member member) {
		System.out.println(member.getMember_id());
		
		String sql = "insert into member values(?, ?, ?, ?)";
		Object[] param = {
				member.getMember_no(),
				member.getMember_id(),
				member.getMember_pw(),
				member.getMember_nick()
		};
		jdbcTemplate.update(sql, param);
		
	}




}
