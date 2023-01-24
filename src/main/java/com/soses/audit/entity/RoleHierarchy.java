package com.soses.audit.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/**
 * The Class RoleHierarchy.
 *
 * @author hso
 * @since Jan 18, 2022
 */
@Entity(name="role_hierarchy")
public class RoleHierarchy implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6152128599657604729L;

	/** The role hierarchy id. */
	@Id
    @Column(name="ROLE_HIERARCHY_ID", unique=true, nullable=false)
	private int roleHierarchyId;
	
	/** The parent role. */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="parent_role", referencedColumnName = "role_id", insertable = false, updatable = false)
	private Role parentRole;
	
	/** The child role. */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="child_role", referencedColumnName = "role_id", insertable = false, updatable = false)
	private Role childRole;
	
	/** The eff date. */
	@Column(name="EFF_DATE")
	private LocalDate effDate;
	
	/** The end date. */
	@Column(name="END_DATE")
	private LocalDate endDate;

	/**
	 * Gets the role hierarchy id.
	 *
	 * @return the role hierarchy id
	 */
	public int getRoleHierarchyId() {
		return roleHierarchyId;
	}

	/**
	 * Gets the parent role.
	 *
	 * @return the parent role
	 */
	public Role getParentRole() {
		return parentRole;
	}

	/**
	 * Gets the child role.
	 *
	 * @return the child role
	 */
	public Role getChildRole() {
		return childRole;
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
	 * Sets the role hierarchy id.
	 *
	 * @param roleHierarchyId the new role hierarchy id
	 */
	public void setRoleHierarchyId(int roleHierarchyId) {
		this.roleHierarchyId = roleHierarchyId;
	}

	/**
	 * Sets the parent role.
	 *
	 * @param parentRole the new parent role
	 */
	public void setParentRole(Role parentRole) {
		this.parentRole = parentRole;
	}

	/**
	 * Sets the child role.
	 *
	 * @param childRole the new child role
	 */
	public void setChildRole(Role childRole) {
		this.childRole = childRole;
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
		return "RoleHierarchy [roleHierarchyId=" + roleHierarchyId + ", parentRole=" + parentRole + ", childRole="
				+ childRole + ", effDate=" + effDate + ", endDate=" + endDate + "]";
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(childRole, effDate, endDate, parentRole, roleHierarchyId);
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
		RoleHierarchy other = (RoleHierarchy) obj;
		return Objects.equals(childRole, other.childRole) && Objects.equals(effDate, other.effDate)
				&& Objects.equals(endDate, other.endDate) && Objects.equals(parentRole, other.parentRole)
				&& roleHierarchyId == other.roleHierarchyId;
	}
	
	
}
