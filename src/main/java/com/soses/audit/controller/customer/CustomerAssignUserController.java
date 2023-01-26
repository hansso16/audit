package com.soses.audit.controller.customer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.soses.audit.common.GlobalConstants;
import com.soses.audit.service.customer.CustomerAssignUserService;

@Controller
@RequestMapping("/customer")
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class CustomerAssignUserController {

	private static final Logger log = LoggerFactory.getLogger(CustomerAssignUserController.class);
	
	private CustomerAssignUserService customerAssignUserService;
	
	public CustomerAssignUserController(CustomerAssignUserService customerAssignUserService) {
		super();
		this.customerAssignUserService = customerAssignUserService;
	}

	@PostMapping("/{customerCode}/assign")
	public RedirectView assignUser(@PathVariable String customerCode, Model model, RedirectAttributes redirectAttrs
			, @RequestParam String userCode) {
		
		log.info("CUSTOMER ASSIGN USER CONTROLLER.");
		String redirectUrl="/customer/" + customerCode + "/profile";
		RedirectView redirectView = new RedirectView(redirectUrl, true);
		redirectView.setExposeModelAttributes(false);
		if (customerAssignUserService.customerAssignUser(customerCode, userCode)) {
			redirectAttrs.addFlashAttribute(GlobalConstants.SUCCESS_MESSAGE, "Successfully assigned new user to customer.");
		} else {
			redirectAttrs.addFlashAttribute(GlobalConstants.ERROR_MESSAGE, GlobalConstants.GENERIC_ERROR_MESSAGE_DESC);
		}
		return redirectView;
	}
}
