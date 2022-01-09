package com.hc.Controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hc.managers.EmsCountryCodeService;
import com.hc.managers.EmsExpertService;
import com.hc.managers.EmsGovernorateCodeService;
import com.hc.model.EmsExpert;
import com.hc.model.EmsGovernorateCode;
import com.hc.repositories.EmsExpertRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/Expert")
@RequiredArgsConstructor
public class expertController {
private final EmsExpertService emsExpertService;
    
    @GetMapping("/getExpert")
	public ResponseEntity<EmsExpert> getall(@RequestParam("ExpertId") Long ExpertID) {
		
		
			
			return new ResponseEntity<>(emsExpertService.getExpert(ExpertID), HttpStatus.OK);
			
		
		
	}
}
