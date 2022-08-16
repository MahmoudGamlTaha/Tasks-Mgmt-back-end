package com.hc.managers;

import com.hc.model.PrtsProjectItem;
import com.hc.repositories.PrtsProjectItemRepository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
* Generated by Spring Data Generator on 02/07/2022
*/
@Component
public class PrtsProjectItemService {

	private PrtsProjectItemRepository prtsProjectItemRepository;

	@Autowired
	public PrtsProjectItemService(PrtsProjectItemRepository prtsProjectItemRepository) {
		this.prtsProjectItemRepository = prtsProjectItemRepository;
	}

	public List<PrtsProjectItem> getAllProjectItemOfProject(Long ProjectId){
		return prtsProjectItemRepository.findByprojectId(ProjectId);
	}
	public PrtsProjectItem saveProjectItem(PrtsProjectItem tmp){
		return prtsProjectItemRepository.save(tmp);
	}
	public void deleteProjectItem( Long ProjectItemId){
		 prtsProjectItemRepository.deleteById(ProjectItemId);
	}
	
	public String validateProjectItems(Integer P_PROJECT_ID,Integer P_NEW_TOTAL_AMOUNT,Integer P_NEW_TOTAL_PERCENTAGE){
		return prtsProjectItemRepository.ValidateProjectItems(P_PROJECT_ID, P_NEW_TOTAL_AMOUNT, P_NEW_TOTAL_PERCENTAGE);
	}
	
}