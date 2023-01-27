package com.soses.audit.api.user;

import java.util.List;

import com.soses.audit.dto.UserTO;
import com.soses.audit.entity.Role;

public class UserResponse extends BaseUserResponse {

	private UserTO user;
	private List<Role> roleList;
	private Role userRole;

	public Role getUserRole() {
		return userRole;
	}

	public void setUserRole(Role userRole) {
		this.userRole = userRole;
	}

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	public UserTO getUser() {
		return user;
	}

	public void setUser(UserTO user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "UserResponse [user=" + user + ", roleList=" + roleList + ", userRole=" + userRole + ", toString()="
				+ super.toString() + "]";
	}
	
}
