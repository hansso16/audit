// Generated with g9.

package com.soses.audit.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity(name="customer_address")
public class CustomerAddress implements Serializable {

	private static final long serialVersionUID = 4378615043139619831L;

    protected static final String PK = "CustomerAddressPrimary";

    @EmbeddedId
    private CustomerAddressPK id;
    @Column(name="STREET", length=50)
    private String street;
    @Column(name="MUNICIPAL", precision=10)
    private int municipal;
    @Column(name="PROVINCE", precision=10)
    private int province;
    @Column(name="REGION", precision=10)
    private int region;
    @Column(name="ZIP_CODE", length=10)
    private String zipCode;
    @Column(name="ENTRY_TIMESTAMP")
    private LocalDateTime entryTimestamp;
    @Column(name="USER_CODE", precision=10)
    private String userCode;

    /** Default constructor. */
    public CustomerAddress() {
        super();
    }


    public CustomerAddressPK getId() {
		return id;
	}


	public void setId(CustomerAddressPK id) {
		this.id = id;
	}


	/**
     * Access method for street.
     *
     * @return the current value of street
     */
    public String getStreet() {
        return street;
    }

    /**
     * Setter method for street.
     *
     * @param aStreet the new value for street
     */
    public void setStreet(String aStreet) {
        street = aStreet;
    }

    /**
     * Access method for municipal.
     *
     * @return the current value of municipal
     */
    public int getMunicipal() {
        return municipal;
    }

    /**
     * Setter method for municipal.
     *
     * @param aMunicipal the new value for municipal
     */
    public void setMunicipal(int aMunicipal) {
        municipal = aMunicipal;
    }

    /**
     * Access method for province.
     *
     * @return the current value of province
     */
    public int getProvince() {
        return province;
    }

    /**
     * Setter method for province.
     *
     * @param aProvince the new value for province
     */
    public void setProvince(int aProvince) {
        province = aProvince;
    }

    /**
     * Access method for region.
     *
     * @return the current value of region
     */
    public int getRegion() {
        return region;
    }

    /**
     * Setter method for region.
     *
     * @param aRegion the new value for region
     */
    public void setRegion(int aRegion) {
        region = aRegion;
    }

    /**
     * Access method for zipCode.
     *
     * @return the current value of zipCode
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * Setter method for zipCode.
     *
     * @param aZipCode the new value for zipCode
     */
    public void setZipCode(String aZipCode) {
        zipCode = aZipCode;
    }

    /**
     * Access method for entryTimestamp.
     *
     * @return the current value of entryTimestamp
     */
    public LocalDateTime getEntryTimestamp() {
        return entryTimestamp;
    }

    /**
     * Setter method for entryTimestamp.
     *
     * @param aEntryTimestamp the new value for entryTimestamp
     */
    public void setEntryTimestamp(LocalDateTime aEntryTimestamp) {
        entryTimestamp = aEntryTimestamp;
    }

    /**
     * Access method for userCode.
     *
     * @return the current value of userCode
     */
    public String getUserCode() {
        return userCode;
    }

    /**
     * Setter method for userCode.
     *
     * @param aUserCode the new value for userCode
     */
    public void setUserCode(String aUserCode) {
        userCode = aUserCode;
    }

    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerAddress other = (CustomerAddress) obj;
		return Objects.equals(entryTimestamp, other.entryTimestamp) && Objects.equals(id, other.id)
				&& municipal == other.municipal && province == other.province && region == other.region
				&& Objects.equals(street, other.street) && userCode == other.userCode
				&& Objects.equals(zipCode, other.zipCode);
	}

    @Override
	public int hashCode() {
		return Objects.hash(entryTimestamp, id, municipal, province, region, street, userCode, zipCode);
	}

    @Override
	public String toString() {
		return "CustomerAddress [id=" + id + ", street=" + street + ", municipal=" + municipal + ", province="
				+ province + ", region=" + region + ", zipCode=" + zipCode + ", entryTimestamp=" + entryTimestamp
				+ ", userCode=" + userCode + "]";
	}
}
