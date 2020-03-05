package com.dz.test.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder @Data @NoArgsConstructor @AllArgsConstructor
public class RowDto {
	private String cusn;
	private String req_time, fin_time;
	private String isdone;
}
