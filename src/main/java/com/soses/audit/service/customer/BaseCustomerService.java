package com.soses.audit.service.customer;

import com.soses.audit.api.customer.BaseCustomerResponse;

public interface BaseCustomerService {

	BaseCustomerResponse getCustomerDetails(String customerCode); 
}
