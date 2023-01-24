package com.soses.audit.service.customer.impl;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.soses.audit.api.customer.BaseCustomerResponse;
import com.soses.audit.api.customer.CustomerDetailsRequest;
import com.soses.audit.api.customer.CustomerDetailsResponse;
import com.soses.audit.bo.CustomerBO;
import com.soses.audit.dto.CustomerTO;
import com.soses.audit.entity.Customer;
import com.soses.audit.entity.User;
import com.soses.audit.repository.CustomerRepository;
import com.soses.audit.service.user.UserService;
import com.soses.audit.util.CustomerTransformerUtil;

import jakarta.transaction.Transactional;

@Service("CustomerDetailsServiceImpl")
@Transactional
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CustomerDetailsServiceImpl implements CustomerDetailsService {

	private static final Logger log = LoggerFactory.getLogger(CustomerDetailsServiceImpl.class);
	
	private CustomerBO customerBO;
	
	private UserService userService;
	
	private CustomerRepository customerRepo;
	
	public CustomerDetailsServiceImpl(CustomerBO customerBO, UserService userService
			, CustomerRepository customerRepo) {
		super();
		this.customerBO = customerBO;
		this.userService = userService;
		this.customerRepo = customerRepo;
	}
	
	@Override
	public BaseCustomerResponse getCustomerDetails(String customerCode) {
		CustomerDetailsResponse response = new CustomerDetailsResponse();
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

		} catch (Exception ex) {
			log.error(ex.getMessage());
			//ex.printStackTrace();
		}
		return response;
	}

	@Override
	public boolean updateCustomerDetails(CustomerDetailsRequest request) {

		//String customerId = request.customer();
		boolean isSuccess = false;
		if (request != null) {
			Customer customer = CustomerTransformerUtil.transformCustomerDetailsRequest(request.getCustomerTO());
			
			// Upload photo
//			String fileName = null;
//			MultipartFile file = request.getFile();
//			if (file != null && !StringUtil.isEmpty(file.getOriginalFilename())) {
//				try {
//					fileName = flatFileService.uploadEmployeePhoto(file, employeeId);
//					employee.setPhoto(fileName);
//				} catch (IOException e) {
//					e.printStackTrace();
//					log.error(e.getMessage());
//				}
//			}
			
			customer.setLastChangedTimestamp(LocalDateTime.now());
			customerRepo.save(customer);
			
			isSuccess=true;
		}
		return isSuccess;
	}
}
