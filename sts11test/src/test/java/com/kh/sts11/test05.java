package com.kh.sts11;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.kh.sts11.entity.GuestBook;
import com.kh.sts11.repository.GuestBookDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})

@WebAppConfiguration
public class test05 {
	@Autowired
	private GuestBookDao guestBookDao;

	@Test
	public void test() {
		GuestBook g = new GuestBook();
		g.setContent("asdf");
		guestBookDao.gRegist(g);
	}
	
	
}
