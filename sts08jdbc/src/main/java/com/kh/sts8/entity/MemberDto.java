package com.kh.sts8.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MemberDto {
	private String id;
	private String pw;
	private String name;
	private String joindate;
	private String grade;
	private int point;
	private String post;
	private String basic_addr;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJoindate() {
		return joindate;
	}
	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public String getPost() {
		return post;
	}
	
	public String getPostStr() {
		if(post==null)
		return " " ;
		else
			return phone;
	}
	
	public void setPost(String post) {
		this.post = post;
	}
	public String getBasic_addr() {
		return basic_addr;
	}
	
	public String getBasic_addrStr() {
		if(basic_addr==null) {
			return " ";
		}
		else
		return basic_addr;
	}
	
	
	public void setBasic_addr(String basic_addr) {
		this.basic_addr = basic_addr;
	}
	public String getExtra_addr() {
		return extra_addr;
		
	}
	
	public String getExtra_addrStr() {
		if(extra_addr==null)
			return " ";
		else
		return extra_addr;
	}
	
	
	public void setExtra_addr(String extra_addr) {
		this.extra_addr = extra_addr;
	}
	public String getPhone() {
		return phone;
	}
	public String getPhoneStr() {
		if(phone==null)
			return " ";
		else
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getLast_login() {
		return last_login;
	}
	public void setLast_login(String last_login) {
		this.last_login = last_login;
	}
	private String extra_addr;
	private String phone;
	private String last_login;
	public MemberDto(String id, String pw, String name, String joindate, String grade, int point, String post,
			String basic_addr, String extra_addr, String phone, String last_login) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.joindate = joindate;
		this.grade = grade;
		this.point = point;
		this.post = post;
		this.basic_addr = basic_addr;
		this.extra_addr = extra_addr;
		this.phone = phone;
		this.last_login = last_login;
	}
	public MemberDto() {
		super();
	}
	
	//주소를 통합하여 반환하는 getter
	
	public String getAddress() {
		
		if(post != null && basic_addr != null & extra_addr != null) {
		return "["+post+"] " + basic_addr + " " + extra_addr;
		}
		else
			return " ";
	}
	
	
	//시간 변환을 수행하여 출력하는 메소드
	public String getJoindateWithFromat() throws ParseException {
		//[1] 내가 가진 가입일을 날짜 형식(java.util.Date)으로 변환
		//[2] 1번 결과를 다시 원하는 형식의 문자열로 변환 -. format()
		
		if(joindate == null) {
			return "";
			
		}else {
		
		SimpleDateFormat read = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
		Date date = read.parse(joindate);
		
		SimpleDateFormat write = new SimpleDateFormat("Y년M월 d일");
		String time = write.format(date);
		
		return time;
		}
		
	}
	public String getLast_loginWithFormat() throws ParseException{
		
		if(last_login == null) {
			return "";
		}else {
		
			SimpleDateFormat read = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
			Date date = read.parse(last_login);
		
		SimpleDateFormat write = new SimpleDateFormat("Y년 M월 d일 E요일 a hh시mm분");
		String time = write.format(date);
		
		return time;
		}
	}

}
