package com.soses.audit.api.customer;

import com.soses.audit.api.BaseResponse;

public class BaseCustomerResponse extends BaseResponse {

	private String customerCode;
	
	private int customerId;

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

	@Override
	public String toString() {
		return "BaseCustomerResponse [customerCode=" + customerCode + ", customerId=" + customerId + "]";
	}
}
