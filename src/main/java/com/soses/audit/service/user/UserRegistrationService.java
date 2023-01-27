package com.soses.audit.service.user;

import java.security.Principal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.soses.audit.api.user.UserRegistrationRequest;
import com.soses.audit.api.user.UserRegistrationResponse;
import com.soses.audit.cache.role.RoleAccessor;
import com.soses.audit.common.StringUtil;
import com.soses.audit.dto.ErrorPageDTO;
import com.soses.audit.entity.Role;
import com.soses.audit.entity.User;
import com.soses.audit.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Transactional
public class UserRegistrationService {

	private UserRepository userRepo;
	
	private RoleAccessor roleAccessor;
	
	public UserRegistrationService(UserRepository userRepo, RoleAccessor roleAccessor) {
		super();
		this.userRepo = userRepo;
		this.roleAccessor = roleAccessor;
	}


	public UserRegistrationResponse registerUser(UserRegistrationRequest request, Principal principal) {
		if (request == null) {return null; }
		
		UserRegistrationResponse response = new UserRegistrationResponse();
		User user = new User();
		String password = request.getPassword().trim();
		String passwordConfirmation = request.getPasswordConfirmation().trim();
		String username = request.getUsername();
		String strRoleId = request.getRoleId();
		int roleId = Integer.parseInt(strRoleId);
		Role role = roleAccessor.getRole(roleId);
		
		if (!StringUtil.isEmpty(username)) {
			if (userRepo.existsById(username)) {
				ErrorPageDTO error = new ErrorPageDTO();
				error.setMessage("Username already exists.");
				response.setError(error);
				return response;
			}
			if (!StringUtil.isEmpty(passwordConfirmation) && !StringUtil.isEmpty(password)
					&& !password.equals(passwordConfirmation)) {
				ErrorPageDTO error = new ErrorPageDTO();
				error.setMessage("The password you entered does not match.");
				response.setError(error);
				return response;
			}
			if (role == null) {
				ErrorPageDTO error = new ErrorPageDTO();
				error.setMessage("Invalid Access Level");
				response.setError(error);
				return response;
			}
			
			// hash password
			String hashPassword = new BCryptPasswordEncoder().encode(password);
			user.setPassword(hashPassword);
			user.setUsername(username);
			user.setRole(role);
			user.setLastChangedUser(principal.getName());
			user.setLastChangedTimestamp(LocalDateTime.now());
			user.setEntryTimestamp(LocalDateTime.now());
			userRepo.save(user);
			response.setUsername(username);
			response.setResponseMessage("User successfully registered");
		}

		return response;
	}
}
