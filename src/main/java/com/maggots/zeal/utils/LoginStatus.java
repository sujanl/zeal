package com.maggots.zeal.utils;

public enum LoginStatus{
	
	
	LOGGEDIN("LOGGEDIN", "Loggedin"),
	
	LOGOUT("LOGOUT", "Logout");
	
	private final String value;
	private final String description;

	LoginStatus(String value, String description) {
		this.value = value;
		this.description = description;
	}
	
	public String value() {
		return this.value;
	}
	
	public String getReasonPhrase() {
		return this.description;
	}
	
	@Override
	public String toString() {
		return this.value;
	}
}

