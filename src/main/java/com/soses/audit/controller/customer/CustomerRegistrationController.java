package com.soses.audit.controller.customer;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.soses.audit.api.customer.CustomerRegistrationRequest;
import com.soses.audit.cache.region.RegionCacheService;
import com.soses.audit.common.GlobalConstants;
import com.soses.audit.common.StringUtil;
import com.soses.audit.entity.Region;
import com.soses.audit.service.customer.CustomerRegistrationService;

@Controller
@RequestMapping("/customer")
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class CustomerRegistrationController {

	private static final Logger log = LoggerFactory.getLogger(CustomerRegistrationController.class);
	
	private static final String CUSTOMER_REGISTRATION_PATH = "customer/customer_registration";
	
	private static final String CUSTOMER_REGISTRATION_SUCCESS = "customer/customer_registration_success";
	
	private RegionCacheService regionCache;
	
	private CustomerRegistrationService customerSerivce;
	
	public CustomerRegistrationController(RegionCacheService regionCache, CustomerRegistrationService customerSerivce) {
		super();
		this.regionCache = regionCache;
		this.customerSerivce = customerSerivce;
	}
	
	@GetMapping("/add")
	public String registerCustomer(Model model) {
		log.info("ENTER registerCustomer()");
		List<Region> regionList = regionCache.findAll();
		model.addAttribute("regionList", regionList);
		return CUSTOMER_REGISTRATION_PATH;
	}

	@PostMapping("/add")
	public RedirectView registerCustomer(CustomerRegistrationRequest request, Model model
			, RedirectAttributes redirectAttrs) {
		
		log.info("registerCustomer(request):" + request.toString());
		String redirectUrl=null;
		String customerCode = customerSerivce.registerNewCustomer(request);
		
		if (StringUtil.isEmpty(customerCode)) {
			//model.addAttribute(GlobalConstants.ERROR_MESSAGE, GlobalConstants.GENERIC_ERROR_MESSAGE_DESC);
			redirectAttrs.addFlashAttribute(GlobalConstants.ERROR_MESSAGE, GlobalConstants.GENERIC_ERROR_MESSAGE_DESC);
			redirectUrl = "/customer/add";
		} else {
			redirectAttrs.addFlashAttribute("customerCode", customerCode);
			redirectUrl = "/customer/add/success";
		}
		
		RedirectView redirectView = new RedirectView(redirectUrl, true);
		redirectView.setExposeModelAttributes(false);
		return redirectView;
	}
	
	@GetMapping("/add/success")
	public String registerCustomerSuccess(Model model) {
		log.info("ENTER registerCustomerSuccess(Model model)");
		String customerCode = (String) model.getAttribute("customerCode");
		if (StringUtil.isEmpty(customerCode)) {
			return registerCustomer(model);
		}
		return CUSTOMER_REGISTRATION_SUCCESS;
	}
}
