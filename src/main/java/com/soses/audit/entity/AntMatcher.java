package com.soses.audit.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/**
 * The Class AntMatcher.
 *
 * @author hso
 * @since Jan 18, 2022
 */
@Entity(name="ant_matcher")
public class AntMatcher implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -5778130582402912650L;

	/** Primary key. */
    protected static final String PK = "matcherId";
    
    /** The matcher id. */
    @Id
    @Column(name="MATCHER_ID", unique=true, nullable=false)
    private int matcherId;
    
    /** The path. */
    @Column(name="PATH", length=30)
    private String path;
    
    /** The role info. */
    @Column(name="ROLE_INFO", length=100)
    private String roleInfo;
    
    /** The eff date. */
    @Column(name="EFF_DATE")
    private LocalDate effDate;
    
    /** The end date. */
    @Column(name="END_DATE")
    private LocalDate endDate;

	/**
	 * Gets the matcher id.
	 *
	 * @return the matcher id
	 */
	public int getMatcherId() {
		return matcherId;
	}

	/**
	 * Gets the path.
	 *
	 * @return the path
	 */
	public String getPath() {
		return path;
	}

	/**
	 * Gets the role info.
	 *
	 * @return the role info
	 */
	public String getRoleInfo() {
		return roleInfo;
	}

	/**
	 * Gets the eff date.
	 *
	 * @return the eff date
	 */
	public LocalDate getEffDate() {
		return effDate;
	}

	/**
	 * Gets the end date.
	 *
	 * @return the end date
	 */
	public LocalDate getEndDate() {
		return endDate;
	}

	/**
	 * Sets the matcher id.
	 *
	 * @param matcherId the new matcher id
	 */
	public void setMatcherId(int matcherId) {
		this.matcherId = matcherId;
	}

	/**
	 * Sets the path.
	 *
	 * @param path the new path
	 */
	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * Sets the role info.
	 *
	 * @param roleInfo the new role info
	 */
	public void setRoleInfo(String roleInfo) {
		this.roleInfo = roleInfo;
	}

	/**
	 * Sets the eff date.
	 *
	 * @param effDate the new eff date
	 */
	public void setEffDate(LocalDate effDate) {
		this.effDate = effDate;
	}

	/**
	 * Sets the end date.
	 *
	 * @param endDate the new end date
	 */
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "AntMatcher [matcherId=" + matcherId + ", path=" + path + ", roleInfo=" + roleInfo + ", effDate="
				+ effDate + ", endDate=" + endDate + "]";
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(effDate, endDate, matcherId, path, roleInfo);
	}

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AntMatcher other = (AntMatcher) obj;
		return Objects.equals(effDate, other.effDate) && Objects.equals(endDate, other.endDate)
				&& matcherId == other.matcherId && Objects.equals(path, other.path)
				&& Objects.equals(roleInfo, other.roleInfo);
	}
    
}
