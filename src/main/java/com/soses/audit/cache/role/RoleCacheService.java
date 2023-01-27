package com.soses.audit.cache.role;

import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.soses.audit.entity.Role;

import jakarta.transaction.Transactional;

@Service
@Transactional
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class RoleCacheService {

	private RoleFactory roleFactory;

	public RoleCacheService(RoleFactory roleFactory) {
		super();
		this.roleFactory = roleFactory;
	}

	@Cacheable(value="roleCache")
	public List<Role> findAll() {
		return roleFactory.findAll();
	}
}
