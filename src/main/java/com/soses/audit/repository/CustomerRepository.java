package com.soses.audit.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.soses.audit.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String>{

	Customer findByCustomerCode(String customerCode);
	
	Page<Customer> findByCustomerCodeContainsOrStoreNameContainsOrOwnerFirstNameContainsOrOwnerLastNameContains
		(String customerCode, String storeName, String ownerFirstName, String ownerLastName, Pageable pageable);
}
