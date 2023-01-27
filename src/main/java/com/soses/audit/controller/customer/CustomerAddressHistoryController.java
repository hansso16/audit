package com.soses.audit.controller.customer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;

import com.soses.audit.api.customer.BaseCustomerResponse;
import com.soses.audit.common.GlobalConstants;
import com.soses.audit.repository.UserRepository;
import com.soses.audit.service.customer.impl.CustomerAddressHistoryService;

@Controller
@RequestMapping("/customer")
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class CustomerAddressHistoryController {

	private static final Logger log = LoggerFactory.getLogger(CustomerAddressHistoryController.class);
	
	private static final String CUST_PAGE = "customer/customer";
	
	private CustomerAddressHistoryService customerAddressHistoryService;
	
	public CustomerAddressHistoryController(CustomerAddressHistoryService customerAddressHistoryService
			, UserRepository userRepo) {
		super();
		this.customerAddressHistoryService = customerAddressHistoryService;
	}
	
	@GetMapping("/{customerCode}/address/history/{addressType}")
	@Validated
	public String getCustomerAddressHistory(@PathVariable String customerCode, Model model, @PathVariable String addressType) {
		
		log.info("CUSTOMER ADDRESS HISTORY CONTROLLER");
		BaseCustomerResponse res = customerAddressHistoryService.getCustomerAddressHistoryDetails(customerCode, addressType);
		res.setCustomerCode(customerCode);
		model.addAttribute("viewType", GlobalConstants.ADDRESS_HISTORY_VIEW_TYPE);
		if (res!= null) {
			model.addAttribute("res", res);
			model.addAttribute("isUpdate", true);
		}
		return CUST_PAGE;
	}
}
