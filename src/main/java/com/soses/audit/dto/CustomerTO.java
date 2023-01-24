package com.soses.audit.dto;

import java.math.BigDecimal;

public class CustomerTO {

	private int customerId;
    private String customerCode;
    private String divisionCustomerCode;
    private String storeName;
    private String ownerFirstName;
    private String ownerMiddleName;
    private String ownerLastName;
    private String emailAddress;
    private BigDecimal coordinateX;
    private BigDecimal coordinateY;
    private String assignedUser;
    private String entryTimestamp;
    private String lastChangedTimestamp;
    private String lastChangedUser;
    private String lastChangedUsername;
    private String assignedUsername;
    
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
				+ emailAddress + ", coordinateX=" + coordinateX + ", coordinateY=" + coordinateY + ", assignedUser="
				+ assignedUser + ", entryTimestamp=" + entryTimestamp + ", lastChangedTimestamp=" + lastChangedTimestamp
				+ ", lastChangedUser=" + lastChangedUser + ", lastChangedUsername=" + lastChangedUsername
				+ ", assignedUsername=" + assignedUsername + "]";
	}
 }
