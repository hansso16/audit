package com.soses.audit.service.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.soses.audit.entity.User;
import com.soses.audit.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class UserService {

	private static final Logger log = LoggerFactory.getLogger(UserService.class);
	
	private UserRepository userRepo;

	public UserService(UserRepository userRepo) {
		super();
		this.userRepo = userRepo;
	}
	
	public User retrieveUserDetails(String username) throws Exception {
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
}