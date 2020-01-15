package com.kh.sts15.vo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class MemberVo {
	private String member_id;
	private String member_pw;
	private String member_nick;
	private List<MultipartFile> file;
}
