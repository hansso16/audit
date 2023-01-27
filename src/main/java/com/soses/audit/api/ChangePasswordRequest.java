package com.soses.audit.api;

import com.soses.audit.api.user.BaseUserRequest;

public class ChangePasswordRequest extends BaseUserRequest {

	String currentPassword;
	
	String password;
	
	String passwordConfirmation;

	public String getCurrentPassword() {
		return currentPassword;
	}

	public void setCurrentPassword(String currentPassword) {
		this.currentPassword = currentPassword;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}

	@Override
	public String toString() {
		return "ChangePasswordRequest [oldPassword=" + currentPassword + ", password=" + password
				+ ", passwordConfirmation=" + passwordConfirmation + "]";
	}
	
 }
