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

import com.hc.managers.EmsExpertCertificateService;
import com.hc.managers.EmsExpertEducationService;
import com.hc.model.EmsExpertCertificate;
import com.hc.model.EmsExpertCertificatePK;
import com.hc.model.EmsExpertEducation;
import com.hc.model.EmsExpertEducationPK;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/Certificate")
@RequiredArgsConstructor
public class EmsExpertCertificationController {
	private final EmsExpertCertificateService emsexpertCertificateService;

	 @GetMapping("/getById")
		public ResponseEntity<EmsExpertCertificate> getall(@RequestParam("ExpertId") Long ExpertID,@RequestParam("CertId") Long CertId) {

		 EmsExpertCertificatePK tmp=new EmsExpertCertificatePK();
		    tmp.setCertificateId(CertId);
		    tmp.setExpertId(ExpertID);
				return new ResponseEntity<>(emsexpertCertificateService.getCertificate(tmp), HttpStatus.OK);		
		}
	 @GetMapping("/getByExpert")
		public ResponseEntity<List<EmsExpertCertificate>> getallByExpert(@RequestParam("ExpertId") Long ExpertID) {
			
		   
				return new ResponseEntity<>(emsexpertCertificateService.getExperiencebyExpert(ExpertID), HttpStatus.OK);		
		}
	 @PostMapping("/Save")
		public ResponseEntity<EmsExpertCertificate> add(
				@RequestBody EmsExpertCertificate sample) {
			
		    

		    return new ResponseEntity<>(emsexpertCertificateService.addNewCertificate(sample), HttpStatus.OK);		
		}
	 @PostMapping("/delete")
		public ResponseEntity<EmsExpertCertificatePK> delete(
				@RequestBody EmsExpertCertificatePK sample) {
			
		    

		    return new ResponseEntity<>(emsexpertCertificateService.deleteCertificate(sample), HttpStatus.OK);		
		}

}
