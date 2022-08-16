package com.hc.security.administration;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
	
	@Query(value = "SELECT adm_user.*,"
			+ "        round(months_between(TRUNC(sysdate),\r\n"
			+ "        adm_user.birth_date                       )/12,\r\n"
			+ "        0)   as EXPERT_AGE   FROM adm_user where USER_NAME = ?1", nativeQuery = true)
	User findByUsername(String username);
	
	/*@Query(value = "SELECT VALUE FROM BPM_ADMINISTRATION.SC_USER_SCOPE WHERE USER_NAME = ?1 AND CODE = ?2", nativeQuery = true)
	List<String> getScopes(String username, String Code);
*/
	/*@Transactional
	@Modifying
	@Query(value="UPDATE BPM_ADMINISTRATION.SC_USERS SET ACTIVE = 0 WHERE USER_NAME = ?1", nativeQuery = true)
	Integer deactivateUser(String username);*/
}