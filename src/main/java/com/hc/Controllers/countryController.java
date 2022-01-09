package com.hc.Controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hc.managers.EmsCityCodeService;
import com.hc.managers.EmsCountryCodeService;
import com.hc.model.EmsCityCode;
import com.hc.model.EmsCountryCode;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/Country")
@RequiredArgsConstructor
public class countryController {
    private final EmsCountryCodeService emsCountryCodeService;
    
    @GetMapping("/getall")
	public ResponseEntity<List<EmsCountryCode>> getall() {
		
		
			
			return new ResponseEntity<>(emsCountryCodeService.getall(), HttpStatus.OK);
			
		
		
	}
	
}
