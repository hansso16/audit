package com.soses.audit.controller.user;

import java.security.Principal;
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

import com.soses.audit.api.user.UserRegistrationRequest;
import com.soses.audit.api.user.UserRegistrationResponse;
import com.soses.audit.cache.role.RoleCacheService;
import com.soses.audit.common.GlobalConstants;
import com.soses.audit.common.StringUtil;
import com.soses.audit.entity.Role;
import com.soses.audit.service.user.UserRegistrationService;

@Controller
@RequestMapping("/user")
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class UserRegistrationController {

	private static final Logger log = LoggerFactory.getLogger(UserRegistrationController.class);
	
	private static final String USER_REGISTRATION = "user/user_registration";
	
	private RoleCacheService roleCache;
	
	private UserRegistrationService userRegistrationService;
	
	public UserRegistrationController(RoleCacheService roleCache, UserRegistrationService userRegistrationService) {
		super();
		this.roleCache = roleCache;
		this.userRegistrationService = userRegistrationService;
	}

	@GetMapping("/add")
	public String addEmployee(Model model, Principal principal) {
		log.info("ENTER GET:addEmployee(model,principal)");
		
		List<Role> roleList = roleCache.findAll();
		model.addAttribute("roleList", roleList);
		return USER_REGISTRATION;
	}
	
	@PostMapping("/add")
	public RedirectView addEmployee(Model model, UserRegistrationRequest request, RedirectAttributes redirectAttrs, Principal principal) {
		log.info("ENTER POST(model, request):"+request.toString());
		
		UserRegistrationResponse res = userRegistrationService.registerUser(request, principal);
		RedirectView redirectView = new RedirectView();
		redirectView.setContextRelative(true);
		redirectView.setExposeModelAttributes(false);
		
		if (res != null) {
			if (res.getError() != null) {
				String redirectUrl = "/user/add";
				redirectView.setUrl(redirectUrl);
				redirectAttrs.addFlashAttribute(GlobalConstants.ERROR_MESSAGE, res.getError().getMessage());
				return redirectView;
			}
			if (!StringUtil.isEmpty(res.getResponseMessage())) {
				String redirectUrl = "/user/" + res.getUsername();
				redirectView.setUrl(redirectUrl);
				redirectAttrs.addFlashAttribute(GlobalConstants.SUCCESS_MESSAGE, res.getResponseMessage());
				return redirectView;
			}
			model.addAttribute("res", res);
		}
		
		return redirectView;
	}
}
