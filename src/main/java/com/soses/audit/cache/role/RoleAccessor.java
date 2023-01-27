package com.soses.audit.cache.role;

import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.soses.audit.common.StringUtil;
import com.soses.audit.entity.Role;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class RoleAccessor {

	private RoleCacheService roleCache;

	public RoleAccessor(RoleCacheService roleCache) {
		super();
		this.roleCache = roleCache;
	}
	
	public Role getRole(int roleId) {
		Role dto = null;
		if (roleId > 0) {
			List<Role> list = roleCache.findAll();
			dto = list.stream().filter(param -> roleId == param.getRoleId()) 
					.findFirst().orElse(null);
		}
		return dto;
	}

	public Role getRoleByFullRoleCode(String fullRoleCode) {
		Role dto = null;
		if (!StringUtil.isEmpty(fullRoleCode)) {
			List<Role> list = roleCache.findAll();
			dto = list.stream().filter(param -> fullRoleCode.equals(param.getFullRoleCode())) 
					.findFirst().orElse(null);
		}
		return dto;
	}
}
