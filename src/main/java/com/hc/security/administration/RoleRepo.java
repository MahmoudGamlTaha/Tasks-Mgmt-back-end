package com.hc.security.administration;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hc.model.PrtsUserRole;

@Repository

public interface RoleRepo extends JpaRepository<PrtsUserRole, Long>{
	
	Optional<PrtsUserRole> findById(Long id);
	
}
