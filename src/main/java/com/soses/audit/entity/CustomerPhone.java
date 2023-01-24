// Generated with g9.

package com.soses.audit.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name="customer_phone")
public class CustomerPhone implements Serializable {

	private static final long serialVersionUID = -1868378013445886800L;


	protected static final String PK = "customerPhoneId";


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="CUSTOMER_PHONE_ID", unique=true, nullable=false, precision=10)
    private int customerPhoneId;
    @Column(name="CUSTOMER_ID", precision=10)
    private int customerId;
    @Column(name="PHONE_TYPE", length=1)
    private String phoneType;
    @Column(name="PHONE_NUMBER", length=20)
    private String phoneNumber;
    @Column(name="ENTRY_TIMESTAMP")
    private LocalDateTime entryTimestamp;
    @Column(name="USERNAME", length=20)
    private String username;

    /** Default constructor. */
    public CustomerPhone() {
        super();
    }

    /**
     * Access method for customerPhoneId.
     *
     * @return the current value of customerPhoneId
     */
    public int getCustomerPhoneId() {
        return customerPhoneId;
    }

    /**
     * Setter method for customerPhoneId.
     *
     * @param aCustomerPhoneId the new value for customerPhoneId
     */
    public void setCustomerPhoneId(int aCustomerPhoneId) {
        customerPhoneId = aCustomerPhoneId;
    }

    /**
     * Access method for customerId.
     *
     * @return the current value of customerId
     */
    public int getCustomerId() {
        return customerId;
    }

    /**
     * Setter method for customerId.
     *
     * @param aCustomerId the new value for customerId
     */
    public void setCustomerId(int aCustomerId) {
        customerId = aCustomerId;
    }

    /**
     * Access method for phoneType.
     *
     * @return the current value of phoneType
     */
    public String getPhoneType() {
        return phoneType;
    }

    /**
     * Setter method for phoneType.
     *
     * @param aPhoneType the new value for phoneType
     */
    public void setPhoneType(String aPhoneType) {
        phoneType = aPhoneType;
    }

    /**
     * Access method for phoneNumber.
     *
     * @return the current value of phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Setter method for phoneNumber.
     *
     * @param aPhoneNumber the new value for phoneNumber
     */
    public void setPhoneNumber(String aPhoneNumber) {
        phoneNumber = aPhoneNumber;
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
     * Access method for username.
     *
     * @return the current value of username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Setter method for username.
     *
     * @param aUsername the new value for username
     */
    public void setUsername(String aUsername) {
        username = aUsername;
    }

    /**
     * Compares the key for this instance with another CustomerPhone.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class CustomerPhone and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof CustomerPhone)) {
            return false;
        }
        CustomerPhone that = (CustomerPhone) other;
        if (this.getCustomerPhoneId() != that.getCustomerPhoneId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another CustomerPhone.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof CustomerPhone)) return false;
        return this.equalKeys(other) && ((CustomerPhone)other).equalKeys(this);
    }

    /**
     * Returns a hash code for this instance.
     *
     * @return Hash code
     */
    @Override
    public int hashCode() {
        int i;
        int result = 17;
        i = getCustomerPhoneId();
        result = 37*result + i;
        return result;
    }

    @Override
	public String toString() {
		return "CustomerPhone [customerPhoneId=" + customerPhoneId + ", customerId=" + customerId + ", phoneType="
				+ phoneType + ", phoneNumber=" + phoneNumber + ", entryTimestamp=" + entryTimestamp + ", username="
				+ username + "]";
	}

    /**
     * Return all elements of the primary key.
     *
     * @return Map of key names to values
     */
    public Map<String, Object> getPrimaryKey() {
        Map<String, Object> ret = new LinkedHashMap<String, Object>(6);
        ret.put("customerPhoneId", Integer.valueOf(getCustomerPhoneId()));
        return ret;
    }

}
