package com.soses.audit.service;

import java.security.Principal;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.soses.audit.api.ChangePasswordRequest;
import com.soses.audit.api.ChangePasswordResponse;
import com.soses.audit.common.StringUtil;
import com.soses.audit.dto.ErrorPageDTO;
import com.soses.audit.entity.User;
import com.soses.audit.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ChangeMyPasswordService {

	private UserRepository userRepo;
	
	public ChangeMyPasswordService(UserRepository userRepo) {
		super();
		this.userRepo = userRepo;
	}

	public ChangePasswordResponse changePassword(ChangePasswordRequest request, Principal principal) {
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String username = principal.getName();
		String currentPassword = request.getCurrentPassword();
		ChangePasswordResponse response = new ChangePasswordResponse();
		
		if (StringUtil.isEmpty(username)) {
			ErrorPageDTO error = new ErrorPageDTO();
			error.setMessage("Access Denied. Please log out and log back in again.");
			response.setError(error);
			return response;
		}

		User user = userRepo.findByUsername(username);
		if (user == null) {
			ErrorPageDTO error = new ErrorPageDTO();
			error.setMessage("Access Denied. Please log out and log back in again.");
			response.setError(error);
			return response;
		}

		String dbPassword = user.getPassword();
		if (!passwordEncoder.matches(currentPassword, dbPassword)) {
			ErrorPageDTO error = new ErrorPageDTO();
			error.setMessage("Invalid Password.");
			response.setError(error);
			return response;
		}
		String password = request.getPassword();
		String passwordConfirmation = request.getPasswordConfirmation();
		if (!StringUtil.isEmpty(passwordConfirmation) && !StringUtil.isEmpty(password)
				&& !password.equals(passwordConfirmation)) {
			ErrorPageDTO error = new ErrorPageDTO();
			error.setMessage("The password you entered does not match.");
			response.setError(error);
			return response;
		}

		String newPassword = passwordEncoder.encode(password);
		userRepo.updatePassword(newPassword, username);
		response.setResponseMessage("Password updated successfully.");
		
		return response;
	}
}
