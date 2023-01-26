package com.soses.audit.util;

import com.soses.audit.common.CustomerStatusEnum;
import com.soses.audit.common.GeneralUtil;
import com.soses.audit.dto.CustomerTO;
import com.soses.audit.entity.Customer;

public class CustomerTransformerUtil {

	public static CustomerTO transformCustomerEntity(Customer customer) {
		CustomerTO customerDTO = null;
		if (customer != null) {
			customerDTO = new CustomerTO();
			customerDTO.setCustomerId(customer.getCustomerId());
			customerDTO.setCustomerCode(customer.getCustomerCode());
			customerDTO.setDivisionCustomerCode(customer.getDivisionCustomerCode());
			customerDTO.setStoreName(customer.getStoreName());
			customerDTO.setOwnerFirstName(customer.getOwnerFirstName());
			customerDTO.setOwnerLastName(customer.getOwnerLastName());
			customerDTO.setOwnerMiddleName(customer.getOwnerMiddleName());
			customerDTO.setEmailAddress(customer.getEmailAddress());
			customerDTO.setCoordinateX(customer.getCoordinateX());
			customerDTO.setCoordinateY(customer.getCoordinateY());
			customerDTO.setAssignedUser(customer.getAssignedUser());
			customerDTO.setEntryTimestamp(GeneralUtil.formatDateTime(customer.getEntryTimestamp()));
			customerDTO.setLastChangedTimestamp(GeneralUtil.formatDateTime(customer.getLastChangedTimestamp()));
			customerDTO.setLastChangedUser(customer.getLastChangedUser());
			customerDTO.setAssignedUsername(customer.getAssignedUser());
			customerDTO.setLastChangedUsername(customer.getLastChangedUser());
			customerDTO.setCustomerStatus(customer.getCustomerStatus());
			customerDTO.setCustomerStatusDescription(CustomerStatusEnum.deriveCustomerStatus(customerDTO.getCustomerStatus()));
			customerDTO.setRemarks(customer.getRemarks());
			customerDTO.setStorePhoto(customer.getStorePhoto());
			customerDTO.setMayorPermitExpDate(customer.getMayorPermitExpDate());
			customerDTO.setMayorPermitNo(customer.getMayorPermitNo());
			customerDTO.setLtoFdaExpDate(customer.getLtoFdaExpDate());
			customerDTO.setLtoFdaNo(customer.getLtoFdaNo());
			customerDTO.setDtiExpDate(customer.getDtiExpDate());
			customerDTO.setDtiNo(customer.getDtiNo());
			customerDTO.setBirOcn(customer.getBirOcn());
			customerDTO.setBirRegDate(customer.getBirRegDate());
		}
		return customerDTO;
	}
	
	public static Customer transformCustomerDetailsRequest(CustomerTO customerTO) {
		Customer customer = null;
		if (customerTO != null) {
			customer = new Customer();
			customer.setCustomerId(customerTO.getCustomerId());
			customer.setCustomerCode(customerTO.getCustomerCode());
			customer.setDivisionCustomerCode(customerTO.getDivisionCustomerCode());
			customer.setStoreName(customerTO.getStoreName());
			customer.setOwnerFirstName(customerTO.getOwnerFirstName());
			customer.setOwnerLastName(customerTO.getOwnerLastName());
			customer.setOwnerMiddleName(customerTO.getOwnerMiddleName());
			customer.setEmailAddress(customerTO.getEmailAddress());
			customer.setCoordinateX(customerTO.getCoordinateX());
			customer.setCoordinateY(customerTO.getCoordinateY());
			customer.setAssignedUser(customerTO.getAssignedUser());
			customer.setEntryTimestamp(GeneralUtil.stringToLocalDateTime(customerTO.getEntryTimestamp()));
			customer.setLastChangedTimestamp(GeneralUtil.stringToLocalDateTime(customerTO.getLastChangedTimestamp()));
			customer.setLastChangedUser(customerTO.getLastChangedUser());
			customer.setCustomerStatus(customerTO.getCustomerStatus());
			customer.setRemarks(customerTO.getRemarks());
			customer.setStorePhoto(customerTO.getStorePhoto());
			customer.setMayorPermitExpDate(customerTO.getMayorPermitExpDate());
			customer.setMayorPermitNo(customerTO.getMayorPermitNo());
			customer.setLtoFdaExpDate(customerTO.getLtoFdaExpDate());
			customer.setLtoFdaNo(customerTO.getLtoFdaNo());
			customer.setDtiExpDate(customerTO.getDtiExpDate());
			customer.setDtiNo(customerTO.getDtiNo());
			customer.setBirOcn(customerTO.getBirOcn());
			customer.setBirRegDate(customerTO.getBirRegDate());
		}
		return customer;
	}
}
