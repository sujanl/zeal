package com.maggots.zeal.request;

import java.io.Serializable;

public class LogOutRequest implements Serializable {
	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	
}
