package com.maggots.zeal.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.maggots.zeal.utils.LoginStatus;

/**
 * login entity to store login information of a user
 * @author ADMIN
 *
 */
@Entity
@Table(name="login")
public class Login extends AbstractEntity{
	private String token;
	@NotNull
	private String password;
	private LoginStatus status;
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LoginStatus getStatus() {
		return status;
	}
	public void setStatus(LoginStatus status) {
		this.status = status;
	}
}
