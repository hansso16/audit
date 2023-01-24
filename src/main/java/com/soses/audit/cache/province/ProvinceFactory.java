package com.soses.audit.cache.province;

import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.soses.audit.entity.Province;
import com.soses.audit.repository.ProvinceRepository;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ProvinceFactory {

	private ProvinceRepository repo;
	
	public ProvinceFactory(ProvinceRepository repo) {
		super();
		this.repo = repo;
	}
	
	public List<Province> findAll() {
		return repo.findAll();
	}
}
