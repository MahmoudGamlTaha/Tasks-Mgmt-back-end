package com.hc.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hc.managers.EmsCityCodeService;
import com.hc.model.EmsCityCode;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/city")
@RequiredArgsConstructor
public class cityController {
	@Autowired
    private final EmsCityCodeService emsCityCodeService;
    
    @GetMapping("/getall")
	public ResponseEntity<List<EmsCityCode>> getall() {
		
		
			
			return new ResponseEntity<>(emsCityCodeService.getall(), HttpStatus.OK);
			
		
		
	}
	
}
