package com.soses.audit.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * The Class Role.
 *
 * @author hso
 * @since 11 Nov 2021
 */
@Entity(name="role")
public class Role implements Serializable {

    /** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3465050259537380339L;

	/** Primary key. */
    protected static final String PK = "roleId";

    /** The role id. */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ROLE_ID", unique=true, nullable=false, precision=10)
    private int roleId;
    
    /** The role name. */
    @Column(name="ROLE_NAME", length=30)
    private String roleName;
    
    /** The role code. */
    @Column(name="ROLE_CODE", length=20)
    private String roleCode;

    /** The role code. */
    @Column(name="FULL_ROLE_CODE", length=30)
    private String fullRoleCode;
    
    

    /** Default constructor. */
    public Role() {
        super();
    }

    /**
     * Access method for roleId.
     *
     * @return the current value of roleId
     */
    public int getRoleId() {
        return roleId;
    }

    /**
     * Setter method for roleId.
     *
     * @param aRoleId the new value for roleId
     */
    public void setRoleId(int aRoleId) {
        roleId = aRoleId;
    }

    /**
     * Access method for roleName.
     *
     * @return the current value of roleName
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * Setter method for roleName.
     *
     * @param aRoleName the new value for roleName
     */
    public void setRoleName(String aRoleName) {
        roleName = aRoleName;
    }

    /**
     * Gets the role code.
     *
     * @return the role code
     */
    public String getRoleCode() {
		return roleCode;
	}

	/**
	 * Sets the role code.
	 *
	 * @param roleCode the new role code
	 */
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	/**
	 * Gets the full role code.
	 *
	 * @return the full role code
	 */
	public String getFullRoleCode() {
		return fullRoleCode;
	}

	/**
	 * Sets the full role code.
	 *
	 * @param fullRoleCode the new full role code
	 */
	public void setFullRoleCode(String fullRoleCode) {
		this.fullRoleCode = fullRoleCode;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + ", roleCode=" + roleCode + ", fullRoleCode="
				+ fullRoleCode + "]";
	}


}
