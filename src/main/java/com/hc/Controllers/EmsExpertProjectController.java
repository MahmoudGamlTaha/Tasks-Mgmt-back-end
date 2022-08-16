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
import com.hc.managers.EmsProjectExpertService;
import com.hc.model.ADM_USER;
import com.hc.model.DashboardTasks;
import com.hc.model.EmsDashboardCounts;
import com.hc.model.EmsExpert;
import com.hc.model.EmsGovernorateCode;
import com.hc.model.EmsProjectExpert;
import com.hc.model.GeneralResponse;
import com.hc.repositories.EmsProjectExpertRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/ProjectExpert")
@RequiredArgsConstructor
public class EmsExpertProjectController {
	private final EmsProjectExpertService emsProjectExpertService;
	
	
	 @PostMapping("/SaveProjectExperts")
		public ResponseEntity<GeneralResponse> SaveProjectExperts(@RequestBody List<Long> allprojExperts ,@RequestParam("ProjectId") Long ProjectId) {
			
		 String IDS="";
		 
		 for(int i=0;i<allprojExperts.size();i++) {
			 if(i<allprojExperts.size()-1)
			 IDS+=allprojExperts.get(i)+",";
			 else
				 IDS+=allprojExperts.get(i);
				 
		 }
		 
		 GeneralResponse res=new GeneralResponse();
			
    	  try{
    		  emsProjectExpertService.SaveProjectExperts(IDS,ProjectId);
    		  res.setStatusCode("0");
 			res.setStatusMessage("Success");
    	  }catch (Exception e) {
    		  e.printStackTrace();
    		 res.setStatusCode("-1");
 			res.setStatusMessage("Failed To Add New Expert");
		}
		 
				return new ResponseEntity<>(res, HttpStatus.OK);			
		}
   
	
	@GetMapping("/getall")
		public ResponseEntity<List<EmsProjectExpert>> getall() {
			
				return new ResponseEntity<>(emsProjectExpertService.findall(), HttpStatus.OK);			
		}
	    @GetMapping("/getProjects")
		public ResponseEntity<List<EmsProjectExpert>> GetProjects(@RequestParam("ExpertId") Long ExpertID) {
			
				return new ResponseEntity<>(emsProjectExpertService.GetExpertProjects(ExpertID), HttpStatus.OK);			
		}
	    @GetMapping("/getAdminProjects")
		public ResponseEntity<List<EmsProjectExpert>> getAdminProjects(@RequestParam("ExpertId") Long ExpertID) {
			
				return new ResponseEntity<>(emsProjectExpertService.GetExpertAllProjects(ExpertID), HttpStatus.OK);			
		}

	    
	    @GetMapping("/GetDashboardCounts")
		public ResponseEntity<List<EmsDashboardCounts>> GetDashboardCounts(@RequestParam("ExpertId") Long ExpertID) {
			
				return new ResponseEntity<>(emsProjectExpertService.GetExpertDashBoard(ExpertID), HttpStatus.OK);			
		}
	    @GetMapping("/GetDashboardLateTasks")
		public ResponseEntity<List<DashboardTasks>> GetDashboardLateTasks(@RequestParam("ExpertId") Long ExpertID) {
			
				return new ResponseEntity<>(emsProjectExpertService.GetExpertLateTasks(ExpertID), HttpStatus.OK);			
		}
	    @GetMapping("/GetDashboardLastTasks")
		public ResponseEntity<List<DashboardTasks>> GetDashboardLastTasks(@RequestParam("ExpertId") Long ExpertID) {
			
				return new ResponseEntity<>(emsProjectExpertService.GetExpertLatestTasks(ExpertID), HttpStatus.OK);			
		}
	    
	    @GetMapping("/getFreeUsers")
		public ResponseEntity<List<ADM_USER>> getFreeUsers() {
			
				return new ResponseEntity<>(emsProjectExpertService.GetAllFreeUsers(), HttpStatus.OK);			
		}
	    
	    
}
