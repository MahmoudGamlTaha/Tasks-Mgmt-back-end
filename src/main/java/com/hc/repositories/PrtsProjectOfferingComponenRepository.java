package com.hc.repositories;

import com.hc.model.PrtsProjectOfferingComponen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

/**
* Generated by Spring Data Generator on 25/01/2022
*/
@Repository
public interface PrtsProjectOfferingComponenRepository extends JpaRepository<PrtsProjectOfferingComponen, Long>, JpaSpecificationExecutor<PrtsProjectOfferingComponen>, QuerydslPredicateExecutor<PrtsProjectOfferingComponen> {

}
