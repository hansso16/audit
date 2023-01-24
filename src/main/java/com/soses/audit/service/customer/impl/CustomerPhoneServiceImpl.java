package com.soses.audit.service.customer.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.soses.audit.api.customer.BaseCustomerResponse;
import com.soses.audit.api.customer.CustomerPhoneRequest;
import com.soses.audit.api.customer.CustomerPhoneResponse;
import com.soses.audit.bo.CustomerBO;
import com.soses.audit.bo.CustomerPhoneBO;
import com.soses.audit.common.GeneralUtil;
import com.soses.audit.dto.CustomerPhoneTO;
import com.soses.audit.dto.CustomerTO;
import com.soses.audit.entity.CustomerPhone;
import com.soses.audit.service.customer.BaseCustomerService;
import com.soses.audit.util.CustomerPhoneTransformerUtil;

import jakarta.transaction.Transactional;

@Service("CustomerPhoneServiceImpl")
@Transactional
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CustomerPhoneServiceImpl implements BaseCustomerService {

	private static final Logger log = LoggerFactory.getLogger(CustomerPhoneServiceImpl.class);
	
	private CustomerBO customerBO;
	
	private CustomerPhoneBO customerPhoneBO;
	
	public CustomerPhoneServiceImpl(CustomerBO customerBO, CustomerPhoneBO customerPhoneBO) {
		super();
		this.customerBO = customerBO;
		this.customerPhoneBO = customerPhoneBO;
	}
	
	@Override
	public BaseCustomerResponse getCustomerDetails(String customerCode) {

		CustomerPhoneResponse response = new CustomerPhoneResponse();
		response.setCustomerCode(customerCode);
		int customerId = 0;
		try {
			// Get Customer Details
			CustomerTO customerDTO = customerBO.retrieveCustomer(customerCode);
			if (customerDTO == null) {
				throw new Exception("getCustomerDetails(String customerCode): Customer is null.");
			}

			// Get Customer Phone Details
			customerId = customerDTO.getCustomerId();
			response.setCustomerTO(customerDTO);
			response.setCustomerId(customerId);
			List<CustomerPhoneTO> customerPhoneList = customerPhoneBO.retrieveCustomerPhoneTOList(customerId);
			if (customerPhoneList == null) {
				throw new Exception("getCustomerDetails(String customerCode): Customer Phone is null.");
			}
			response.setCustomerPhoneTOList(customerPhoneList);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			//ex.printStackTrace();
		}
		return response;
	}
	
	public boolean updateCustomerPhone(CustomerPhoneRequest request) {
		boolean isSuccess = false;
		if (request == null || GeneralUtil.isListEmpty(request.getCustomerPhone())) {
			return isSuccess;
		}
		List<CustomerPhone> reqCustomerPhoneList = request.getCustomerPhone();
		List<CustomerPhone> customerPhoneList = new ArrayList<>();
		int customerId = request.getCustomerId();
		try {
			List<CustomerPhone> dbCustomerPhoneList = customerPhoneBO.retrieveCustomerPhoneList(customerId);
			if (dbCustomerPhoneList == null) {
				throw new Exception("Customer Phone is null. Invalid Customer ID");
			}
			
			Collections.sort(dbCustomerPhoneList, (o1, o2) -> o1.getCustomerPhoneId() - o2.getCustomerPhoneId());
			Collections.sort(reqCustomerPhoneList, Comparator.comparing(CustomerPhone::getCustomerPhoneId));
			
			for (int i = 0; i < dbCustomerPhoneList.size(); i++) {
				CustomerPhone dbCustomerPhone = dbCustomerPhoneList.get(i);
				CustomerPhone reqCustomerPhone = reqCustomerPhoneList.get(i);
				if (CustomerPhoneTransformerUtil.isChanged(dbCustomerPhone, reqCustomerPhone)) {
					reqCustomerPhone.setEntryTimestamp(LocalDateTime.now());
					customerPhoneList.add(reqCustomerPhone);
				}
			}
			
			if (!GeneralUtil.isListEmpty(customerPhoneList)) {
				customerPhoneList = customerPhoneBO.saveAll(customerPhoneList);
			}
			isSuccess=true;
		} catch (Exception ex) {
			log.error(ex.getMessage());
		}
		return isSuccess;
	}
	
	@PreAuthorize("hasRole('ROLE_SUPV')")
	public boolean deleteCustomerPhone(String customerPhoneId) {
		boolean isSuccess = false;
		try {
			isSuccess = customerPhoneBO.deleteCustomerPhone(customerPhoneId);
		} catch (Exception ex) {
			log.error(ex.getMessage());
		}
		return isSuccess;
	}
	
	public boolean addCustomerPhone(CustomerPhoneRequest request) {
		boolean isSuccess = false;
		if (request == null || GeneralUtil.isListEmpty(request.getCustomerPhone())) {
			return isSuccess;
		}
		try {
			
			List<CustomerPhone> customerPhoneList = request.getCustomerPhone();
			for (CustomerPhone customerPhone : customerPhoneList) {
				customerPhone.setEntryTimestamp(LocalDateTime.now());
				customerPhone.setUsername(SecurityContextHolder.getContext().getAuthentication().getName());
			}
			customerPhoneList = customerPhoneBO.saveAll(customerPhoneList);
			isSuccess = true;
		} catch (Exception ex) {
			log.error(ex.getMessage());
		}
		return isSuccess;
	}

}
