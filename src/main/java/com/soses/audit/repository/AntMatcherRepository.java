package com.soses.audit.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soses.audit.entity.AntMatcher;

public interface AntMatcherRepository extends JpaRepository<AntMatcher, Integer>{

	List<AntMatcher> findAllByEndDateGreaterThanAndEffDateLessThanEqual(LocalDate date1, LocalDate date2);
}
