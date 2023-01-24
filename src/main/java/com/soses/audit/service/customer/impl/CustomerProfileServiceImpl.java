package com.soses.audit.service.customer.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.soses.audit.api.customer.BaseCustomerResponse;
import com.soses.audit.api.customer.CustomerProfileResponse;
import com.soses.audit.bo.CustomerAddressBO;
import com.soses.audit.bo.CustomerBO;
import com.soses.audit.bo.CustomerPhoneBO;
import com.soses.audit.dto.CustomerAddressTO;
import com.soses.audit.dto.CustomerPhoneTO;
import com.soses.audit.dto.CustomerTO;
import com.soses.audit.entity.User;
import com.soses.audit.service.customer.BaseCustomerService;
import com.soses.audit.service.user.UserService;

import jakarta.transaction.Transactional;

@Service("CustomerProfileServiceImpl")
@Transactional
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CustomerProfileServiceImpl implements BaseCustomerService {

	private static final Logger log = LoggerFactory.getLogger(CustomerProfileServiceImpl.class);
	
	private CustomerBO customerBO;
	
	private CustomerPhoneBO customerPhoneBO;
	
	private CustomerAddressBO customerAddressBO;
	
	private UserService userService;
	
	public CustomerProfileServiceImpl(CustomerBO customerBO, CustomerPhoneBO customerPhoneBO
			, CustomerAddressBO customerAddressBO, UserService userService) {
		super();
		this.customerBO = customerBO;
		this.customerPhoneBO = customerPhoneBO;
		this.customerAddressBO = customerAddressBO;
		this.userService = userService;
	}

	@Override
	public BaseCustomerResponse getCustomerDetails(String customerCode) {
		
		CustomerProfileResponse response = new CustomerProfileResponse();
		int customerId = 0;
		try {
			// Get Customer Details
			CustomerTO customerDTO = customerBO.retrieveCustomer(customerCode);
			if (customerDTO == null) {
				throw new Exception("getCustomerDetails(String customerCode): Customer is null.");
			}
			
			// Get User Details
			User assignedUser = userService.retrieveUserDetails(customerDTO.getAssignedUser());
			if (assignedUser != null) {
				customerDTO.setAssignedUsername(assignedUser.getUsername());
			}
			
			User lastAssignedUser = userService.retrieveUserDetails(customerDTO.getLastChangedUser());
			if (lastAssignedUser != null) {
				customerDTO.setLastChangedUsername(lastAssignedUser.getUsername());
			}
			response.setCustomerTO(customerDTO);

			// Get Customer Phone Details
			customerId = customerDTO.getCustomerId();
			List<CustomerPhoneTO> customerPhoneList = customerPhoneBO.retrieveCustomerPhoneTOList(customerId);
			if (customerPhoneList == null) {
				// add warning message? but no error
			}
			response.setCustomerPhoneList(customerPhoneList);
			
			// Get Customer Address Details
			List<CustomerAddressTO> customerAddressList = customerAddressBO.retrieveCustomerAddressList(customerId);
			if (customerAddressList == null) {
				// add warning message? but no error
			}
			response.setCustomerAddressList(customerAddressList);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			//ex.printStackTrace();
		}
		return response;
	}
}
