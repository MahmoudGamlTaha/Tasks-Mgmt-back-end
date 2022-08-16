package com.hc.Controllers;

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

import com.hc.managers.PrtsLookupMainCodeService;
import com.hc.managers.PrtsLookupTypeService;
import com.hc.managers.PrtsProjectService;
import com.hc.model.DynamicResponse;
import com.hc.model.PrtsLookupMainCode;
import com.hc.model.PrtsLookupType;
import com.hc.model.PrtsProject;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/lookups")
@RequiredArgsConstructor
public class LookupController {
	@Autowired
	  private final  PrtsLookupMainCodeService prtslookupservice;
	  @GetMapping("/getallobjectsByDepend")
		public ResponseEntity<List<PrtsLookupMainCode>> getallobjectsByDepend(@RequestParam Long LookupType,@RequestParam Long lookupDependCode) {
						
				return new ResponseEntity<>(prtslookupservice.getallDepend(LookupType,lookupDependCode), HttpStatus.OK);	
			
		}
	  @GetMapping("/getallobjects")
		public ResponseEntity<List<PrtsLookupMainCode>> getallObjects(@RequestParam Long LookupType) {
						
				return new ResponseEntity<>(prtslookupservice.getall(LookupType), HttpStatus.OK);	
			
		}
	  
	  @PostMapping("/saveLookup")
	 	public ResponseEntity<DynamicResponse<PrtsLookupMainCode>> CreateNewProject(@RequestBody PrtsLookupMainCode params) {
	 					
		  DynamicResponse<PrtsLookupMainCode> res=new DynamicResponse<PrtsLookupMainCode>();

		  try {
			  PrtsLookupMainCode Saved= prtslookupservice.SaveLookup(params);
				res.setData(Saved);
				res.setStatusCode("0");
				res.setMessage("Success");
				return new ResponseEntity<>(res, HttpStatus.OK);	
		 }catch(Exception e) {
			   if (e.getMessage().contains("MPSLMC_PK")) {
				   res.setStatusCode("-2");
					res.setMessage("Lookup id  Must Be Unique");
			   }
			   else {
				   res.setStatusCode("-1");
					res.setMessage("Unexpected Error Please Contact Your Administrator");
					
			   }
				return new ResponseEntity<>(res, HttpStatus.OK);	
		 } 		
	 	}

	  @GetMapping("/deleteLookup")
		public ResponseEntity<DynamicResponse<Object>> deleteLookup(@RequestParam Long LookupId) {
		 DynamicResponse<Object> res=new DynamicResponse<Object>();
		  try {
			  prtslookupservice.deleteLookup(LookupId);
				res.setStatusCode("0");
				res.setMessage("Success");
				return new ResponseEntity<>(res, HttpStatus.OK);	
				
		  } catch(Exception e) {
			  res.setStatusCode("-1");
				res.setMessage("Unexpected Error Please Contact Your Administrator");
				return new ResponseEntity<>(res, HttpStatus.OK);	
		  }
		}

}
