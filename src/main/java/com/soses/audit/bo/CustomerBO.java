package com.soses.audit.bo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.soses.audit.common.FlatFileService;
import com.soses.audit.dto.CustomerTO;
import com.soses.audit.entity.Customer;
import com.soses.audit.repository.CustomerRepository;
import com.soses.audit.util.CustomerTransformerUtil;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CustomerBO {

	private static final Logger log = LoggerFactory.getLogger(CustomerBO.class);
	
	private CustomerRepository customerRepo;
	
	private FlatFileService flatFileService;

	public CustomerBO(CustomerRepository customerRepo, FlatFileService flatFileService) {
		super();
		this.customerRepo = customerRepo;
		this.flatFileService = flatFileService;
	}
	
	public CustomerTO retrieveCustomer(String customerCode) throws Exception {
		
		CustomerTO dto = null;
		try {
			Customer customer = customerRepo.findByCustomerCode(customerCode);
			if (customer != null) {
				dto = CustomerTransformerUtil.transformCustomerEntity(customer);
				dto.setB64EncodedImg(flatFileService.getCustomerPhotoImgString(dto.getStorePhoto()));
			}
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new Exception("Error retriveing Customer: " + ex.getMessage());
		}
		return dto;
	}
	
	public Customer retrieveCustomerEntity(String customerCode) throws Exception {
		
		Customer customer = null;
		try {
			customer = customerRepo.findByCustomerCode(customerCode);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new Exception("Error retriveing Customer: " + ex.getMessage());
		}
		return customer;
	}
}
