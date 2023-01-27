package com.soses.audit.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity(name="user")
@Table(name="user")
public class User implements Serializable {

	private static final long serialVersionUID = -7970373912340336680L;

    protected static final String PK = "user_code";

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="USER_CODE", unique=true, nullable=false, length=20)
    private String userCode;
    
    @Column(name="USERNAME", unique=true, nullable=false, length=20)
    private String username;
    
    @Column(name="PASSWORD", length=68)
    private String password;
    
    @Column(name="ENTRY_TIMESTAMP")
    private LocalDateTime entryTimestamp;
    
    @Column(name="TERMINATION_DATE")
    private LocalDate terminationDate;

    @Column(name="LAST_CHANGED_TIMESTAMP")
    private LocalDateTime lastChangedTimestamp;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
    private Role role;
    
    @Column(name="LAST_CHANGED_USER")
    private String lastChangedUser;
    
    public User() {
        super();
    }

	@Override
	public int hashCode() {
		return Objects.hash(entryTimestamp, lastChangedTimestamp, lastChangedUser, password, role, terminationDate,
				userCode, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(entryTimestamp, other.entryTimestamp)
				&& Objects.equals(lastChangedTimestamp, other.lastChangedTimestamp)
				&& Objects.equals(lastChangedUser, other.lastChangedUser) && Objects.equals(password, other.password)
				&& Objects.equals(role, other.role) && Objects.equals(terminationDate, other.terminationDate)
				&& Objects.equals(userCode, other.userCode) && Objects.equals(username, other.username);
	}

	public LocalDateTime getLastChangedTimestamp() {
		return lastChangedTimestamp;
	}

	public void setLastChangedTimestamp(LocalDateTime lastChangedTimestamp) {
		this.lastChangedTimestamp = lastChangedTimestamp;
	}

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
		return "User [userCode=" + userCode + ", username=" + username + ", password=" + password + ", entryTimestamp="
				+ entryTimestamp + ", terminationDate=" + terminationDate + ", lastChangedTimestamp="
				+ lastChangedTimestamp + ", role=" + role + ", lastChangedUser=" + lastChangedUser + "]";
	}
}
