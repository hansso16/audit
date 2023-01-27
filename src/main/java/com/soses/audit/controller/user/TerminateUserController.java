package com.soses.audit.controller.user;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.format.annotation.DateTimeFormat;
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
import com.soses.audit.service.user.UserService;

@Controller
@RequestMapping("/user")
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class TerminateUserController {

	private static final Logger log = LoggerFactory.getLogger(TerminateUserController.class);
	
	private UserService userSerivce;
	
	public TerminateUserController(UserService userSerivce) {
		super();
		this.userSerivce = userSerivce;
	}
	
	@PostMapping("/{username}/terminate")
	public RedirectView terminateUser(@PathVariable String username, Model model, RedirectAttributes redirectAttrs
			, @RequestParam(name="terminationDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate terminationDate) {
		log.info("viewUser(username,model)");
		
		String redirectUrl = "/user/" + username;
		RedirectView redirectView = new RedirectView(redirectUrl, true);
		redirectView.setExposeModelAttributes(false);
		
		// service to update Termination Date
		if (userSerivce.terminateUser(terminationDate, username)) {
			redirectAttrs.addFlashAttribute(GlobalConstants.SUCCESS_MESSAGE, "User Access terminated successfully.");
		} else {
			redirectAttrs.addFlashAttribute(GlobalConstants.ERROR_MESSAGE, GlobalConstants.GENERIC_ERROR_MESSAGE_DESC);
		}
		
		return redirectView;
	}
}
