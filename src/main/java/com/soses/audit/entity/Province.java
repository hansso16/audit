package com.soses.audit.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/**
 * The Class Province.
 *
 * @author hso
 * @since Jan 20, 2022
 */
@Entity(name="cfg_province")
public class Province implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7646351599949305002L;

	/** The province id. */
	@Id
    @Column(name="PROVINCE_ID", unique=true, nullable=false)
    private String provinceId;
	
	/** The region name. */
	@Column(name="REGION_ID")
	private String regionId;
	
	/** The region description. */
	@Column(name="PROVINCE_NAME", length=100)
	private String provinceName;

	/**
	 * Gets the province id.
	 *
	 * @return the province id
	 */
	public String getProvinceId() {
		return provinceId;
	}

	/**
	 * Gets the region id.
	 *
	 * @return the region id
	 */
	public String getRegionId() {
		return regionId;
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
	 * Sets the region id.
	 *
	 * @param regionId the new region id
	 */
	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}

	/**
	 * Gets the province name.
	 *
	 * @return the province name
	 */
	public String getProvinceName() {
		return provinceName;
	}

	/**
	 * Sets the province name.
	 *
	 * @param provinceName the new province name
	 */
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Province [provinceId=" + provinceId + ", regionId=" + regionId + ", provinceName=" + provinceName + "]";
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(provinceId, provinceName, regionId);
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
		Province other = (Province) obj;
		return Objects.equals(provinceId, other.provinceId) && Objects.equals(provinceName, other.provinceName)
				&& Objects.equals(regionId, other.regionId);
	}
}
