package com.soses.audit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soses.audit.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
