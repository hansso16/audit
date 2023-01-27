package com.soses.audit.api.user;

import com.soses.audit.api.BaseResponse;

public class BaseUserResponse extends BaseResponse {
	
	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "BaseUserResponse [username=" + username + ", toString()=" + super.toString() + "]";
	}

}
