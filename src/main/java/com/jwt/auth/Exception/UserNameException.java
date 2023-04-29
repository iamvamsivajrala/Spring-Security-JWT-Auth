package com.jwt.auth.Exception;

public class UserNameException extends RuntimeException {
	
	String msg;
	public UserNameException(String msg) {
		super(msg);
		this.msg=msg;
	}
}
