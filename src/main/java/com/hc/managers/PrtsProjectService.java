package com.hc.managers;

import com.hc.model.FilterProject;
import com.hc.model.KpisMonitor;
import com.hc.model.KpisResults;
import com.hc.model.ProjectDashBoard;
import com.hc.model.ProjectResults;
import com.hc.model.PrtsProject;
import com.hc.repositories.PrtsProjectRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.Tuple;
import javax.persistence.TupleElement;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
* Generated by Spring Data Generator on 02/07/2022
*/
@Component
public class PrtsProjectService {

	private PrtsProjectRepository prtsProjectRepository;

	@Autowired
	private EntityManagerFactory em;
	
	@Autowired
	public PrtsProjectService(PrtsProjectRepository prtsProjectRepository) {
		this.prtsProjectRepository = prtsProjectRepository;
	}

	public List<PrtsProject> getall() {
		// TODO Auto-generated method stub
		return prtsProjectRepository.findAll();
	}

	public PrtsProject getProjectById(Long projectId) {
		// TODO Auto-generated method stub
		return prtsProjectRepository.getById(projectId);
	}
	
	public void deleteProjectById(Long projectId) {
		// TODO Auto-generated method stub
		 prtsProjectRepository.deleteById(projectId);
	}
	
	public List<ProjectResults> FilterProjects(FilterProject params) {
		// TODO Auto-generated method stub
		
		return prtsProjectRepository.GeneralProjectFilter(params.getDeptId(), params.getRegId(),
				params.getInitiativeId(), params.getWorkAreaId(), params.getContractStatusId(),
				params.getExecutionStatusId(), params.getProjectStatusId());
	}
	
	public  List<Map<String/*UPPERCASE*/, Object>> jpaTuplesToMaps(
			  List<javax.persistence.Tuple> data
			){
			    return data.stream()
			        .map(tuple -> { // per each tuple of the input List
			            // creating a new HashMap
			            Map<String, Object> resultItem =  new HashMap<>();
			            // filling the created HashMap with values of
			            tuple.getElements().forEach( // each column of the tuple
			                col -> { resultItem.put(col.getAlias(), tuple.get(col)); } 
			            );
			            // returning the created HashMap instead of  the current Tuple
			            return resultItem;
			        })
			         // collecting & returning all the created HashMap-s as a List
			        .collect(Collectors.toList());
			}

	
	public  List<Map<String/*UPPERCASE*/, Object>> calculateKpis(KpisMonitor criteria) {
		// TODO Auto-generated method stub

	       StringBuilder select = new StringBuilder();
	       StringBuilder groupby = new StringBuilder();
	       StringBuilder whereCond=new StringBuilder();

	        // SELECT
	       select.append("SELECT " + System.lineSeparator());
	        if(criteria.getFirstSide()!=null&&!criteria.getFirstSide().isEmpty()) {
	        	select.append(criteria.getFirstSide()+" as FirstSide");
	        	select.append(",(select LOOKUP_MAIN_NAME from prts_lookup_main_code where lookup_id="+criteria.getFirstSide()+") as FIRSTSIDENAME");
	        	groupby.append("group by "+criteria.getFirstSide());
	        	whereCond.append("where "+criteria.getFirstSide()+" in (:F)");
	        }
	        if(criteria.getSecondSide()!=null&&!criteria.getSecondSide().isEmpty()) {
	        	select.append(","+criteria.getSecondSide()+" as SecondSide");
	        	select.append(",(select LOOKUP_MAIN_NAME from prts_lookup_main_code where lookup_id="+criteria.getSecondSide()+") as SECONDSIDENAME");

	        	groupby.append(","+criteria.getSecondSide());
	        	whereCond.append("and " +criteria.getSecondSide()+" in (:S)");
	        }
	        select.append(",sum(total_amount) as AmountSum,count(*) as ProjectCount  from prts_project");
	         
	        System.out.println(select);
	        System.out.println(whereCond);
	        System.out.println(groupby);

	        System.out.println(select +" "+System.lineSeparator()+whereCond+" "+System.lineSeparator()+groupby);		
		EntityManager entityManager = em.createEntityManager();
		Query query = entityManager.createNativeQuery(select +" "+System.lineSeparator()+whereCond+" "+System.lineSeparator()+groupby, Tuple.class);
		query.setParameter("F", criteria.getFirstSideValues());
        if(criteria.getSecondSide()!=null&&!criteria.getSecondSide().isEmpty()) {
    		query.setParameter("S", criteria.getSecondSideValues());
        }
		List<Tuple> queryResults = query.getResultList();
		entityManager.close();
	
	
		
		return jpaTuplesToMaps(queryResults);
	}

	
	public List<ProjectDashBoard> getProjectDashboard(Integer ProjectID,Integer PMonth, Integer PYear ) {
		// TODO Auto-generated method stub
		
		return prtsProjectRepository.getAllProjectDashboard(ProjectID, PMonth, PYear);
	}
	
	public PrtsProject saveProject(PrtsProject proj) {
		// TODO Auto-generated method stub
		return prtsProjectRepository.save(proj);
	}

}
