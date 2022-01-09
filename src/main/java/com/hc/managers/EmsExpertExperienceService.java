package com.hc.managers;

import com.hc.model.EmsExpertExperience;
import com.hc.repositories.EmsExpertExperienceRepository;
import com.hc.security.administration.UserRepo;
import com.hc.security.administration.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
* Generated by Spring Data Generator on 01/01/2022
*/
@Service
@RequiredArgsConstructor
@Slf4j
public class EmsExpertExperienceService {

	private EmsExpertExperienceRepository emsExpertExperienceRepository;

	@Autowired
	public EmsExpertExperienceService(EmsExpertExperienceRepository emsExpertExperienceRepository) {
		this.emsExpertExperienceRepository = emsExpertExperienceRepository;
	}

}
