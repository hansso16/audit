package com.soses.audit.bo;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.soses.audit.dto.CustomerTO;
import com.soses.audit.entity.Customer;
import com.soses.audit.repository.CustomerRepository;
import com.soses.audit.util.CustomerTransformerUtil;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CustomerBO {

	private CustomerRepository customerRepo;

	public CustomerBO(CustomerRepository customerRepo) {
		super();
		this.customerRepo = customerRepo;
	}
	
	public CustomerTO retrieveCustomer(String customerCode) throws Exception {
		
		CustomerTO dto = null;
		try {
			Customer customer = customerRepo.findByCustomerCode(customerCode);
			if (customer != null) {
				dto = CustomerTransformerUtil.transformCustomerEntity(customer);
			}
		} catch (Exception ex) {
			throw new Exception("Error retriveing Customer");
		}
		return dto;
	}
}
