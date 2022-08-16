package com.hc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.hc.model.ADM_USER;
import com.hc.model.DashboardTasks;
import com.hc.model.InitiativeCode;
import com.hc.model.PrtsLookup;
import com.hc.model.PrtsRoleCode;
import com.hc.model.PrtsSectorCode;
import com.hc.model.SideCode;

public interface PrtsSectorCodeRepository extends JpaRepository<PrtsSectorCode, Long>, JpaSpecificationExecutor<PrtsSectorCode>, QuerydslPredicateExecutor<PrtsSectorCode> {
   
	
	@Query(value="select SECTOR_CODE,INITIATIVE_CODE,INITIATIVE_NAME from PRTS_INITIATIVE_CODE", nativeQuery=true)
    public List<InitiativeCode> GetAllInitiative();
	
	   @Query(value="select lookup_id,LOOKUP_MAIN_NAME from PRTS_LOOKUP_MAIN_CODE where lookup_type=:lookupId", nativeQuery=true)
	    public List<PrtsLookup> getAllLookups(Long  lookupId);
	   
	   @Query(value="select SIDE_CODE,SIDE_NAME from ADM_SIDE_CODE", nativeQuery=true)
	    public List<SideCode> getAllSides();
}
