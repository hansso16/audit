package com.soses.audit.api.customer;

import java.util.List;

import com.soses.audit.dto.CustomerAddressTO;

public class CustomerAddressResponse extends CustomerDetailsResponse {

	private List<CustomerAddressTO> customerAddressList;
	
	public List<CustomerAddressTO> getCustomerAddressList() {
		return customerAddressList;
	}

	public void setCustomerAddressList(List<CustomerAddressTO> customerAddressList) {
		this.customerAddressList = customerAddressList;
	}

	@Override
	public String toString() {
		return "CustomerAddressResponse [customerAddressList=" + customerAddressList + ", toString()="
				+ super.toString() + "]";
	}
}
