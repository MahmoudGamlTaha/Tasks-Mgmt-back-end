package com.hc.Controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hc.managers.EmsExpertService;
import com.hc.managers.EmsFinancialRequestService;
import com.hc.managers.EmsTaskCommentService;
import com.hc.managers.EmsTaskService;
import com.hc.managers.PrtsProjectService;
import com.hc.model.EmsExpert;
import com.hc.model.GeneralResponse;
import com.hc.model.ProjectExperts;
import com.hc.model.PrtsProject;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/Projects")
@RequiredArgsConstructor
public class PrtsProjectsController {
	private final PrtsProjectService prtsProjectService;
    
	   @GetMapping("/getProject")
		public ResponseEntity<PrtsProject> getProject(@RequestParam("ProjectId") Long ProjectId) {
			
		   PrtsProject e=	prtsProjectService.getProject(ProjectId);
	        
				return new ResponseEntity<>(e, HttpStatus.OK);		
		}
	
	   @GetMapping("/getAllProjectExperts")
		public ResponseEntity<List<ProjectExperts>> getAllProjectExperts(@RequestParam("ProjectId") Long ProjectId) {
			
		   List<ProjectExperts> e=	prtsProjectService.getProjectExperts(ProjectId);
	        
				return new ResponseEntity<>(e, HttpStatus.OK);		
		}
	   
	   @GetMapping("/getAllProjectOnlyExperts")
		public ResponseEntity<List<ProjectExperts>> getAllProjectOnlyExperts(@RequestParam("ProjectId") Long ProjectId) {
			
		   List<ProjectExperts> e=	prtsProjectService.FindProjectExpertsOnly(ProjectId);
	        
				return new ResponseEntity<>(e, HttpStatus.OK);		
		}
	   
	  @PostMapping("/AddProject")
	   	public ResponseEntity<GeneralResponse> AddProject(@RequestBody PrtsProject proj) {
	   	
	    	 GeneralResponse res=new GeneralResponse();
				
	     	  try{
	     		 prtsProjectService.AddNewProject(proj);
	     		 res.setStatusCode("0");
	  			res.setStatusMessage("Success");
	     	  }catch (Exception e) {
	     		  e.printStackTrace();
	     		 res.setStatusCode("-1");
	  			res.setStatusMessage("Failed To Add New Project");
			}
	      	return new ResponseEntity<>(res, HttpStatus.OK);		

	   	}

}
