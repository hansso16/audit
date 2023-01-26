package com.soses.audit.common;

public enum CustomerStatusEnum {

	ACTIVE("10", "ACTIVE"), 
	INACTIVE("20", "INACTIVE") 
	;
	
	private final String customerStatus;
	
	private final String customerStatusDescription;

	private CustomerStatusEnum(String customerStatus, String customerStatusDescription) {
		this.customerStatus = customerStatus;
		this.customerStatusDescription = customerStatusDescription;
	}

	public String getCustomerStatus() {
		return customerStatus;
	}

	public String getCustomerStatusDescription() {
		return customerStatusDescription;
	}

	public static CustomerStatusEnum valueOfCustomerStatus(String customerStatus) {
	    for (CustomerStatusEnum e : values()) {
	        if (e.customerStatus.equals(customerStatus)) {
	            return e;
	        }
	    }
	    return null;
	}

	public static String deriveCustomerStatus(String customerStatus) {
		for (CustomerStatusEnum e : values()) {
			if (e.customerStatus.equals(customerStatus)) {
				return e.getCustomerStatusDescription();
			}
		}
		return null;
	}
}
