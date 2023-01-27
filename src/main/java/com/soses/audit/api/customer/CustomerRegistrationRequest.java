package com.soses.audit.api.customer;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.soses.audit.entity.Customer;
import com.soses.audit.entity.CustomerAddress;
import com.soses.audit.entity.CustomerPhone;

public class CustomerRegistrationRequest {

	private Customer customer;
	
	private List<CustomerPhone> customerPhone;
	
	private List<CustomerAddress> customerAddress;
	
	private MultipartFile file;

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<CustomerPhone> getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(List<CustomerPhone> customerPhone) {
		this.customerPhone = customerPhone;
	}

	public List<CustomerAddress> getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(List<CustomerAddress> customerAddress) {
		this.customerAddress = customerAddress;
	}

	@Override
	public String toString() {
		return "CustomerRegistrationRequest [customer=" + customer + ", customerPhone=" + customerPhone
				+ ", customerAddress=" + customerAddress + ", file=" + file + "]";
	}
	
}
