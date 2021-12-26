package com.mts.security.administration;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRoleRepo extends JpaRepository<UserRole, Long>{

	@Query(value="SELECT * FROM BPM_ADMINISTRATION.SC_USERROLE WHERE USER_ID = ?1", nativeQuery = true)
	public List<UserRole> getUserRolesById(Long USER_ID);
	
}
