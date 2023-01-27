package com.soses.audit.cache.role;

import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.soses.audit.entity.Role;
import com.soses.audit.repository.RoleRepository;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class RoleFactory {

	private RoleRepository repo;
	
	public RoleFactory(RoleRepository repo) {
		super();
		this.repo = repo;
	}
	
	public List<Role> findAll() {
		return repo.findAll();
	}
}
