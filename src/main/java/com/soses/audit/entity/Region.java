package com.soses.audit.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/**
 * The Class Region.
 *
 * @author hso
 * @since Jan 20, 2022
 */
@Entity(name="cfg_region")
public class Region implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8495651337468110007L;

	/** The region id. */
	@Id
    @Column(name="REGION_ID", unique=true, nullable=false)
    private String regionId;
	
	/** The region name. */
	@Column(name="REGION_NAME", length=50)
	private String regionName;
	
	/** The region description. */
	@Column(name="REGION_DESCRIPTION", length=100)
	private String regionDescription;

	/**
	 * Gets the region id.
	 *
	 * @return the region id
	 */
	public String getRegionId() {
		return regionId;
	}

	/**
	 * Gets the region name.
	 *
	 * @return the region name
	 */
	public String getRegionName() {
		return regionName;
	}


	/**
	 * Gets the region description.
	 *
	 * @return the region description
	 */
	public String getRegionDescription() {
		return regionDescription;
	}

	/**
	 * Sets the region description.
	 *
	 * @param regionDescription the new region description
	 */
	public void setRegionDescription(String regionDescription) {
		this.regionDescription = regionDescription;
	}

	/**
	 * Sets the region id.
	 *
	 * @param regionId the new region id
	 */
	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}

	/**
	 * Sets the region name.
	 *
	 * @param regionName the new region name
	 */
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}


	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Region [regionId=" + regionId + ", regionName=" + regionName + ", regionDescription="
				+ regionDescription + "]";
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(regionDescription, regionId, regionName);
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
		Region other = (Region) obj;
		return Objects.equals(regionDescription, other.regionDescription) && Objects.equals(regionId, other.regionId)
				&& Objects.equals(regionName, other.regionName);
	}
	
}
