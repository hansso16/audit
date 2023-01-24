package com.soses.audit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soses.audit.entity.Region;

public interface RegionRepository extends JpaRepository<Region, String>{

	Region findByRegionId(String id);
	
	Region findByRegionId(int id);
}
