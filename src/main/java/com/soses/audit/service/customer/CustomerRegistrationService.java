package com.soses.audit.service.customer;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.soses.audit.api.customer.CustomerRegistrationRequest;
import com.soses.audit.common.FlatFileService;
import com.soses.audit.common.GeneralUtil;
import com.soses.audit.common.StringUtil;
import com.soses.audit.entity.Customer;
import com.soses.audit.entity.CustomerAddress;
import com.soses.audit.entity.CustomerPhone;
import com.soses.audit.entity.User;
import com.soses.audit.repository.CustomerAddressRepository;
import com.soses.audit.repository.CustomerPhoneRepository;
import com.soses.audit.repository.CustomerRepository;
import com.soses.audit.service.user.UserService;

import jakarta.transaction.Transactional;

@Service
@Transactional
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CustomerRegistrationService {

	private static final Logger log = LoggerFactory.getLogger(CustomerRegistrationService.class);
	
	private CustomerRepository customerRepo;
	
	private CustomerPhoneRepository customerPhoneRepo;
	
	private CustomerAddressRepository customerAddressRepo;
	
	private UserService userService;
	
	private FlatFileService flatFileService;
	
	public CustomerRegistrationService(CustomerRepository customerRepo, CustomerAddressRepository customerAddressRepo,
			CustomerPhoneRepository customerPhoneRepo, UserService userService, FlatFileService flatFileService) {
		super();
		this.customerRepo = customerRepo;
		this.customerAddressRepo = customerAddressRepo;
		this.customerPhoneRepo = customerPhoneRepo;
		this.userService = userService;
		this.flatFileService = flatFileService;
	}

	public String registerNewCustomer(CustomerRegistrationRequest request) {
		if (request == null || request.getCustomer() == null
				|| GeneralUtil.isListEmpty(request.getCustomerAddress())) {
			return null;
		}
		
		String customerCode = null;
		try {
			String username = SecurityContextHolder.getContext().getAuthentication().getName();
			User user = userService.retrieveUserDetailsByUsername(username);
			if (user == null) {
				throw new Exception("Invalid authenticated user");
			}
			String userCode = user.getUserCode();
			
			Customer customer = request.getCustomer();
			customer.setCustomerCode(customer.getCustomerCode().toUpperCase());
			customer.setSalesmanInitials(customer.getSalesmanInitials().toUpperCase());
			customer.setDivisionCustomerCode(customer.getDivisionCustomerCode().toUpperCase());
			customer.setAssignedUser(userCode);
			customer.setLastChangedUser(userCode);
			customer.setEntryTimestamp(LocalDateTime.now());
			customer.setLastChangedTimestamp(LocalDateTime.now());
			customer = customerRepo.save(customer);
			if (customer == null) {
				throw new Exception("Something went wrong while saving Customer entity");				
			}
			int customerId = customer.getCustomerId();
			
			// Store Photo
			String fileName = null;
			MultipartFile file = request.getFile();
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
			customer = customerRepo.save(customer);
			
			// Phone Number
			List<CustomerPhone> customerPhoneList = request.getCustomerPhone();
			if (!GeneralUtil.isListEmpty(customerPhoneList)) {
				for (CustomerPhone customerPhone : customerPhoneList) {
					if (customerPhone != null) {
						customerPhone.setCustomerId(customerId);
						customerPhone.setEntryTimestamp(LocalDateTime.now());
						customerPhone.setUsername(username);
					}
				}
				customerPhoneList = customerPhoneRepo.saveAll(customerPhoneList);
			}
			
			//Customer Address
			List<CustomerAddress> customerAddressList = request.getCustomerAddress();
			if (!GeneralUtil.isListEmpty(customerAddressList)) {
				for (CustomerAddress customerAddress : customerAddressList) {
					if (customerAddress != null && customerAddress.getId() != null) {
						customerAddress.getId().setCustomerId(Integer.toString(customerId));
						customerAddress.setEntryTimestamp(LocalDateTime.now());
						customerAddress.setUserCode(userCode);
					}
				}
				customerAddressList = customerAddressRepo.saveAll(customerAddressList);
			}
			customerCode = customer.getCustomerCode();
		} catch (Exception ex) {
			log.error(ex.getMessage());
		}
		return customerCode;
	}
}
