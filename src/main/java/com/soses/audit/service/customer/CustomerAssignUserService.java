package com.soses.audit.service.customer;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.soses.audit.entity.Customer;
import com.soses.audit.repository.CustomerRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CustomerAssignUserService {

	private static final Logger log = LoggerFactory.getLogger(CustomerAssignUserService.class);
	
	private CustomerRepository customerRepo;

	public CustomerAssignUserService(CustomerRepository customerRepo) {
		super();
		this.customerRepo = customerRepo;
	}

	public boolean customerAssignUser(String customerCode, String userCode) {
		boolean isSuccess = false;
		try {
			Customer customer = customerRepo.findByCustomerCode(customerCode);
			customer.setAssignedUser(userCode);
			customer.setLastChangedTimestamp(LocalDateTime.now());
			customer.setLastChangedUser(SecurityContextHolder.getContext().getAuthentication().getName());
			customerRepo.save(customer);
			isSuccess = true;
		} catch (Exception ex) {
			log.error(ex.getMessage());
			ex.printStackTrace();
		}
		return isSuccess;
	}
}
