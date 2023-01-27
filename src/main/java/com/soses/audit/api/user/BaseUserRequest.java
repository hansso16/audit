package com.soses.audit.api.user;

public class BaseUserRequest {

	private String userCode;
	private String username;
	
	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "BaseUserRequest [userCode=" + userCode + ", username=" + username + "]";
	}
	
}
