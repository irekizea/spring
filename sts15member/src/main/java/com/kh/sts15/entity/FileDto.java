package com.kh.sts15.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class FileDto {
	private int profile_no;
	private String profile_uploadname;
	private String profile_savename;
	private int member_no;
	private long profile_size;

}
