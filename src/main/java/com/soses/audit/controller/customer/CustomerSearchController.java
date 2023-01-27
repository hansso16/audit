package com.soses.audit.controller.customer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;

import com.soses.audit.api.customer.CustomerSearchRequest;
import com.soses.audit.controller.BaseSearchController;
import com.soses.audit.entity.Customer;
import com.soses.audit.service.customer.CustomerSearchService;

@Controller
@RequestMapping("/customer")
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class CustomerSearchController extends BaseSearchController {

	private static final Logger log = LoggerFactory.getLogger(CustomerSearchController.class);
	
	private static final String TEMPLATE_PATH = "customer/customer_search";
	
	private CustomerSearchService customerSearchService;
	
	public CustomerSearchController(CustomerSearchService customerSearchService) {
		super();
		this.customerSearchService = customerSearchService;
	}
	
	@GetMapping("")
	public String searchEntity(CustomerSearchRequest request, Errors errors, Model model) {
		
		log.info("ENTER searchEntity(request,errors,model): request -> " + request.toString());
		Page<Customer> customerPage = null;
		String searchText = request.getSearch();
//		if (!StringUtil.isEmpty(searchText)) {
		if (searchText != null) {
			customerPage = customerSearchService.searchCustomer(request);
			if (customerPage != null) {
				setPaginationVariables(customerPage, model);
				model.addAttribute("search", searchText);
			}
		}
		return TEMPLATE_PATH;
	}
}
