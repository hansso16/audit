package com.soses.audit.api.user;

public class UserRegistrationRequest {

	String username;
	
	String password;
	
	String passwordConfirmation;
	
	String roleId;
	
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

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		return "UserRegistrationRequest [username=" + username + ", password=" + password + ", passwordConfirmation="
				+ passwordConfirmation + ", roleId=" + roleId + ", toString()=" + super.toString() + "]";
	}
	
}
