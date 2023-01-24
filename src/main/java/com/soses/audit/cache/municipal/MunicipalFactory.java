package com.soses.audit.cache.municipal;

import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.soses.audit.entity.Municipal;
import com.soses.audit.repository.MunicipalRepository;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class MunicipalFactory {

	private MunicipalRepository repo;
	
	public MunicipalFactory(MunicipalRepository repo) {
		super();
		this.repo = repo;
	}
	
	public List<Municipal> findAll() {
		return repo.findAll();
	}
}
