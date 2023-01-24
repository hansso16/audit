package com.soses.audit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soses.audit.entity.Province;

public interface ProvinceRepository extends JpaRepository<Province, String> {

	Province findByProvinceId(String id);
	
	Province findByProvinceId(int id);
}
