package com.soses.audit.controller.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.soses.audit.api.ChangePasswordRequest;
import com.soses.audit.common.GlobalConstants;
import com.soses.audit.service.user.UserService;

@Controller
@RequestMapping("/user")
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class ChangeUserPasswordController {

	private static final Logger log = LoggerFactory.getLogger(ChangeUserPasswordController.class);
	
	private UserService userSerivce;
	
	public ChangeUserPasswordController(UserService userSerivce) {
		super();
		this.userSerivce = userSerivce;
	}
	
	@PostMapping("/{username}/changepassword")
	public RedirectView terminateUser(@PathVariable String username, Model model, RedirectAttributes redirectAttrs
			, ChangePasswordRequest request) {
		log.info("viewUser(username,model)");
		
		String redirectUrl = "/user/" + username;
		RedirectView redirectView = new RedirectView(redirectUrl, true);
		redirectView.setExposeModelAttributes(false);
		
		if (request != null) {
			if (userSerivce.changePassword(request)) {
				redirectAttrs.addFlashAttribute(GlobalConstants.SUCCESS_MESSAGE, "Password updated successfully.");
			} else {
				redirectAttrs.addFlashAttribute(GlobalConstants.ERROR_MESSAGE, GlobalConstants.GENERIC_ERROR_MESSAGE_DESC);
			}
		}
		
		return redirectView;
	}
}
