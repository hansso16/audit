package com.soses.audit.api.customer;

import java.util.List;

import com.soses.audit.dto.CustomerPhoneTO;
import com.soses.audit.dto.CustomerTO;

public class CustomerPhoneResponse extends BaseCustomerResponse {

	private CustomerTO customerTO;
	private List<CustomerPhoneTO> customerPhoneTOList;

		
	public CustomerTO getCustomerTO() {
		return customerTO;
	}

	public void setCustomerTO(CustomerTO customerTO) {
		this.customerTO = customerTO;
	}

	public List<CustomerPhoneTO> getCustomerPhoneTOList() {
		return customerPhoneTOList;
	}

	public void setCustomerPhoneTOList(List<CustomerPhoneTO> customerPhoneTOList) {
		this.customerPhoneTOList = customerPhoneTOList;
	}

	@Override
	public String toString() {
		return "CustomerPhoneResponse [customerPhoneTOList=" + customerPhoneTOList + ", toString()=" + super.toString()
				+ "]";
	}
	
}
