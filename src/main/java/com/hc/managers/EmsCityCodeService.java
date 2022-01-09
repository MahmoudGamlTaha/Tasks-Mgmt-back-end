package com.hc.managers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.model.EmsCityCode;
import com.hc.model.EmsCountryCode;
import com.hc.repositories.EmsCityCodeRepository;
import com.hc.repositories.EmsCountryCodeRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmsCityCodeService {
	@Autowired
	private EmsCityCodeRepository emsCityCodeRepository;

	

	public List<EmsCityCode> getall(){
		   return emsCityCodeRepository.findAll();
	   }
}
