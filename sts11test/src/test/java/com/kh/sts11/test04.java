package com.kh.sts11;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.kh.sts11.entity.Student;
import com.kh.sts11.repository.StudentDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})

@WebAppConfiguration
public class test04 {
	@Autowired
	private StudentDao studentDao;
	
//	@Test
	public void test() {
		Student s = new Student();
		s.setName("asd");
		s.setScore(23);
		studentDao.regist(s);
	}
	
//	@Test
	public void listTest(){
		List<Student> list =studentDao.getList();
		System.out.println(list.size());
	}
	
	@Test
	public void searchTest() {
		List<Student> list = studentDao.getSearch("asd");
//		Student student = list.get(0); 하나만 있을 경우
		System.out.println(list);
	}
	
	

}
