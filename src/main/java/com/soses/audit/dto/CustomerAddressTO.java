package com.soses.audit.dto;

import java.util.List;

import com.soses.audit.entity.Municipal;
import com.soses.audit.entity.Province;
import com.soses.audit.entity.Region;

public class CustomerAddressTO {

	private String customerId;
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
	private List<Region> regionList;
	private List<Province> provinceList;
	private List<Municipal> municipalList;
	
	public List<Region> getRegionList() {
		return regionList;
	}
	public void setRegionList(List<Region> regionList) {
		this.regionList = regionList;
	}
	public List<Province> getProvinceList() {
		return provinceList;
	}
	public void setProvinceList(List<Province> provinceList) {
		this.provinceList = provinceList;
	}
	public List<Municipal> getMunicipalList() {
		return municipalList;
	}
	public void setMunicipalList(List<Municipal> municipalList) {
		this.municipalList = municipalList;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getAddressType() {
		return addressType;
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
	@Override
	public String toString() {
		return "CustomerAddressTO [customerId=" + customerId + ", addressType=" + addressType
				+ ", addressTypeDescription=" + addressTypeDescription + ", street=" + street + ", municipal="
				+ municipal + ", municipalName=" + municipalName + ", province=" + province + ", provinceName="
				+ provinceName + ", region=" + region + ", regionName=" + regionName + ", zipCode=" + zipCode
				+ ", entryTimestamp=" + entryTimestamp + ", userCode=" + userCode + ", regionList=" + regionList
				+ ", provinceList=" + provinceList + ", municipalList=" + municipalList + ", toString()="
				+ super.toString() + "]";
	}
}
