// Generated with g9.

package com.soses.audit.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity(name="customer_address_history")
public class CustomerAddressHistory implements Serializable {

	private static final long serialVersionUID = 1210044359214775518L;

    protected static final String PK = "CustomerAddressHistoryPrimary";

    @EmbeddedId
    private CustomerAddressHistoryPK id;
    @Column(name="STREET", length=100)
    private String street;
    @Column(name="MUNICIPAL", precision=10)
    private int municipal;
    @Column(name="PROVINCE", precision=10)
    private int province;
    @Column(name="REGION", precision=10)
    private int region;
    @Column(name="ZIP_CODE", length=10)
    private String zipCode;
    @Column(name="USER_CODE", length=10)
    private String userCode;

    public CustomerAddressHistory() {
        super();
    }

	public CustomerAddressHistoryPK getId() {
		return id;
	}

	public void setId(CustomerAddressHistoryPK id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getMunicipal() {
		return municipal;
	}

	public void setMunicipal(int municipal) {
		this.municipal = municipal;
	}

	public int getProvince() {
		return province;
	}

	public void setProvince(int province) {
		this.province = province;
	}

	public int getRegion() {
		return region;
	}

	public void setRegion(int region) {
		this.region = region;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	@Override
	public String toString() {
		return "CustomerAddressHistory [id=" + id + ", street=" + street + ", municipal=" + municipal + ", province="
				+ province + ", region=" + region + ", zipCode=" + zipCode + ", userCode=" + userCode + ", toString()="
				+ super.toString() + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, municipal, province, region, street, userCode, zipCode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerAddressHistory other = (CustomerAddressHistory) obj;
		return Objects.equals(id, other.id) && municipal == other.municipal && province == other.province
				&& region == other.region && Objects.equals(street, other.street)
				&& Objects.equals(userCode, other.userCode) && Objects.equals(zipCode, other.zipCode);
	}
}
