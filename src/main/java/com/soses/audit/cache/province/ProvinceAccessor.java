package com.soses.audit.cache.province;

import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.soses.audit.common.StringUtil;
import com.soses.audit.entity.Province;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ProvinceAccessor {

	private ProvinceCacheService provinceCacheService;

	public ProvinceAccessor(ProvinceCacheService provinceCacheService) {
		super();
		this.provinceCacheService = provinceCacheService;
	}
	
	public Province getProvince(String provinceId, String regionId) {
		Province dto = null;
		if (!StringUtil.isEmpty(provinceId) && !StringUtil.isEmpty(regionId)) {
			List<Province> list = provinceCacheService.getProvinceListByRegion(regionId);
			dto = list.stream().filter(param -> (provinceId.equals(param.getProvinceId()))) 
					.findFirst().orElse(null);
		}
		return dto;
	}
}
