package com.soses.audit.bo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.soses.audit.common.GeneralUtil;
import com.soses.audit.dto.CustomerSalesmanHistoryTO;
import com.soses.audit.entity.CustomerSalesmanHistory;
import com.soses.audit.repository.CustomerSalesmanHistoryRepository;
import com.soses.audit.util.CustomerSalesmanHistoryUtil;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CustomerSalesmanHistoryBO {

	private static final Logger log = LoggerFactory.getLogger(CustomerSalesmanHistoryBO.class);
	
	private CustomerSalesmanHistoryRepository customerRepo;
	

	public CustomerSalesmanHistoryBO(CustomerSalesmanHistoryRepository customerRepo) {
		super();
		this.customerRepo = customerRepo;
	}
	
	public List<CustomerSalesmanHistoryTO> retrieveCustomerSalesmanHistoryTO(int customerId) throws Exception {
		
		List<CustomerSalesmanHistoryTO> list = null;
		try {
			List<CustomerSalesmanHistory> customerSalesmanHistoryList = customerRepo.findByCustomerId(customerId);
			if (!GeneralUtil.isListEmpty(customerSalesmanHistoryList)) {
				list = new ArrayList<>();
				for (CustomerSalesmanHistory csh : customerSalesmanHistoryList) {
					CustomerSalesmanHistoryTO to = CustomerSalesmanHistoryUtil.transformCustomerSalesmanHistoryEntity(csh);
					list.add(to);
				}
			}
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new Exception("Error retriveing Customer Salesman History: " + ex.getMessage());
		}
		return list;
	}
	
	public CustomerSalesmanHistory saveCustomerSalesmanHistory(CustomerSalesmanHistory csh) throws Exception {
		if (csh == null) { return null; }
		try {
			csh.setEntryTimestamp(LocalDateTime.now());
			csh = customerRepo.save(csh);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new Exception("Error saving Customer Salesman History: " + ex.getMessage());
		}
		return csh;
	}
}
