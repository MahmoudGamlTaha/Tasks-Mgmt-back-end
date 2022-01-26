package com.hc.repositories;

import com.hc.model.PrtsProjectDocument;
import com.hc.model.PrtsProjectDocumentPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

/**
* Generated by Spring Data Generator on 25/01/2022
*/
@Repository
public interface PrtsProjectDocumentRepository extends JpaRepository<PrtsProjectDocument, PrtsProjectDocumentPK>, JpaSpecificationExecutor<PrtsProjectDocument>, QuerydslPredicateExecutor<PrtsProjectDocument> {

}
