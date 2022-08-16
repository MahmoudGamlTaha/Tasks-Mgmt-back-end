package com.hc.managers;

import com.hc.model.EmsCityCode;
import com.hc.repositories.EmsCityCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
* Generated by Spring Data Generator on 02/07/2022
*/
@Component
public class EmsCityCodeService {

	private EmsCityCodeRepository emsCityCodeRepository;

	@Autowired
	public EmsCityCodeService(EmsCityCodeRepository emsCityCodeRepository) {
		this.emsCityCodeRepository = emsCityCodeRepository;
	}

}
