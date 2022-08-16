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

import com.hc.managers.EmsExpertExperienceService;
import com.hc.managers.EmsExpertService;
import com.hc.model.EmsExpert;
import com.hc.model.EmsExpertExperience;
import com.hc.model.EmsExpertExperiencePK;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/Experience")
@RequiredArgsConstructor
public class EmsExpertExperienceController {
	private final EmsExpertExperienceService emsexpertexperienceservice;

	 @GetMapping("/getById")
		public ResponseEntity<EmsExpertExperience> getall(@RequestParam("ExpertId") Long ExpertID,@RequestParam("ExpId") Long ExpId) {
			
		    EmsExpertExperiencePK tmp=new EmsExpertExperiencePK();
		    tmp.setExperienceId(ExpId);
		    tmp.setExpertId(ExpertID);
				return new ResponseEntity<>(emsexpertexperienceservice.getExperience(tmp), HttpStatus.OK);		
		}
	 @GetMapping("/getByExpert")
		public ResponseEntity<List<EmsExpertExperience>> getallByExpert(@RequestParam("ExpertId") Long ExpertID) {
			
		   
				return new ResponseEntity<>(emsexpertexperienceservice.getExperiencebyExpert(ExpertID), HttpStatus.OK);		
		}
	 
	 @PostMapping("/Save")
		public ResponseEntity<EmsExpertExperience> add(
				@RequestBody EmsExpertExperience sample) {
			
		    

		    return new ResponseEntity<>(emsexpertexperienceservice.addNewExperience(sample), HttpStatus.OK);		
		}
	 @PostMapping("/delete")
		public ResponseEntity<EmsExpertExperiencePK> delete(
				@RequestBody EmsExpertExperiencePK sample) {
			
		    

		    return new ResponseEntity<>(emsexpertexperienceservice.DeleteExperience(sample), HttpStatus.OK);		
		}
	 
}


