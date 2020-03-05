package com.dz.test.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder @Data @NoArgsConstructor @AllArgsConstructor
public class RowDto {
	private String who;
	private String date, finishtime;
	private int isfinish;
}
