package com.soses.audit.service.customer;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.soses.audit.api.customer.CustomerSearchRequest;
import com.soses.audit.common.GlobalConstants;
import com.soses.audit.common.StringUtil;
import com.soses.audit.entity.Customer;
import com.soses.audit.repository.CustomerRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CustomerSearchService {

	private final CustomerRepository customerRepo;

	public CustomerSearchService(CustomerRepository customerRepo) {
		super();
		this.customerRepo = customerRepo;
	}
	
	public Page<Customer> searchCustomer(CustomerSearchRequest request) {

		String searchText = request.getSearch();
		Page<Customer> customerPage = null;
		
		int pageSize = GlobalConstants.DEFAULT_SIZE;
		if (!StringUtil.isEmpty(request.getSize())) {
			pageSize = Integer.parseInt(request.getSize());
		}
		int currentPage = GlobalConstants.DEFAULT_PAGE;
		if (!StringUtil.isEmpty(request.getPage())) {
			currentPage = Integer.parseInt(request.getPage()) - 1;
		}
		Pageable page = PageRequest.of(currentPage, pageSize);
		
		if (!StringUtil.isEmpty(searchText)) {
			customerPage = customerRepo.findByCustomerCodeContainsOrStoreNameContainsOrOwnerFirstNameContainsOrOwnerLastNameContains(searchText, searchText, searchText, searchText, page);
		} else {
			customerPage = customerRepo.findAll(page);
		}
		return customerPage;
	}
}
