package com.soses.audit.util;

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
		}
		return customer;
	}
}
