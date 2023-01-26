// Generated with g9.

package com.soses.audit.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;

@Entity
@Table(name="customer", indexes={@Index(name="customer_CUSTOMER_CODE_IX", columnList="CUSTOMER_CODE", unique=true)})
public class Customer implements Serializable {

	private static final long serialVersionUID = 1405504801386321243L;

    protected static final String PK = "customerId";

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="CUSTOMER_ID", unique=true, nullable=false, precision=10)
    private int customerId;
    @Column(name="CUSTOMER_CODE", unique=true, length=20)
    private String customerCode;
    @Column(name="DIVISION_CUSTOMER_CODE", length=20)
    private String divisionCustomerCode;
    @Column(name="STORE_NAME", length=50)
    private String storeName;
    @Column(name="OWNER_FIRST_NAME", length=50)
    private String ownerFirstName;
    @Column(name="OWNER_MIDDLE_NAME", length=20)
    private String ownerMiddleName;
    @Column(name="OWNER_LAST_NAME", length=20)
    private String ownerLastName;
    @Column(name="EMAIL_ADDRESS", length=50)
    private String emailAddress;
    @Column(name="CUSTOMER_STATUS", length=2)
    private String customerStatus;
    @Column(name="COORDINATE_X", precision=10, scale=6)
    private BigDecimal coordinateX;
    @Column(name="COORDINATE_Y", precision=10, scale=6)
    private BigDecimal coordinateY;
    @Column(name="ASSIGNED_USER", length=20)
    private String assignedUser;
    @Column(name="MAYOR_PERMIT_NO", length=20)
    private String mayorPermitNo;
    @Column(name="MAYOR_PERMIT_EXP_DATE")
    private LocalDate mayorPermitExpDate;
    @Column(name="LTO_FDA_NO", length=20)
    private String ltoFdaNo;
    @Column(name="LTO_FDA_EXP_DATE")
    private LocalDate ltoFdaExpDate;
    @Column(name="DTI_NO", length=20)
    private String dtiNo;
    @Column(name="DTI_EXP_DATE")
    private LocalDate dtiExpDate;
    @Column(name="BIR_OCN", length=20)
    private String birOcn;
    @Column(name="BIR_REG_DATE")
    private LocalDate birRegDate;
    @Column(name="STORE_PHOTO", length=20)
    private String storePhoto;
    @Column(name="REMARKS", length=100)
    private String remarks;
    @Column(name="ENTRY_TIMESTAMP")
    private LocalDateTime entryTimestamp;
    @Column(name="LAST_CHANGED_TIMESTAMP")
    private LocalDateTime lastChangedTimestamp;
    @Column(name="LAST_CHANGED_USER", length=20)
    private String lastChangedUser;

    /** Default constructor. */
    public Customer() {
        super();
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
     * Access method for customerCode.
     *
     * @return the current value of customerCode
     */
    public String getCustomerCode() {
        return customerCode;
    }

    /**
     * Setter method for customerCode.
     *
     * @param aCustomerCode the new value for customerCode
     */
    public void setCustomerCode(String aCustomerCode) {
        customerCode = aCustomerCode;
    }

    /**
     * Access method for divisionCustomerCode.
     *
     * @return the current value of divisionCustomerCode
     */
    public String getDivisionCustomerCode() {
        return divisionCustomerCode;
    }

    /**
     * Setter method for divisionCustomerCode.
     *
     * @param aDivisionCustomerCode the new value for divisionCustomerCode
     */
    public void setDivisionCustomerCode(String aDivisionCustomerCode) {
        divisionCustomerCode = aDivisionCustomerCode;
    }

    /**
     * Access method for storeName.
     *
     * @return the current value of storeName
     */
    public String getStoreName() {
        return storeName;
    }

    /**
     * Setter method for storeName.
     *
     * @param aStoreName the new value for storeName
     */
    public void setStoreName(String aStoreName) {
        storeName = aStoreName;
    }

    /**
     * Access method for ownerFirstName.
     *
     * @return the current value of ownerFirstName
     */
    public String getOwnerFirstName() {
        return ownerFirstName;
    }

    /**
     * Setter method for ownerFirstName.
     *
     * @param aOwnerFirstName the new value for ownerFirstName
     */
    public void setOwnerFirstName(String aOwnerFirstName) {
        ownerFirstName = aOwnerFirstName;
    }

    /**
     * Access method for ownerMiddleName.
     *
     * @return the current value of ownerMiddleName
     */
    public String getOwnerMiddleName() {
        return ownerMiddleName;
    }

    /**
     * Setter method for ownerMiddleName.
     *
     * @param aOwnerMiddleName the new value for ownerMiddleName
     */
    public void setOwnerMiddleName(String aOwnerMiddleName) {
        ownerMiddleName = aOwnerMiddleName;
    }

    /**
     * Access method for ownerLastName.
     *
     * @return the current value of ownerLastName
     */
    public String getOwnerLastName() {
        return ownerLastName;
    }

    /**
     * Setter method for ownerLastName.
     *
     * @param aOwnerLastName the new value for ownerLastName
     */
    public void setOwnerLastName(String aOwnerLastName) {
        ownerLastName = aOwnerLastName;
    }

    /**
     * Access method for emailAddress.
     *
     * @return the current value of emailAddress
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Setter method for emailAddress.
     *
     * @param aEmailAddress the new value for emailAddress
     */
    public void setEmailAddress(String aEmailAddress) {
        emailAddress = aEmailAddress;
    }

    /**
     * Access method for customerStatus.
     *
     * @return the current value of customerStatus
     */
    public String getCustomerStatus() {
        return customerStatus;
    }

    /**
     * Setter method for customerStatus.
     *
     * @param aCustomerStatus the new value for customerStatus
     */
    public void setCustomerStatus(String aCustomerStatus) {
        customerStatus = aCustomerStatus;
    }

    /**
     * Access method for coordinateX.
     *
     * @return the current value of coordinateX
     */
    public BigDecimal getCoordinateX() {
        return coordinateX;
    }

    /**
     * Setter method for coordinateX.
     *
     * @param aCoordinateX the new value for coordinateX
     */
    public void setCoordinateX(BigDecimal aCoordinateX) {
        coordinateX = aCoordinateX;
    }

    /**
     * Access method for coordinateY.
     *
     * @return the current value of coordinateY
     */
    public BigDecimal getCoordinateY() {
        return coordinateY;
    }

    /**
     * Setter method for coordinateY.
     *
     * @param aCoordinateY the new value for coordinateY
     */
    public void setCoordinateY(BigDecimal aCoordinateY) {
        coordinateY = aCoordinateY;
    }

    /**
     * Access method for assignedUser.
     *
     * @return the current value of assignedUser
     */
    public String getAssignedUser() {
        return assignedUser;
    }

    /**
     * Setter method for assignedUser.
     *
     * @param aAssignedUser the new value for assignedUser
     */
    public void setAssignedUser(String aAssignedUser) {
        assignedUser = aAssignedUser;
    }

    /**
     * Access method for mayorPermitNo.
     *
     * @return the current value of mayorPermitNo
     */
    public String getMayorPermitNo() {
        return mayorPermitNo;
    }

    /**
     * Setter method for mayorPermitNo.
     *
     * @param aMayorPermitNo the new value for mayorPermitNo
     */
    public void setMayorPermitNo(String aMayorPermitNo) {
        mayorPermitNo = aMayorPermitNo;
    }

    /**
     * Access method for mayorPermitExpDate.
     *
     * @return the current value of mayorPermitExpDate
     */
    public LocalDate getMayorPermitExpDate() {
        return mayorPermitExpDate;
    }

    /**
     * Setter method for mayorPermitExpDate.
     *
     * @param aMayorPermitExpDate the new value for mayorPermitExpDate
     */
    public void setMayorPermitExpDate(LocalDate aMayorPermitExpDate) {
        mayorPermitExpDate = aMayorPermitExpDate;
    }

    /**
     * Access method for ltoFdaNo.
     *
     * @return the current value of ltoFdaNo
     */
    public String getLtoFdaNo() {
        return ltoFdaNo;
    }

    /**
     * Setter method for ltoFdaNo.
     *
     * @param aLtoFdaNo the new value for ltoFdaNo
     */
    public void setLtoFdaNo(String aLtoFdaNo) {
        ltoFdaNo = aLtoFdaNo;
    }

    /**
     * Access method for ltoFdaExpDate.
     *
     * @return the current value of ltoFdaExpDate
     */
    public LocalDate getLtoFdaExpDate() {
        return ltoFdaExpDate;
    }

    /**
     * Setter method for ltoFdaExpDate.
     *
     * @param aLtoFdaExpDate the new value for ltoFdaExpDate
     */
    public void setLtoFdaExpDate(LocalDate aLtoFdaExpDate) {
        ltoFdaExpDate = aLtoFdaExpDate;
    }

    /**
     * Access method for dtiNo.
     *
     * @return the current value of dtiNo
     */
    public String getDtiNo() {
        return dtiNo;
    }

    /**
     * Setter method for dtiNo.
     *
     * @param aDtiNo the new value for dtiNo
     */
    public void setDtiNo(String aDtiNo) {
        dtiNo = aDtiNo;
    }

    /**
     * Access method for dtiExpDate.
     *
     * @return the current value of dtiExpDate
     */
    public LocalDate getDtiExpDate() {
        return dtiExpDate;
    }

    /**
     * Setter method for dtiExpDate.
     *
     * @param aDtiExpDate the new value for dtiExpDate
     */
    public void setDtiExpDate(LocalDate aDtiExpDate) {
        dtiExpDate = aDtiExpDate;
    }

    /**
     * Access method for birOcn.
     *
     * @return the current value of birOcn
     */
    public String getBirOcn() {
        return birOcn;
    }

    /**
     * Setter method for birOcn.
     *
     * @param aBirOcn the new value for birOcn
     */
    public void setBirOcn(String aBirOcn) {
        birOcn = aBirOcn;
    }

    /**
     * Access method for birRegDate.
     *
     * @return the current value of birRegDate
     */
    public LocalDate getBirRegDate() {
        return birRegDate;
    }

    /**
     * Setter method for birRegDate.
     *
     * @param aBirRegDate the new value for birRegDate
     */
    public void setBirRegDate(LocalDate aBirRegDate) {
        birRegDate = aBirRegDate;
    }

    /**
     * Access method for storePhoto.
     *
     * @return the current value of storePhoto
     */
    public String getStorePhoto() {
        return storePhoto;
    }

    /**
     * Setter method for storePhoto.
     *
     * @param aStorePhoto the new value for storePhoto
     */
    public void setStorePhoto(String aStorePhoto) {
        storePhoto = aStorePhoto;
    }

    /**
     * Access method for remarks.
     *
     * @return the current value of remarks
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * Setter method for remarks.
     *
     * @param aRemarks the new value for remarks
     */
    public void setRemarks(String aRemarks) {
        remarks = aRemarks;
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
     * Access method for lastChangedTimestamp.
     *
     * @return the current value of lastChangedTimestamp
     */
    public LocalDateTime getLastChangedTimestamp() {
        return lastChangedTimestamp;
    }

    /**
     * Setter method for lastChangedTimestamp.
     *
     * @param aLastChangedTimestamp the new value for lastChangedTimestamp
     */
    public void setLastChangedTimestamp(LocalDateTime aLastChangedTimestamp) {
        lastChangedTimestamp = aLastChangedTimestamp;
    }

    /**
     * Access method for lastChangedUser.
     *
     * @return the current value of lastChangedUser
     */
    public String getLastChangedUser() {
        return lastChangedUser;
    }

    /**
     * Setter method for lastChangedUser.
     *
     * @param aLastChangedUser the new value for lastChangedUser
     */
    public void setLastChangedUser(String aLastChangedUser) {
        lastChangedUser = aLastChangedUser;
    }

    /**
     * Compares the key for this instance with another Customer.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Customer and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Customer)) {
            return false;
        }
        Customer that = (Customer) other;
        if (this.getCustomerId() != that.getCustomerId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Customer.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Customer)) return false;
        return this.equalKeys(other) && ((Customer)other).equalKeys(this);
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
        i = getCustomerId();
        result = 37*result + i;
        return result;
    }

    @Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerCode=" + customerCode + ", divisionCustomerCode="
				+ divisionCustomerCode + ", storeName=" + storeName + ", ownerFirstName=" + ownerFirstName
				+ ", ownerMiddleName=" + ownerMiddleName + ", ownerLastName=" + ownerLastName + ", emailAddress="
				+ emailAddress + ", customerStatus=" + customerStatus + ", coordinateX=" + coordinateX
				+ ", coordinateY=" + coordinateY + ", assignedUser=" + assignedUser + ", mayorPermitNo=" + mayorPermitNo
				+ ", mayorPermitExpDate=" + mayorPermitExpDate + ", ltoFdaNo=" + ltoFdaNo + ", ltoFdaExpDate="
				+ ltoFdaExpDate + ", dtiNo=" + dtiNo + ", dtiExpDate=" + dtiExpDate + ", birOcn=" + birOcn
				+ ", birRegDate=" + birRegDate + ", storePhoto=" + storePhoto + ", remarks=" + remarks
				+ ", entryTimestamp=" + entryTimestamp + ", lastChangedTimestamp=" + lastChangedTimestamp
				+ ", lastChangedUser=" + lastChangedUser + "]";
	}

    /**
     * Return all elements of the primary key.
     *
     * @return Map of key names to values
     */
    public Map<String, Object> getPrimaryKey() {
        Map<String, Object> ret = new LinkedHashMap<String, Object>(6);
        ret.put("customerId", Integer.valueOf(getCustomerId()));
        return ret;
    }

}
