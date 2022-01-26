package com.hc.managers;

import com.hc.model.PrtsProjectDescription;
import com.hc.repositories.PrtsProjectDescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
* Generated by Spring Data Generator on 25/01/2022
*/
@Component
public class PrtsProjectDescriptionService {

	private PrtsProjectDescriptionRepository prtsProjectDescriptionRepository;

	@Autowired
	public PrtsProjectDescriptionService(PrtsProjectDescriptionRepository prtsProjectDescriptionRepository) {
		this.prtsProjectDescriptionRepository = prtsProjectDescriptionRepository;
	}

}