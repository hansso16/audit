package com.soses.audit.controller.customer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;

import com.soses.audit.api.customer.BaseCustomerResponse;
import com.soses.audit.api.customer.CustomerAddressRequest;
import com.soses.audit.common.GlobalConstants;
import com.soses.audit.service.customer.impl.CustomerAddressServiceImpl;

@Controller
@RequestMapping("/customer")
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class CustomerAddressController {

	private static final Logger log = LoggerFactory.getLogger(CustomerAddressController.class);

	private static final String CUST_PROFILE_PAGE = "customer/customer";
	
	private CustomerAddressServiceImpl customerService;
	
	public CustomerAddressController(@Qualifier("CustomerAddressServiceImpl") CustomerAddressServiceImpl customerService) {
		super();
		this.customerService = customerService;
	}

	@GetMapping("/{customerCode}/address")
	@Validated
	public String getCustomerAddress(@PathVariable String customerCode, Model model, @RequestParam(required = false, defaultValue = "false") boolean isUpdate) {
		
		log.info("CUSTOMER ADDRESS CONTROLLER");
		BaseCustomerResponse res = customerService.getCustomerDetails(customerCode);
		res.setCustomerCode(customerCode);
		model.addAttribute("viewType", GlobalConstants.ADDRESS_VIEW_TYPE);
		if (res!= null) {
			model.addAttribute("res", res);
			model.addAttribute("isUpdate", isUpdate);
		}
		return CUST_PROFILE_PAGE;
	}
	
	@PostMapping(value="/{customerCode}/address")
	public String updateCustomerAddress(@PathVariable String customerCode, CustomerAddressRequest request, Model model) {
		
		log.info("Request: " + request.toString());
		if (customerService.updateCustomerAddress(request)) {
			model.addAttribute(GlobalConstants.SUCCESS_MESSAGE, "Successfully updated customer address.");
		} else {
			model.addAttribute(GlobalConstants.ERROR_MESSAGE, GlobalConstants.GENERIC_ERROR_MESSAGE_DESC);
		}
		
		return getCustomerAddress(customerCode, model, false);
	}
}
