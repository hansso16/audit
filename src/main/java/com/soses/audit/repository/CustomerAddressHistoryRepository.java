package com.soses.audit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soses.audit.entity.CustomerAddressHistory;
import com.soses.audit.entity.CustomerAddressHistoryPK;

public interface CustomerAddressHistoryRepository extends JpaRepository<CustomerAddressHistory, CustomerAddressHistoryPK> {

	List<CustomerAddressHistory> findByIdCustomerIdAndIdAddressType(String customerId, String addressType);
}
