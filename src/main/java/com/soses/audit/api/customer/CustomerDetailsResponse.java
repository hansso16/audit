package com.soses.audit.api.customer;

import com.soses.audit.dto.CustomerTO;

public class CustomerDetailsResponse extends BaseCustomerResponse {

	private CustomerTO customerTO;
	
	public CustomerTO getCustomerTO() {
		return customerTO;
	}

	public void setCustomerTO(CustomerTO customerTO) {
		this.customerTO = customerTO;
	}

	@Override
	public String toString() {
		return "CustomerDetailsResponse [customerTO=" + customerTO + ", toString()=" + super.toString() + "]";
	}
	
}
