package com.soses.audit.controller.user;

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

import com.soses.audit.api.user.UserSearchRequest;
import com.soses.audit.controller.BaseSearchController;
import com.soses.audit.entity.User;
import com.soses.audit.service.user.UserSearchService;

@Controller
@RequestMapping("/user")
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class UserSearchController extends BaseSearchController {

	private static final Logger log = LoggerFactory.getLogger(UserSearchController.class);
	
	private static final String TEMPLATE_PATH = "user/user_search";
	
	private UserSearchService userSearchService;
	
	public UserSearchController(UserSearchService userSearchService) {
		super();
		this.userSearchService = userSearchService;
	}
	
	@GetMapping("")
	public String searchEntity(UserSearchRequest request, Errors errors, Model model) {
		
		log.info("ENTER searchEntity(request,errors,model): request -> " + request.toString());
		String search = request.getSearch();
		if (search != null) {
			Page<User> userPage = userSearchService.searchUser(request);
			if (userPage != null) {
				setPaginationVariables(userPage, model);
				model.addAttribute("search", search);
			}
		}
		return TEMPLATE_PATH;
	}
}
