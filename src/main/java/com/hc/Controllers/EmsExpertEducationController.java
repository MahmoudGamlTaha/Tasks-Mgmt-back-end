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

import com.hc.managers.EmsExpertEducationService;
import com.hc.managers.EmsExpertExperienceService;
import com.hc.model.EmsExpertEducation;
import com.hc.model.EmsExpertEducationPK;
import com.hc.model.EmsExpertExperience;
import com.hc.model.EmsExpertExperiencePK;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/Education")
@RequiredArgsConstructor
public class EmsExpertEducationController {
	
	private final EmsExpertEducationService emsexpertEducationService;

	 @GetMapping("/getById")
		public ResponseEntity<EmsExpertEducation> getall(@RequestParam("ExpertId") Long ExpertID,@RequestParam("EduId") Long EduId) {
			
		    EmsExpertEducationPK tmp=new EmsExpertEducationPK();
		    tmp.setEducationId(EduId);
		    tmp.setExpertId(ExpertID);
				return new ResponseEntity<>(emsexpertEducationService.getEducation(tmp), HttpStatus.OK);		
		}
	 @GetMapping("/getByExpert")
		public ResponseEntity<List<EmsExpertEducation>> getallByExpert(@RequestParam("ExpertId") Long ExpertID) {
			
		   
				return new ResponseEntity<>(emsexpertEducationService.getEducationbyExpert(ExpertID), HttpStatus.OK);		
		}
	 
	 @PostMapping("/Save")
		public ResponseEntity<EmsExpertEducation> add(
				@RequestBody EmsExpertEducation sample) {
			
		    

		    return new ResponseEntity<>(emsexpertEducationService.addNewEducation(sample), HttpStatus.OK);		
		}
	 @PostMapping("/delete")
		public ResponseEntity<EmsExpertEducationPK> delete(
				@RequestBody EmsExpertEducationPK sample) {
			
		    

		    return new ResponseEntity<>(emsexpertEducationService.DeleteEducation(sample), HttpStatus.OK);		
		}

}
