package com.soses.audit.cache.municipal;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.soses.audit.common.StringUtil;
import com.soses.audit.entity.Municipal;

import jakarta.transaction.Transactional;

@Service
@Transactional
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class MunicipalCacheService {

	private MunicipalFactory municipalityFactory;

	public MunicipalCacheService(MunicipalFactory municipalityFactory) {
		super();
		this.municipalityFactory = municipalityFactory;
	}

	@Cacheable(value="municipalCache")
	public List<Municipal> findAll() {
		return municipalityFactory.findAll();
	}
	
	@Cacheable(value="municipalCacheByProvince", key="#provinceId")
	public List<Municipal> getMunicipalListByProvince(String provinceId) {
		List<Municipal> provinceList = null;
		if (!StringUtil.isEmpty(provinceId)) {
			List<Municipal> list = findAll();
			provinceList = list.stream()
					.filter(param -> provinceId.equals(param.getProvinceId()))
					.collect(Collectors.toList());
		}
		return provinceList;
	}
}
