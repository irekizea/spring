package com.kh.sts15.repository;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.sts15.entity.FileDto;



@Repository
public class PhysicalFileDaoImpl implements PhysicalFileDao{
	
	
	private File directory = new File("D:/upload/filetest");
	
//	@PostConstruct
//	public void init() {
//		directory.mkdirs();
//	}
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void regist(FileDto fileDto) {
		
	
		
		System.out.println(fileDto.getMember_no()+" sadfasfsa");
		
		String sql = "insert into member_profile values(member_profile_seq.nextval, ?, ?, ?, ?)";
		Object[] param = {
				fileDto.getMember_no(),
				fileDto.getProfile_uploadname(),
				fileDto.getProfile_size(),
				fileDto.getMember_no()
		};
		jdbcTemplate.update(sql, param);
		
	}

	@Override
	public byte[] get(int profile_no) throws IOException {
		File file = new File(directory, String.valueOf(profile_no));
		byte[] data = FileUtils.readFileToByteArray(file);
		return data;
	}



}
