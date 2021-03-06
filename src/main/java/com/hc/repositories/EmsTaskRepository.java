package com.hc.repositories;

import com.hc.model.EmsTask;
import com.hc.model.EmsTaskPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

/**
* Generated by Spring Data Generator on 01/01/2022
*/
@Repository
public interface EmsTaskRepository extends JpaRepository<EmsTask, EmsTaskPK>, JpaSpecificationExecutor<EmsTask>, QuerydslPredicateExecutor<EmsTask> {

}
