package com.kh.sts11.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.kh.sts11.entity.Student;

@Repository
public class StudentDaoImp implements StudentDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private RowMapper<Student> mapper = new RowMapper<Student>(){
		@Override
		public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
			Student s = new Student();
			s.setNo(rs.getInt("no"));
			s.setName(rs.getString("name"));
			s.setScore(rs.getInt("score"));
			return s;
		}
	};
	
	
	public void regist(Student student) {
		String sql = "insert into student values(student_seq.nextval, ?, ?)";
		Object[] param = {student.getName(), student.getScore()};
		jdbcTemplate.update(sql, param);
	}

	@Override
	public List<Student> getList() {
		String sql = "select * from student order by no asc";
		jdbcTemplate.query(sql, mapper);
		List<Student> list = jdbcTemplate.query(sql, mapper);
		return list;
	}

	public List<Student> getSearch(String keyword) {
		String sql = "select * from student where name=?";
		List<Student> list = jdbcTemplate.query(sql, mapper, keyword);
		return list;
	}

}
