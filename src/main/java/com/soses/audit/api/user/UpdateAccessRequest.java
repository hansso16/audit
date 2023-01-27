package com.soses.audit.api.user;

public class UpdateAccessRequest extends BaseUserRequest {

	private String role;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UpdateAccessRequest [role=" + role + ", toString()=" + super.toString() + "]";
	}
	
}
