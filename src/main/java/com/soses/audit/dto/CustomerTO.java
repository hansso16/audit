package com.soses.audit.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CustomerTO {

	private int customerId;
    private String customerCode;
    private String divisionCustomerCode;
    private String storeName;
    private String ownerFirstName;
    private String ownerMiddleName;
    private String ownerLastName;
    private String emailAddress;
    private String customerStatus;
    private String customerStatusDescription;
    private BigDecimal coordinateX;
    private BigDecimal coordinateY;
    private String assignedUser;
    private String mayorPermitNo;
    private LocalDate mayorPermitExpDate;
    private String ltoFdaNo;
    private LocalDate ltoFdaExpDate;
    private String dtiNo;
    private LocalDate dtiExpDate;
    private String birOcn;
    private LocalDate birRegDate;
    private String storePhoto;
    private String b64EncodedImg;
    private String remarks;
    private String entryTimestamp;
    private String lastChangedTimestamp;
    private String lastChangedUser;
    private String lastChangedUsername;
    private String assignedUsername;
    private String salesmanInitials;
    
	public String getSalesmanInitials() {
		return salesmanInitials;
	}
	public void setSalesmanInitials(String salesmanInitials) {
		this.salesmanInitials = salesmanInitials;
	}
	public String getB64EncodedImg() {
		return b64EncodedImg;
	}
	public void setB64EncodedImg(String b64EncodedImg) {
		this.b64EncodedImg = b64EncodedImg;
	}
	public String getCustomerStatusDescription() {
		return customerStatusDescription;
	}
	public void setCustomerStatusDescription(String customerStatusDescription) {
		this.customerStatusDescription = customerStatusDescription;
	}
	public String getLastChangedUsername() {
		return lastChangedUsername;
	}
	public void setLastChangedUsername(String lastChangedUsername) {
		this.lastChangedUsername = lastChangedUsername;
	}
	public String getAssignedUsername() {
		return assignedUsername;
	}
	public void setAssignedUsername(String assignedUsername) {
		this.assignedUsername = assignedUsername;
	}
	public String getDivisionCustomerCode() {
		return divisionCustomerCode;
	}
	public void setDivisionCustomerCode(String divisionCustomerCode) {
		this.divisionCustomerCode = divisionCustomerCode;
	}
	public String getAssignedUser() {
		return assignedUser;
	}
	public void setAssignedUser(String assignedUser) {
		this.assignedUser = assignedUser;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerCode() {
		return customerCode;
	}
	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getOwnerFirstName() {
		return ownerFirstName;
	}
	public void setOwnerFirstName(String ownerFirstName) {
		this.ownerFirstName = ownerFirstName;
	}
	public String getOwnerMiddleName() {
		return ownerMiddleName;
	}
	public void setOwnerMiddleName(String ownerMiddleName) {
		this.ownerMiddleName = ownerMiddleName;
	}
	public String getOwnerLastName() {
		return ownerLastName;
	}
	public void setOwnerLastName(String ownerLastName) {
		this.ownerLastName = ownerLastName;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public BigDecimal getCoordinateX() {
		return coordinateX;
	}
	public void setCoordinateX(BigDecimal coordinateX) {
		this.coordinateX = coordinateX;
	}
	public BigDecimal getCoordinateY() {
		return coordinateY;
	}
	public void setCoordinateY(BigDecimal coordinateY) {
		this.coordinateY = coordinateY;
	}
	public String getEntryTimestamp() {
		return entryTimestamp;
	}
	public void setEntryTimestamp(String entryTimestamp) {
		this.entryTimestamp = entryTimestamp;
	}
	public String getLastChangedTimestamp() {
		return lastChangedTimestamp;
	}
	public void setLastChangedTimestamp(String lastChangedTimestamp) {
		this.lastChangedTimestamp = lastChangedTimestamp;
	}
	public String getLastChangedUser() {
		return lastChangedUser;
	}
	public void setLastChangedUser(String lastChangedUser) {
		this.lastChangedUser = lastChangedUser;
	}
	@Override
	public String toString() {
		return "CustomerTO [customerId=" + customerId + ", customerCode=" + customerCode + ", divisionCustomerCode="
				+ divisionCustomerCode + ", storeName=" + storeName + ", ownerFirstName=" + ownerFirstName
				+ ", ownerMiddleName=" + ownerMiddleName + ", ownerLastName=" + ownerLastName + ", emailAddress="
				+ emailAddress + ", customerStatus=" + customerStatus + ", customerStatusDescription="
				+ customerStatusDescription + ", coordinateX=" + coordinateX + ", coordinateY=" + coordinateY
				+ ", assignedUser=" + assignedUser + ", mayorPermitNo=" + mayorPermitNo + ", mayorPermitExpDate="
				+ mayorPermitExpDate + ", ltoFdaNo=" + ltoFdaNo + ", ltoFdaExpDate=" + ltoFdaExpDate + ", dtiNo="
				+ dtiNo + ", dtiExpDate=" + dtiExpDate + ", birOcn=" + birOcn + ", birRegDate=" + birRegDate
				+ ", storePhoto=" + storePhoto + ", b64EncodedImg=" + b64EncodedImg + ", remarks=" + remarks
				+ ", entryTimestamp=" + entryTimestamp + ", lastChangedTimestamp=" + lastChangedTimestamp
				+ ", lastChangedUser=" + lastChangedUser + ", lastChangedUsername=" + lastChangedUsername
				+ ", assignedUsername=" + assignedUsername + ", salesmanInitials=" + salesmanInitials + "]";
	}
	public String getCustomerStatus() {
		return customerStatus;
	}
	public void setCustomerStatus(String customerStatus) {
		this.customerStatus = customerStatus;
	}
	public String getMayorPermitNo() {
		return mayorPermitNo;
	}
	public void setMayorPermitNo(String mayorPermitNo) {
		this.mayorPermitNo = mayorPermitNo;
	}
	public LocalDate getMayorPermitExpDate() {
		return mayorPermitExpDate;
	}
	public void setMayorPermitExpDate(LocalDate mayorPermitExpDate) {
		this.mayorPermitExpDate = mayorPermitExpDate;
	}
	public String getLtoFdaNo() {
		return ltoFdaNo;
	}
	public void setLtoFdaNo(String ltoFdaNo) {
		this.ltoFdaNo = ltoFdaNo;
	}
	public LocalDate getLtoFdaExpDate() {
		return ltoFdaExpDate;
	}
	public void setLtoFdaExpDate(LocalDate ltoFdaExpDate) {
		this.ltoFdaExpDate = ltoFdaExpDate;
	}
	public String getDtiNo() {
		return dtiNo;
	}
	public void setDtiNo(String dtiNo) {
		this.dtiNo = dtiNo;
	}
	public LocalDate getDtiExpDate() {
		return dtiExpDate;
	}
	public void setDtiExpDate(LocalDate dtiExpDate) {
		this.dtiExpDate = dtiExpDate;
	}
	public String getBirOcn() {
		return birOcn;
	}
	public void setBirOcn(String birOcn) {
		this.birOcn = birOcn;
	}
	public LocalDate getBirRegDate() {
		return birRegDate;
	}
	public void setBirRegDate(LocalDate birRegDate) {
		this.birRegDate = birRegDate;
	}
	public String getStorePhoto() {
		return storePhoto;
	}
	public void setStorePhoto(String storePhoto) {
		this.storePhoto = storePhoto;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
 }
