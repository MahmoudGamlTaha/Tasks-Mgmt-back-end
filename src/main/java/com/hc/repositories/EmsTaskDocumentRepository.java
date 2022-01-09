package com.hc.repositories;

import com.hc.model.EmsTaskDocument;
import com.hc.model.EmsTaskDocumentPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

/**
* Generated by Spring Data Generator on 01/01/2022
*/
@Repository
public interface EmsTaskDocumentRepository extends JpaRepository<EmsTaskDocument, EmsTaskDocumentPK>, JpaSpecificationExecutor<EmsTaskDocument>, QuerydslPredicateExecutor<EmsTaskDocument> {

}
