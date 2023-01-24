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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.soses.audit.api.customer.BaseCustomerResponse;
import com.soses.audit.api.customer.CustomerPhoneRequest;
import com.soses.audit.common.GlobalConstants;
import com.soses.audit.service.customer.impl.CustomerPhoneServiceImpl;

@Controller
@RequestMapping("/customer")
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class CustomerPhoneController {

private static final Logger log = LoggerFactory.getLogger(CustomerPhoneController.class);
	
	private static final String CUST_PROFILE_PAGE = "customer/customer";
	
	private CustomerPhoneServiceImpl customerService;
	
	public CustomerPhoneController(@Qualifier("CustomerPhoneServiceImpl") CustomerPhoneServiceImpl customerService) {
		super();
		this.customerService = customerService;
	}

	@GetMapping("/{customerCode}/phone")
	@Validated
	public String getEmployee(@PathVariable String customerCode, Model model, @RequestParam(required = false, defaultValue = "false") boolean isUpdate) {
		
		log.info("CUSTOMER PHONE CONTROLLER");
		BaseCustomerResponse res = customerService.getCustomerDetails(customerCode);
		res.setCustomerCode(customerCode);
		model.addAttribute("viewType", GlobalConstants.PHONE_VIEW_TYPE);
		if (res!= null) {
			model.addAttribute("res", res);
			model.addAttribute("isUpdate", isUpdate);
		}
		return CUST_PROFILE_PAGE;
	}
	
	@PostMapping(value="/{customerCode}/phone")
	public String updateCustomer(@PathVariable String customerCode, CustomerPhoneRequest request, Model model) {
		
		log.info("Request: " + request.toString());
		if (customerService.updateCustomerPhone(request)) {
			model.addAttribute(GlobalConstants.SUCCESS_MESSAGE, "Successfully updated customer phone.");
		} else {
			model.addAttribute(GlobalConstants.ERROR_MESSAGE, GlobalConstants.GENERIC_ERROR_MESSAGE_DESC);
		}
		
		return getEmployee(customerCode, model, false);
	}
	
	@GetMapping("/{customerCode}/phone/delete")
	public RedirectView deleteCustomerPhone(@PathVariable String customerCode, Model model, @RequestParam(required = true, defaultValue = "0") String customerPhoneId
			, RedirectAttributes redirectAttrs) {
		
		log.info("CUSTOMER PHONE DELETE CONTROLLER: " + customerPhoneId);
		
		String redirectUrl="/customer/" + customerCode + "/phone";
		RedirectView redirectView = new RedirectView(redirectUrl, true);
		redirectView.setExposeModelAttributes(false);
		try {
			if (customerService.deleteCustomerPhone(customerPhoneId)) {
				redirectAttrs.addFlashAttribute(GlobalConstants.SUCCESS_MESSAGE, "Successfully deleted customer phone.");
			} else {
				redirectAttrs.addFlashAttribute(GlobalConstants.ERROR_MESSAGE, GlobalConstants.GENERIC_ERROR_MESSAGE_DESC);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			redirectAttrs.addFlashAttribute(GlobalConstants.ERROR_MESSAGE, GlobalConstants.GENERIC_ERROR_MESSAGE_DESC);
		}
		return redirectView;
	}
	
	@GetMapping("/{customerCode}/phone/add")
	@Validated
	public String addCustomerPhone(@PathVariable String customerCode, Model model) {
		
		log.info("REGISTER CUSTOMER PHONE CONTROLLER");
		model.addAttribute("viewType", GlobalConstants.PHONE_ADD);
		BaseCustomerResponse res = customerService.getCustomerDetails(customerCode);
		res.setCustomerCode(customerCode);
		model.addAttribute("res", res);
		model.addAttribute("isUpdate", true);
		return CUST_PROFILE_PAGE;
	}
	
	@PostMapping(value="/{customerCode}/phone/add")
	public RedirectView saveEmployeeDependent(@PathVariable String customerCode, CustomerPhoneRequest request, Model model
			, RedirectAttributes redirectAttrs) {
		
		log.info("Request: " + request.toString());
		String redirectUrl="/customer/" + customerCode + "/phone";
		RedirectView redirectView = new RedirectView(redirectUrl, true);
		redirectView.setExposeModelAttributes(false);
		if (customerService.addCustomerPhone(request)) {
			redirectAttrs.addFlashAttribute(GlobalConstants.SUCCESS_MESSAGE, "Successfully added customer phone.");
		} else {
			redirectAttrs.addFlashAttribute(GlobalConstants.ERROR_MESSAGE, GlobalConstants.GENERIC_ERROR_MESSAGE_DESC);
		}
		
		return redirectView;
	}
}
