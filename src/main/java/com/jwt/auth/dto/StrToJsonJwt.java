package com.jwt.auth.dto;

public class StrToJsonJwt {
	
	
	
	
	
	private String token;
	
	private String tokenType="Bearer";

	public StrToJsonJwt(String token) {
		this.token=token;
	}

	
	
	
	
	
	
	
	
	
	
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getTokenType() {
		return tokenType;
	}

	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}

	public StrToJsonJwt(String token, String tokenType) {
		super();
		this.token = token;
		this.tokenType = tokenType;
	}

	public StrToJsonJwt() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "StrToJsonJwt [token=" + token + ", tokenType=" + tokenType + "]";
	}
	
	
}
