package com.soses.audit.service.customer.impl;

import com.soses.audit.api.customer.CustomerDetailsRequest;
import com.soses.audit.service.customer.BaseCustomerService;

public interface CustomerDetailsService extends BaseCustomerService {

	boolean updateCustomerDetails(CustomerDetailsRequest request);
}
