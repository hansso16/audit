package com.soses.audit.service.user;

import java.security.Principal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.soses.audit.api.ChangePasswordRequest;
import com.soses.audit.api.user.BaseUserResponse;
import com.soses.audit.api.user.UpdateAccessRequest;
import com.soses.audit.api.user.UserResponse;
import com.soses.audit.cache.role.RoleAccessor;
import com.soses.audit.cache.role.RoleCacheService;
import com.soses.audit.common.GeneralUtil;
import com.soses.audit.common.StringUtil;
import com.soses.audit.dto.UserTO;
import com.soses.audit.entity.Role;
import com.soses.audit.entity.User;
import com.soses.audit.repository.UserRepository;
import com.soses.audit.util.UserUtil;

import jakarta.transaction.Transactional;

@Service
@Transactional
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class UserService {

	private static final Logger log = LoggerFactory.getLogger(UserService.class);
	
	private UserRepository userRepo;
	
	private RoleCacheService roleService;
	
	private RoleAccessor roleAccessor;

	public UserService(UserRepository userRepo, RoleCacheService roleService
			, RoleAccessor roleAccessor) {
		super();
		this.userRepo = userRepo;
		this.roleService = roleService;
		this.roleAccessor = roleAccessor;
	}
	
	public User retrieveUserDetails(String userCode) throws Exception {
		User user = null;
		
		try {
			user = userRepo.findByUserCode(userCode);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			ex.printStackTrace();
			throw new Exception("retrieveUserDetails(String userCode): Error retrieving User details");
		}
		return user;
	}
	
	public User retrieveUserDetailsByUsername(String username) throws Exception {
		User user = null;
		
		try {
			user = userRepo.findByUsername(username);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			ex.printStackTrace();
			throw new Exception("retrieveUserDetails(String userCode): Error retrieving User details");
		}
		return user;
	}
	
	public List<UserTO> retrieveActiveUsers() throws Exception {
		List<UserTO> userTOList= null;
		try {
			List<User> userList = userRepo.findByTerminationDateIsNull();
			if (!GeneralUtil.isListEmpty(userList)) {
				userTOList = new ArrayList<>();
				for (User user : userList) {
					UserTO userTO = UserUtil.transformUserEntity(user);
					userTOList.add(userTO);
				}
			}
		} catch (Exception ex) {
			log.error(ex.getMessage());
			ex.printStackTrace();
			throw new Exception("retrieveUserDetails(String userCode): Error retrieving Active User details: " + ex.getMessage());
		}
		return userTOList;
	}
	
	public BaseUserResponse getUserDetails(String username, Principal principal) {
		if (StringUtil.isEmpty(username)) {
			log.error("Username is null/empty: " + username);
			return null;
		}
		
		UserResponse response = new UserResponse();

		User user = userRepo.findByUsername(username);
		if (user != null) {
			UserTO userTO = UserUtil.transformUserEntity(user);
			
			List<Role> roleList = roleService.findAll();
			if (!GeneralUtil.isListEmpty(roleList)) {
				response.setRoleList(roleList);
			}
			
			// Get Current User's Role
			String loggedUsername = principal.getName();
			User loggedUser = userRepo.findByUsername(loggedUsername);
			if (loggedUser != null) {
				Role loggedUserRole = loggedUser.getRole();
				response.setUserRole(loggedUserRole);
			}
			
			response.setUser(userTO);
			response.setUsername(username);
		}
		return response;
	}
	
	public boolean terminateUser(LocalDate terminationDate, String username) {
		
		if (terminationDate != null && !StringUtil.isEmpty(username)) {
			userRepo.terminateUser(terminationDate, username);
			return true;
		}
		
		return false;
	}


	public boolean changePassword(ChangePasswordRequest request) {
		// TODO Auto-generated method stub
		
		String password = request.getPassword().trim();
		String passwordConfirmation = request.getPasswordConfirmation().trim();
		String username = request.getUsername();
		if (!StringUtil.isEmpty(passwordConfirmation) && !StringUtil.isEmpty(password)
				&& password.equals(passwordConfirmation)) {
			
			// encode
			String hashPassword = new BCryptPasswordEncoder().encode(password);
			
			userRepo.updatePassword(hashPassword, username);
			return true;
		}
		
		return false;
	}


	public boolean updateAccess(UpdateAccessRequest request) {
		
		String roleId = request.getRole();
		String username = request.getUsername();
		Role role = roleAccessor.getRole(Integer.parseInt(roleId));
		
		if (role != null && !StringUtil.isEmpty(username)) {
			userRepo.updateAcess(role, username);
			return true;
		}
		
		return false;
	}
}
