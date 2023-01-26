package com.soses.audit.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.soses.audit.entity.Role;
import com.soses.audit.entity.User;

public interface UserRepository extends JpaRepository<User, String> {

	User findByUsername(String username);
	
	User findByUserCode(String userCode);
	
	Page<User> findByUsernameContains(String username, Pageable pageable);
	
	boolean existsById(String username);
	
	List<User> findByTerminationDateIsNull();
	
	@Modifying
	@Query("UPDATE user u SET u.terminationDate = :terminationDate WHERE u.username = :username")
	void terminateUser(@Param("terminationDate") LocalDate terminationDate, @Param("username") String username);

	@Modifying
	@Query("UPDATE user u SET u.password = :password WHERE u.username = :username")
	void updatePassword(@Param("password") String password, @Param("username") String username);
	
	@Modifying
	@Query("UPDATE user u SET u.role = :role WHERE u.username = :username")
	void updateAcess(@Param("role") Role role, @Param("username") String username);		
}
