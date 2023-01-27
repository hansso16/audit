package com.soses.audit.service.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.soses.audit.api.BaseSearchRequest;
import com.soses.audit.api.user.UserSearchRequest;
import com.soses.audit.common.GlobalConstants;
import com.soses.audit.common.StringUtil;
import com.soses.audit.entity.User;
import com.soses.audit.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class UserSearchService {

	private static final Logger log = LoggerFactory.getLogger(UserSearchService.class);
	
	private UserRepository userRepo;
	
	public UserSearchService(UserRepository userRepo) {
		super();
		this.userRepo = userRepo;
	}

	public Page<User> searchUser(BaseSearchRequest userReq) {
		log.info("ENTER searchUser(request, userReq)");
		
		UserSearchRequest request = null; 
		String searchText = null;
		Page<User> userPage = null;
		int pageSize = GlobalConstants.DEFAULT_SIZE;
		int currentPage = GlobalConstants.DEFAULT_PAGE;

		if (userReq != null) {
			request = (UserSearchRequest) userReq;
			searchText = request.getSearch();
			
			if (!StringUtil.isEmpty(request.getSize())) {
				pageSize = Integer.parseInt(request.getSize());
			}
			if (!StringUtil.isEmpty(request.getPage())) {
				currentPage = Integer.parseInt(request.getPage()) - 1;
			}
			
			Pageable page = PageRequest.of(currentPage, pageSize);
			if (!StringUtil.isEmpty(searchText)) {
				userPage = userRepo.findByUsernameContains(searchText, page);
			} else {
				userPage = userRepo.findAll(page);
			}
		}
		
		return userPage;
	}

}
