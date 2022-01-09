package com.hc.security.administration;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserPermissionRepo extends JpaRepository<UserPermission, UserPermissionId>{

	@Query(value="SELECT * FROM ADM_USER_PERMISSIONS WHERE USER_ID = ?1 AND MODULE_ID = ?2", nativeQuery = true)
	public List<UserPermission> getUserPermissionsById(Long USER_ID, Long MODULE_ID);
	
}
