package com.hc.Controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hc.managers.EmsCountryCodeService;
import com.hc.managers.EmsEducationDegreeCodeService;
import com.hc.model.EmsCountryCode;
import com.hc.model.EmsEducationDegreeCode;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/Degree")
@RequiredArgsConstructor
public class EmsEducationDegreeCodeController {
private final EmsEducationDegreeCodeService emsEducationDegreeCodeService;
    
    @GetMapping("/getall")
	public ResponseEntity<List<EmsEducationDegreeCode>> getall() {
		
			
			return new ResponseEntity<>(emsEducationDegreeCodeService.getall(), HttpStatus.OK);
			
		
		
	}
}
