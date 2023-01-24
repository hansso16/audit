package com.soses.audit.dto;

public class CustomerPhoneTO {

	private int customerPhoneId;
	private int customerId;
	private String phoneType;
	private String phoneTypeDescription;
	private String phoneNumber;
	private String entryTimestamp;
	private String username;

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEntryTimestamp() {
		return entryTimestamp;
	}
	public void setEntryTimestamp(String entryTimestamp) {
		this.entryTimestamp = entryTimestamp;
	}
	public int getCustomerPhoneId() {
		return customerPhoneId;
	}
	public void setCustomerPhoneId(int customerPhoneId) {
		this.customerPhoneId = customerPhoneId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getPhoneType() {
		return phoneType;
	}
	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}
	public String getPhoneTypeDescription() {
		return phoneTypeDescription;
	}
	public void setPhoneTypeDescription(String phoneTypeDescription) {
		this.phoneTypeDescription = phoneTypeDescription;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "CustomerPhoneTO [customerPhoneId=" + customerPhoneId + ", customerId=" + customerId + ", phoneType="
				+ phoneType + ", phoneTypeDescription=" + phoneTypeDescription + ", phoneNumber=" + phoneNumber
				+ ", entryTimestamp=" + entryTimestamp + ", username=" + username + "]";
	}
}
