package com.soses.audit.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.soses.audit.entity.Role;

public class UserTO {

	private String userCode;
    private String username;
    private String password;
    private LocalDateTime entryTimestamp;
    private LocalDate terminationDate;
    private Role role;
    private String lastChangedUser;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LocalDateTime getEntryTimestamp() {
		return entryTimestamp;
	}
	public void setEntryTimestamp(LocalDateTime entryTimestamp) {
		this.entryTimestamp = entryTimestamp;
	}
	public LocalDate getTerminationDate() {
		return terminationDate;
	}
	public void setTerminationDate(LocalDate terminationDate) {
		this.terminationDate = terminationDate;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public String getLastChangedUser() {
		return lastChangedUser;
	}
	public void setLastChangedUser(String lastChangedUser) {
		this.lastChangedUser = lastChangedUser;
	}
	@Override
	public String toString() {
		return "UserTO [userCode=" + userCode + ", username=" + username + ", password=" + password
				+ ", entryTimestamp=" + entryTimestamp + ", terminationDate=" + terminationDate + ", role=" + role
				+ ", lastChangedUser=" + lastChangedUser + "]";
	}
    
    
}
