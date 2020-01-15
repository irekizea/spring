package com.kh.sts14.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.sts14.dto.UploadFileDto;

@Repository
public class UploadFileDaoImpl implements UploadFileDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void regist(UploadFileDto uploadFileDto) {
		
		
		String sql = "insert into upload_file values(upload_file_seq.nextval, ?, ?, ?)";
		Object[] param = {
			uploadFileDto.getOrigin_name(),
			uploadFileDto.getStore_name(),
			uploadFileDto.getUploader()
			
		};
		
		jdbcTemplate.update(sql, param);
	}

}
