package com.soses.audit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soses.audit.entity.CustomerAddress;
import com.soses.audit.entity.CustomerAddressPK;

public interface CustomerAddressRepository extends JpaRepository<CustomerAddress, CustomerAddressPK> {

	List<CustomerAddress> findByIdCustomerId(int customerId);
	
	List<CustomerAddress> findByIdCustomerId(String customerId);
	
	
}
