package com.soses.audit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soses.audit.entity.CustomerSalesmanHistory;

public interface CustomerSalesmanHistoryRepository extends JpaRepository<CustomerSalesmanHistory, String>{

	List<CustomerSalesmanHistory> findByCustomerId(int customerId);
	
	List<CustomerSalesmanHistory> findByCustomerId(String customerId);
}
