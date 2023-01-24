package com.soses.audit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soses.audit.entity.CustomerPhone;

public interface CustomerPhoneRepository extends JpaRepository<CustomerPhone, String> {

	List<CustomerPhone> findByCustomerId(int customerId);
	
	int deleteByCustomerPhoneId(String customerPhoneId);
}
