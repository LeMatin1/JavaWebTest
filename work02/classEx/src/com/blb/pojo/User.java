package com.blb.pojo;

public class User {
	private Integer userid;
	private String username;
	private String password;
	private Integer age;
	
	public User(String username, String password){
		this.username = username;
		this.password = password;
	}
	
	public User(Integer userid, String username, String password, Integer age) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.age = age;
	}
	
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
}
