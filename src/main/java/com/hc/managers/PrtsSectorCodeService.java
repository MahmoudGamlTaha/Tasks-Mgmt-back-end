package com.hc.managers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hc.model.InitiativeCode;
import com.hc.model.PrtsLookup;
import com.hc.model.PrtsSectorCode;
import com.hc.model.SideCode;
import com.hc.repositories.PrtsRoleCodeRepository;
import com.hc.repositories.PrtsSectorCodeRepository;

@Component
public class PrtsSectorCodeService {
	private PrtsSectorCodeRepository PrtsSectorCodeRepository;

	@Autowired
	public PrtsSectorCodeService(PrtsSectorCodeRepository PrtsSectorCodeRepository) {
		this.PrtsSectorCodeRepository = PrtsSectorCodeRepository;
	}
	
	public List<PrtsSectorCode> getall(){
		return this.PrtsSectorCodeRepository.findAll();
	}
	
	public List<InitiativeCode> getallInitiative(){
		return this.PrtsSectorCodeRepository.GetAllInitiative();
	}
	public List<PrtsLookup> getalLookupObject(long lookupId){
		return this.PrtsSectorCodeRepository.getAllLookups(lookupId);
	}
	public List<SideCode> getAllSides(){
		return this.PrtsSectorCodeRepository.getAllSides();
	}
	
	
}
