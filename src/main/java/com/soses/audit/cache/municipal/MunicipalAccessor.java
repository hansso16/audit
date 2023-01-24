package com.soses.audit.cache.municipal;

import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.soses.audit.common.StringUtil;
import com.soses.audit.entity.Municipal;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class MunicipalAccessor {

	private MunicipalCacheService municipalityCacheService;

	public MunicipalAccessor(MunicipalCacheService municipalityCacheService) {
		super();
		this.municipalityCacheService = municipalityCacheService;
	}
	
	public Municipal getMunicipal(String municipalId, String provinceId) {
		Municipal dto = null;
		if (!StringUtil.isEmpty(municipalId) && !StringUtil.isEmpty(provinceId)) {
			List<Municipal> list = municipalityCacheService.getMunicipalListByProvince(provinceId);
			dto = list.stream().filter(param -> (municipalId.equals(param.getMunicipalId()))) 
					.findFirst().orElse(null);
		}
		return dto;
	}
}
