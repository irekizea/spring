package com.kh.sts08.repository;

import org.springframework.jdbc.core.JdbcTemplate;

import com.kh.sts8.entity.MemberDto;

// memberdao 구현체
// 실제 수행 코드 가짐
public class MemberDaoImpl implements MemberDao{

		//DB 처리 도구 자리 생성(injection)
	private JdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate=jdbcTemplate;
	}
	
	@Override
	public void regist(MemberDto memberDto) {
		String sql = "insert into member values(?, ?, ?, sysdate, '일반회원', 0, ?, ?, ?, ?, null)";
			System.out.println(memberDto.getId()+"id확인");
			Object[] param = { 
					memberDto.getId(),
					memberDto.getPw(),
					memberDto.getName(),
					memberDto.getPost(),
					memberDto.getBasic_addr(),
					memberDto.getExtra_addr(),
					memberDto.getPhone()
			};
		jdbcTemplate.update(sql, param);
		
	}
	
	

}
