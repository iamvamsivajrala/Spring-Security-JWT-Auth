package com.jwt.auth.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CustomException extends RuntimeException {
	
	String msg;
	public CustomException(String msg) {
		super(msg);
		this.msg=msg;
	}
}
