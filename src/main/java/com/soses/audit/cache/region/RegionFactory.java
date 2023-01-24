package com.soses.audit.cache.region;

import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.soses.audit.entity.Region;
import com.soses.audit.repository.RegionRepository;

/**
 * A factory for creating Region objects.
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class RegionFactory {

	/** The repo. */
	private RegionRepository repo;
	
	/**
	 * Instantiates a new region factory.
	 *
	 * @param repo the repo
	 */
	public RegionFactory(RegionRepository repo) {
		super();
		this.repo = repo;
	}
	
	/**
	 * Find all.
	 *
	 * @return the list
	 */
	public List<Region> findAll() {
		return repo.findAll();
	}
}
