package com.kh.sts10.entity;


//  DTO /Vo
//-DTO = DB 의 1row
//-VO 광범위한 필요에 의해 쓰는 객체(Value Object)
//

public class StudentVO {
	private String name;
	private int korean;
	private int english;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKorean() {
		return korean;
	}
	public void setKorean(int korean) {
		this.korean = korean;
	}
	public int getEnglish() {
		return english;
	}
	public void setEnglish(int english) {
		this.english = english;
	}
	@Override
	public String toString() {
		return "StudentVO [name=" + name + ", korean=" + korean + ", english=" + english + "]";
	}
	
	
}
