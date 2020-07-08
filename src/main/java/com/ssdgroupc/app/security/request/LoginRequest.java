package com.ssdgroupc.app.security.request;

import javax.validation.constraints.NotBlank;

/**
 * Date: May 26-2020 LoginRequest entity.
 * 
 * @author aman
 * @version 1.0
 * @category Entity
 */
public class LoginRequest {
	@NotBlank
	private String username;

	@NotBlank
	private String password;

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
}
