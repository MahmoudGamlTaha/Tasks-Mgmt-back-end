package com.hc.managers;

import com.hc.model.PrtsProjectEngineeringStudy;
import com.hc.repositories.PrtsProjectEngineeringStudyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
* Generated by Spring Data Generator on 25/01/2022
*/
@Component
public class PrtsProjectEngineeringStudyService {

	private PrtsProjectEngineeringStudyRepository prtsProjectEngineeringStudyRepository;

	@Autowired
	public PrtsProjectEngineeringStudyService(PrtsProjectEngineeringStudyRepository prtsProjectEngineeringStudyRepository) {
		this.prtsProjectEngineeringStudyRepository = prtsProjectEngineeringStudyRepository;
	}

}
