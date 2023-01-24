package com.soses.audit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soses.audit.entity.Municipal;

public interface MunicipalRepository extends JpaRepository<Municipal, String> {

	Municipal findByMunicipalId(String id);
	
	Municipal findByMunicipalId(int id);
}
