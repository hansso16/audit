package com.soses.audit.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/**
 * The Class Municipality.
 *
 * @author hso
 * @since Jan 20, 2022
 */
@Entity(name="cfg_municipal")
public class Municipal implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6945765878731353833L;

	/** The municipality id. */
	@Id
    @Column(name="MUNICIPAL_ID", unique=true, nullable=false)
    private String municipalId;
	
	/** The region name. */
	@Column(name="PROVINCE_ID")
	private String provinceId;
	
	/** The region description. */
	@Column(name="MUNICIPAL_NAME", length=100)
	private String municipalName;

	/**
	 * Gets the municipal id.
	 *
	 * @return the municipal id
	 */
	public String getMunicipalId() {
		return municipalId;
	}

	/**
	 * Gets the province id.
	 *
	 * @return the province id
	 */
	public String getProvinceId() {
		return provinceId;
	}

	/**
	 * Gets the municipal name.
	 *
	 * @return the municipal name
	 */
	public String getMunicipalName() {
		return municipalName;
	}

	/**
	 * Sets the municipal id.
	 *
	 * @param municipalId the new municipal id
	 */
	public void setMunicipalId(String municipalId) {
		this.municipalId = municipalId;
	}

	/**
	 * Sets the province id.
	 *
	 * @param provinceId the new province id
	 */
	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}

	/**
	 * Sets the municipal name.
	 *
	 * @param municipalName the new municipal name
	 */
	public void setMunicipalName(String municipalName) {
		this.municipalName = municipalName;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Municipality [municipalId=" + municipalId + ", provinceId=" + provinceId + ", municipalName="
				+ municipalName + "]";
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(municipalId, municipalName, provinceId);
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
		Municipal other = (Municipal) obj;
		return Objects.equals(municipalId, other.municipalId) && Objects.equals(municipalName, other.municipalName)
				&& Objects.equals(provinceId, other.provinceId);
	}
	
}
