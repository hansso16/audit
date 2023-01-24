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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;

import com.soses.audit.api.customer.BaseCustomerResponse;
import com.soses.audit.common.GlobalConstants;
import com.soses.audit.service.customer.BaseCustomerService;

@Controller
@RequestMapping("/customer")
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class CustomerProfileController {

	private static final Logger log = LoggerFactory.getLogger(CustomerProfileController.class);
	
	private static final String CUST_PROFILE_PAGE = "customer/customer";
	
	private BaseCustomerService customerService;
	
	public CustomerProfileController(@Qualifier("CustomerProfileServiceImpl") BaseCustomerService customerService) {
		super();
		this.customerService = customerService;
	}

	@GetMapping("/{customerCode}/profile")
	@Validated
	public String getEmployee(@PathVariable String customerCode, Model model, @RequestParam(required = false, defaultValue = "false") boolean isUpdate) {
		
		log.info("CUSTOMER PROFILE CONTROLLER");
		BaseCustomerResponse res = customerService.getCustomerDetails(customerCode);
		res.setCustomerCode(customerCode);
		model.addAttribute("viewType", GlobalConstants.PROFILE_VIEW_TYPE);
		if (res!= null) {
//			List<ConfigParam> maritalStatusList = maritalStatusCache.getMaritalStatusList();
//			List<ConfigParam> genderList = genderCache.getGenderList();
//			model.addAttribute("maritalStatusList", maritalStatusList);
//			model.addAttribute("genderList", genderList);
			model.addAttribute("res", res);
			model.addAttribute("isUpdate", isUpdate);
//			model.addAttribute("isUser", isUser(employeeId));
		}
//		model.addAttribute("employeeProfileRequest", new EmployeeProfileRequest());
		return CUST_PROFILE_PAGE;
	}
}
