package com.jwt.auth.dto;

public class LoginDto {
	
	
	
	
	private String name;
	private String password;
	
	
	
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "LoginDto [name=" + name + ", password=" + password + "]";
	}
	public LoginDto(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}
	public LoginDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
