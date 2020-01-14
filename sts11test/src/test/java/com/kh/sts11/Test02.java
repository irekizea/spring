package com.kh.sts11;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * 
 *  기존 만들어 놓은 환경과 연계 테스트
 * -root-context.xml(전역설정)
 * -servlet-context.xml(서블릿 설정)
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
		
})
@WebAppConfiguration
public class Test02 {

		@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Test
	public void insert() {
		System.out.println(jdbcTemplate);
		
		
		String sql = "insert into student values(student_seq.nextval, ?, ?)";
		
//		Object[] param = {"hong", 50};
//		jdbcTemplate.update(sql, param);
		
		jdbcTemplate.update(sql, "hong", 50);
	}
	
}
