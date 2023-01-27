package com.soses.audit.util;

import com.soses.audit.common.GeneralUtil;
import com.soses.audit.dto.CustomerSalesmanHistoryTO;
import com.soses.audit.entity.CustomerSalesmanHistory;

public class CustomerSalesmanHistoryUtil {

	public static CustomerSalesmanHistoryTO transformCustomerSalesmanHistoryEntity(CustomerSalesmanHistory customer) {
		CustomerSalesmanHistoryTO customerSalesmanHistoryTO = null;
		if (customer != null) {
			customerSalesmanHistoryTO = new CustomerSalesmanHistoryTO();
			customerSalesmanHistoryTO.setCustomerId(customer.getCustomerSalesmanHistoryId());
			customerSalesmanHistoryTO.setCustomerSalesmanHistoryId(customer.getCustomerSalesmanHistoryId());
			customerSalesmanHistoryTO.setEntryTimestamp(GeneralUtil.formatDateTime(customer.getEntryTimestamp()));
			customerSalesmanHistoryTO.setSalesmanInitials(customer.getSalesmanInitials());
		}
		return customerSalesmanHistoryTO;
	}
}
