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
import com.hc.managers.EmsGovernorateCodeService;
import com.hc.model.EmsCityCode;
import com.hc.model.EmsGovernorateCode;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/gov")
@RequiredArgsConstructor
public class govController {
    private final EmsGovernorateCodeService emsGovernorateCodeService;
    
    @GetMapping("/getall")
	public ResponseEntity<List<EmsGovernorateCode>> getall() {
		
		
			
			return new ResponseEntity<>(emsGovernorateCodeService.getall(), HttpStatus.OK);
			
		
		
	}
	
}
