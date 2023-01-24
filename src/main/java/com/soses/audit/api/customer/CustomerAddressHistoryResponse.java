package com.soses.audit.api.customer;

import java.util.List;

import com.soses.audit.dto.CustomerAddressHistoryTO;
import com.soses.audit.dto.CustomerTO;

public class CustomerAddressHistoryResponse extends BaseCustomerResponse {

	private CustomerTO customerTO;
	
	private List<CustomerAddressHistoryTO> customerAddressHistoryList;

	public List<CustomerAddressHistoryTO> getCustomerAddressHistoryList() {
		return customerAddressHistoryList;
	}

	public CustomerTO getCustomerTO() {
		return customerTO;
	}

	public void setCustomerTO(CustomerTO customerTO) {
		this.customerTO = customerTO;
	}

	public void setCustomerAddressHistoryList(List<CustomerAddressHistoryTO> customerAddressHistoryList) {
		this.customerAddressHistoryList = customerAddressHistoryList;
	}

	@Override
	public String toString() {
		return "CustomerAddressHistoryResponse [customerAddressHistoryList=" + customerAddressHistoryList
				+ ", toString()=" + super.toString() + "]";
	}
	
}
