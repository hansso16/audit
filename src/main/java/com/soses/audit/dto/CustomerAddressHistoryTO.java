package com.soses.audit.dto;

public class CustomerAddressHistoryTO {

	private int customerId;
	private String addressType;
	private String addressTypeDescription;
	private String street;
	private String municipal;
	private String municipalName;
	private String province;
	private String provinceName;
	private String region;
	private String regionName;
	private String zipCode;
	private String entryTimestamp;
	private String userCode;
	private String username;

	public String getAddressType() {
		return addressType;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}
	public String getAddressTypeDescription() {
		return addressTypeDescription;
	}
	public void setAddressTypeDescription(String addressTypeDescription) {
		this.addressTypeDescription = addressTypeDescription;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getMunicipal() {
		return municipal;
	}
	public void setMunicipal(String municipal) {
		this.municipal = municipal;
	}
	public String getMunicipalName() {
		return municipalName;
	}
	public void setMunicipalName(String municipalName) {
		this.municipalName = municipalName;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getRegionName() {
		return regionName;
	}
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getEntryTimestamp() {
		return entryTimestamp;
	}
	public void setEntryTimestamp(String entryTimestamp) {
		this.entryTimestamp = entryTimestamp;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "CustomerAddressHistoryTO [customerId=" + customerId + ", addressType=" + addressType
				+ ", addressTypeDescription=" + addressTypeDescription + ", street=" + street + ", municipal="
				+ municipal + ", municipalName=" + municipalName + ", province=" + province + ", provinceName="
				+ provinceName + ", region=" + region + ", regionName=" + regionName + ", zipCode=" + zipCode
				+ ", entryTimestamp=" + entryTimestamp + ", userCode=" + userCode + ", username=" + username + "]";
	}
}
