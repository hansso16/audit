package com.soses.audit.service.user;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.soses.audit.common.GeneralUtil;
import com.soses.audit.dto.UserTO;
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

	public UserService(UserRepository userRepo) {
		super();
		this.userRepo = userRepo;
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
}
