package com.soses.audit.cache.province;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.soses.audit.common.StringUtil;
import com.soses.audit.entity.Province;

import jakarta.transaction.Transactional;

@Service
@Transactional
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ProvinceCacheService {

	private ProvinceFactory provinceFactory;

	public ProvinceCacheService(ProvinceFactory provinceFactory) {
		super();
		this.provinceFactory = provinceFactory;
	}

	@Cacheable(value="provinceCache")
	public List<Province> findAll() {
		return provinceFactory.findAll();
	}
	
	@Cacheable(value="provinceCacheByRegion", key="#regionId")
	public List<Province> getProvinceListByRegion(String regionId) {
		List<Province> provinceList = null;
		if (!StringUtil.isEmpty(regionId)) {
			List<Province> list = findAll();
			provinceList = list.stream()
					.filter(param -> regionId.equals(param.getRegionId()))
					.collect(Collectors.toList());
		}
		return provinceList;
	}
}
