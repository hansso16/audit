package com.soses.audit.api.customer;

import java.util.List;

import com.soses.audit.entity.CustomerAddress;

public class CustomerAddressRequest extends BaseCustomerRequest {

	private List<CustomerAddress> customerAddress;

	public List<CustomerAddress> getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(List<CustomerAddress> customerAddress) {
		this.customerAddress = customerAddress;
	}

	@Override
	public String toString() {
		return "CustomerAddressRequest [customerAddress=" + customerAddress + ", toString()=" + super.toString() + "]";
	}
}
