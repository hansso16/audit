package com.soses.audit.service.customer.impl;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.soses.audit.api.customer.BaseCustomerResponse;
import com.soses.audit.api.customer.CustomerDetailsRequest;
import com.soses.audit.api.customer.CustomerDetailsResponse;
import com.soses.audit.bo.CustomerBO;
import com.soses.audit.bo.CustomerSalesmanHistoryBO;
import com.soses.audit.common.FlatFileService;
import com.soses.audit.common.GeneralUtil;
import com.soses.audit.common.StringUtil;
import com.soses.audit.dto.CustomerSalesmanHistoryTO;
import com.soses.audit.dto.CustomerTO;
import com.soses.audit.entity.Customer;
import com.soses.audit.entity.CustomerSalesmanHistory;
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
	
	private CustomerSalesmanHistoryBO customerSalesmanHistoryBO;
	
	private UserService userService;
	
	private CustomerRepository customerRepo;
	
	private FlatFileService flatFileService;
	
	public CustomerDetailsServiceImpl(CustomerBO customerBO, UserService userService
			, CustomerRepository customerRepo, FlatFileService flatFileService
			, CustomerSalesmanHistoryBO customerSalesmanHistoryBO) {
		super();
		this.customerBO = customerBO;
		this.userService = userService;
		this.customerRepo = customerRepo;
		this.flatFileService = flatFileService;
		this.customerSalesmanHistoryBO = customerSalesmanHistoryBO;
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
			
			List<CustomerSalesmanHistoryTO> customerSalesmanHistoryList = customerSalesmanHistoryBO.retrieveCustomerSalesmanHistoryTO(customerDTO.getCustomerId());
			if (!GeneralUtil.isListEmpty(customerSalesmanHistoryList)) {
				response.setCustomerSalesmanHistoryList(customerSalesmanHistoryList);
			}
		} catch (Exception ex) {
			log.error(ex.getMessage());
		}
		return response;
	}

	@Override
	public boolean updateCustomerDetails(CustomerDetailsRequest request) {
		if (request == null) {return false;}
		boolean isSuccess = false;
		try {
			Customer customer = CustomerTransformerUtil.transformCustomerDetailsRequest(request.getCustomerTO());
			String customerCode = customer.getCustomerCode();
			
			Customer dbCustomer = customerBO.retrieveCustomerEntity(customerCode);
			String salesmanInitials = customer.getSalesmanInitials();
			if (dbCustomer != null && !StringUtil.isEmpty(salesmanInitials) 
					&& !salesmanInitials.equalsIgnoreCase(dbCustomer.getSalesmanInitials())) {
				// insert into history
				CustomerSalesmanHistory csh = new CustomerSalesmanHistory();
				csh.setCustomerId(dbCustomer.getCustomerId());
				csh.setSalesmanInitials(dbCustomer.getSalesmanInitials().toUpperCase());
				csh = customerSalesmanHistoryBO.saveCustomerSalesmanHistory(csh);
			}
			
			// Upload photo
			String fileName = null;
			MultipartFile file = request.getStoreImage();
			if (file != null && !StringUtil.isEmpty(file.getOriginalFilename())) {
				try {
					fileName = flatFileService.uploadStorePhoto(file, customer);
					customer.setStorePhoto(fileName);
				} catch (IOException e) {
					e.printStackTrace();
					log.error(e.getMessage());
				}
			}
			customer.setLastChangedTimestamp(LocalDateTime.now());
			customerRepo.save(customer);
			isSuccess=true;
		} catch (Exception ex) {
			log.error(ex.getMessage());
		}
		return isSuccess;
	}
}
