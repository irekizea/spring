package com.kh.sts15.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.sts15.entity.FileDto;

@Repository
public class PhysicalFileDaoImpl implements PhysicalFileDao{

	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void regist(FileDto fileDto) {
		
		System.out.println(fileDto.getMember_no()+" sadfasfsa"+fileDto.getProfile_size()+fileDto.getProfile_uploadname());
		
		String sql = "insert into member_profile values(member_profile_seq.nextval, ?, ?, ?, ?)";
		Object[] param = {
				fileDto.getMember_no(),
				fileDto.getProfile_uploadname(),
				fileDto.getProfile_size(),
				fileDto.getMember_no()
		};
		jdbcTemplate.update(sql, param);
		
	}



}
