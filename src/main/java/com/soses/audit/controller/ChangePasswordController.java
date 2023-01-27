package com.soses.audit.controller;

import java.security.Principal;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;

import com.soses.audit.api.ChangePasswordRequest;
import com.soses.audit.api.ChangePasswordResponse;
import com.soses.audit.common.GlobalConstants;
import com.soses.audit.common.StringUtil;
import com.soses.audit.service.ChangeMyPasswordService;

@Controller
@RequestMapping("/changepassword")
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class ChangePasswordController {

	private static final String CHANGE_PWD = "user/change_password";
	
	private ChangeMyPasswordService changeMyPasswordService;
	
	public ChangePasswordController(ChangeMyPasswordService changeMyPasswordService) {
		super();
		this.changeMyPasswordService = changeMyPasswordService;
	}

	@GetMapping("")
	public String changePassword() {
		return CHANGE_PWD;
	}
	
	@PostMapping("")
	public String changePassword(ChangePasswordRequest request, Principal principal, Model model) {
		
		ChangePasswordResponse response = changeMyPasswordService.changePassword(request, principal);
		if (response != null) {
			if (response.getError() != null) {
				model.addAttribute(GlobalConstants.ERROR_MESSAGE, response.getError().getMessage());
			} else if (!StringUtil.isEmpty(response.getResponseMessage())) {
				model.addAttribute(GlobalConstants.SUCCESS_MESSAGE, response.getResponseMessage());
			}
		}
		return CHANGE_PWD;
	}
}
