package com.example.lesson01;

//lombok을 추가했다면 @Data로 끝났을 것이다.
//@Component를 붙이면 spring bean이 된다.
public class Data {
	private int id;
	private String name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
