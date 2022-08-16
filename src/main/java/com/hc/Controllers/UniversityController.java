package com.hc.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hc.managers.EmsCityCodeService;
import com.hc.managers.EmsUniversityCodeService;
import com.hc.model.EmsCityCode;
import com.hc.model.EmsUniversityCode;
import com.hc.repositories.EmsUniversityCodeRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/University")
@RequiredArgsConstructor
public class UniversityController {
	@Autowired
    private final EmsUniversityCodeService emsUniversityCodeSer;
    
    @GetMapping("/getall")
	public ResponseEntity<List<EmsUniversityCode>> getall() {
		
		
			
			return new ResponseEntity<>(emsUniversityCodeSer.getall(), HttpStatus.OK);
			
		
		
	}
}
