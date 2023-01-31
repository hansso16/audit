package com.soses.audit.controller.user;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.soses.audit.api.user.UpdateAccessRequest;
import com.soses.audit.common.GlobalConstants;
import com.soses.audit.service.user.UserService;

@Controller
@RequestMapping("/user")
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class UpdateAccessController {

	private UserService userSerivce;
	
	public UpdateAccessController(UserService userSerivce) {
		super();
		this.userSerivce = userSerivce;
	}
	
	@PostMapping("/{username}/updateaccess")
	public RedirectView terminateUser(@PathVariable String username, Model model, RedirectAttributes redirectAttrs
			, UpdateAccessRequest request) {
		
		String redirectUrl = "/user/" + username;
		RedirectView redirectView = new RedirectView(redirectUrl, true);
		redirectView.setExposeModelAttributes(false);
		
		if (request != null) {
			if (userSerivce.updateAccess(request)) {
				redirectAttrs.addFlashAttribute(GlobalConstants.SUCCESS_MESSAGE, "Access updated successfully.");
			} else {
				redirectAttrs.addFlashAttribute(GlobalConstants.ERROR_MESSAGE, GlobalConstants.GENERIC_ERROR_MESSAGE_DESC);
			}
		}
		
		return redirectView;
	}
}
