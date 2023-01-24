package com.soses.audit.api.customer;

import java.util.List;

import com.soses.audit.entity.CustomerPhone;

public class CustomerPhoneRequest extends BaseCustomerRequest {

	private List<CustomerPhone> customerPhone;

	public List<CustomerPhone> getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(List<CustomerPhone> customerPhone) {
		this.customerPhone = customerPhone;
	}

	@Override
	public String toString() {
		return "CustomerPhoneRequest [customerPhone=" + customerPhone + ", toString()=" + super.toString() + "]";
	}
	
}
