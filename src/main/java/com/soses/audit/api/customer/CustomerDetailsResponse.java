package com.soses.audit.api.customer;

import java.util.List;

import com.soses.audit.dto.CustomerSalesmanHistoryTO;
import com.soses.audit.dto.CustomerTO;

public class CustomerDetailsResponse extends BaseCustomerResponse {

	private CustomerTO customerTO;
	
	private List<CustomerSalesmanHistoryTO> customerSalesmanHistoryList;
	
	public List<CustomerSalesmanHistoryTO> getCustomerSalesmanHistoryList() {
		return customerSalesmanHistoryList;
	}

	public void setCustomerSalesmanHistoryList(List<CustomerSalesmanHistoryTO> customerSalesmanHistoryList) {
		this.customerSalesmanHistoryList = customerSalesmanHistoryList;
	}

	public CustomerTO getCustomerTO() {
		return customerTO;
	}

	public void setCustomerTO(CustomerTO customerTO) {
		this.customerTO = customerTO;
	}

	@Override
	public String toString() {
		return "CustomerDetailsResponse [customerTO=" + customerTO + ", customerSalesmanHistoryList="
				+ customerSalesmanHistoryList + ", toString()=" + super.toString() + "]";
	}
	
}
