package com.soses.audit.bo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import com.soses.audit.common.GeneralUtil;
import com.soses.audit.dto.CustomerPhoneTO;
import com.soses.audit.entity.CustomerPhone;
import com.soses.audit.repository.CustomerPhoneRepository;
import com.soses.audit.util.CustomerPhoneTransformerUtil;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CustomerPhoneBO {

	private CustomerPhoneRepository customerPhoneRepo;
	
	public CustomerPhoneBO(CustomerPhoneRepository customerPhoneRepo) {
		super();
		this.customerPhoneRepo = customerPhoneRepo;
	}
	
	public List<CustomerPhoneTO> retrieveCustomerPhoneTOList(int customerId) throws Exception {
		
		List<CustomerPhoneTO> list = null;
		try {
			List<CustomerPhone> customerPhoneList = customerPhoneRepo.findByCustomerId(customerId);
			if (!GeneralUtil.isListEmpty(customerPhoneList)) {
				list = new ArrayList<>();
				for (CustomerPhone customer : customerPhoneList) {
					CustomerPhoneTO to = CustomerPhoneTransformerUtil.transformCustomerPhoneEntity(customer);
					list.add(to);
				}
			}
		} catch (Exception ex) {
			throw new Exception("retrieveCustomerPhoneTOList(int customerId): Error retriveing Customer Phone Details");
		}
		return list;
	}
	
	public List<CustomerPhone> retrieveCustomerPhoneList(int customerId) throws Exception {
		
		List<CustomerPhone> list = null;
		try {
			list = customerPhoneRepo.findByCustomerId(customerId);
			if (GeneralUtil.isListEmpty(list)) {
				throw new Exception("Customer Phone is null. Invalid Customer Id.");
			}
		} catch (Exception ex) {
			throw new Exception("retrieveCustomerPhoneList(int customerId): Error retriveing Customer Phone Details");
		}
		return list;
	}
	
	public List<CustomerPhone> saveAll(List<CustomerPhone> customerPhoneList) throws Exception {
		List<CustomerPhone> list = null;
		try {
			list = customerPhoneRepo.saveAll(customerPhoneList);
			if (GeneralUtil.isListEmpty(list)) {
				throw new Exception("Customer Phone is null. Invalid Customer Id.");
			}
		} catch (Exception ex) {
			throw new Exception("saveAll(List<CustomerPhone> customerPhoneList): Error saving Customer Phone Details");
		}
		return list;
	}
	
	@PreAuthorize("hasRole('ROLE_SUPV')")
	public boolean deleteCustomerPhone(String customerPhoneId) throws Exception {
		boolean isSuccess= false;
		try {
			int i = customerPhoneRepo.deleteByCustomerPhoneId(customerPhoneId);
			if (i > 0) {
				isSuccess = true;
			}
		} catch (Exception ex) {
			throw new Exception("saveAll(List<CustomerPhone> customerPhoneList): Error deleting Customer Phone Details: " + ex.getMessage());
		}
		return isSuccess;
	}
}
