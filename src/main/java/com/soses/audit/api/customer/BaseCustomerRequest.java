package com.soses.audit.api.customer;

public class BaseCustomerRequest {

	private int customerId;
	
	private String customerCode;

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
		return "BaseCustomerRequest [customerId=" + customerId + ", customerCode=" + customerCode + "]";
	}
}
