package com.hc.repositories;

import com.hc.model.PrtsProjectManager;
import com.hc.model.PrtsProjectManagerPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

/**
* Generated by Spring Data Generator on 02/07/2022
*/
@Repository
public interface PrtsProjectManagerRepository extends JpaRepository<PrtsProjectManager, PrtsProjectManagerPK>, JpaSpecificationExecutor<PrtsProjectManager>, QuerydslPredicateExecutor<PrtsProjectManager> {

}
