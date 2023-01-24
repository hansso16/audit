package com.soses.audit.cache.region;

import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.soses.audit.entity.Region;

import jakarta.transaction.Transactional;

@Service
@Transactional
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class RegionCacheService {

	private RegionFactory regionFactory;

	public RegionCacheService(RegionFactory regionFactory) {
		super();
		this.regionFactory = regionFactory;
	}

	@Cacheable(value="regionCache")
	public List<Region> findAll() {
		return regionFactory.findAll();
	}
}
