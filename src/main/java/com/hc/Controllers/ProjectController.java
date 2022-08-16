package com.hc.Controllers;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hc.managers.PrtsProjectService;
import com.hc.model.DynamicResponse;
import com.hc.model.FilterProject;
import com.hc.model.ProjectDashBoard;
import com.hc.model.ProjectResults;
import com.hc.model.PrtsProject;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/projects")
@RequiredArgsConstructor
public class ProjectController {
	@Autowired
  private final  PrtsProjectService prtsprojectservice;
  @GetMapping("/getall")
	public ResponseEntity<List<PrtsProject>> getall() {
					
			return new ResponseEntity<>(prtsprojectservice.getall(), HttpStatus.OK);	
		
	}
  @GetMapping("/getdetails")
	public ResponseEntity<PrtsProject> getDetails(@RequestParam Long ProjectId) {
					
			return new ResponseEntity<>(prtsprojectservice.getProjectById(ProjectId), HttpStatus.OK);	
		
	}
  
  @PostMapping("/SearchForProjects")
	public ResponseEntity<List<ProjectResults>> SearchForProjects(@RequestBody FilterProject params) {
					
			return new ResponseEntity<>(prtsprojectservice.FilterProjects(params), HttpStatus.OK);	
		
	}
  
  @PostMapping("/AddProject")
 	public ResponseEntity<DynamicResponse<PrtsProject>> CreateNewProject(@RequestBody PrtsProject params) {
 					
	  DynamicResponse<PrtsProject> res=new DynamicResponse<PrtsProject>();

	  try {
	 PrtsProject Saved= prtsprojectservice.saveProject(params);
			res.setData(Saved);
			res.setStatusCode("0");
			res.setMessage("Success");
			return new ResponseEntity<>(res, HttpStatus.OK);	
	 }catch(Exception e) {
		   if (e.getMessage().contains("PRTS_PROJECT_INDEX1")) {
			   res.setStatusCode("-2");
				res.setMessage("Project Code Must Be Unique");
		   }
		   else {
			   res.setStatusCode("-1");
				res.setMessage("Unexpected Error Please Contact Your Administrator");
				
		   }
			return new ResponseEntity<>(res, HttpStatus.OK);	
	 } 		
 	}
  
  @PostMapping("/SaveMainInfo")
	public ResponseEntity<DynamicResponse<PrtsProject>> UpdateProject(@RequestParam Long ProjectId, @RequestBody PrtsProject params) {
	  DynamicResponse<PrtsProject> res=new DynamicResponse<PrtsProject>();

	  try {
	 PrtsProject Saved= prtsprojectservice.saveProject(params);
			res.setData(Saved);
			res.setStatusCode("0");
			res.setMessage("Success");
			return new ResponseEntity<>(res, HttpStatus.OK);	
	 }catch(Exception e) {
		   if (e.getMessage().contains("PRTS_PROJECT_INDEX1")) {
			   res.setStatusCode("-2");
				res.setMessage("Project Code Must Be Unique");
		   }
		   else {
			   res.setStatusCode("-1");
				res.setMessage("Unexpected Error Please Contact Your Administrator");
				
		   }
			return new ResponseEntity<>(res, HttpStatus.OK);	
	 }
	  
	}
  
  @GetMapping("/deletProject")
	public ResponseEntity<DynamicResponse<Object>> deletProjectItem(@RequestParam Long ProjectId) {
	 DynamicResponse<Object> res=new DynamicResponse<Object>();
	  try {
			prtsprojectservice.deleteProjectById(ProjectId);
			res.setStatusCode("0");
			res.setMessage("Success");
			return new ResponseEntity<>(res, HttpStatus.OK);	
			
	  } catch(Exception e) {
		  res.setStatusCode("-1");
			res.setMessage("Unexpected Error Please Contact Your Administrator");
			return new ResponseEntity<>(res, HttpStatus.OK);	
	  }
	}
  @GetMapping("/getProjectDashboard")
 	public ResponseEntity<List<ProjectDashBoard>> getProjectDashboard(@RequestParam Integer ProjectId,@RequestParam Integer Month,@RequestParam Integer Year ) {
 					
 			return new ResponseEntity<>(prtsprojectservice.getProjectDashboard(ProjectId, Month, Year), HttpStatus.OK);	
 		
 	}
  
  
}
