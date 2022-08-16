package com.hc.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hc.managers.EmsJobCodeService;
import com.hc.managers.EmsStudyFieldCodeService;
import com.hc.model.EmsJobCode;
import com.hc.model.EmsStudyFieldCode;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/Jobs")
@RequiredArgsConstructor
public class EmsJobController {
	@Autowired
    private final EmsJobCodeService emsJobCodeService;
    
    @GetMapping("/getall")
	public ResponseEntity<List<EmsJobCode>> getall() {
		
		
			
			return new ResponseEntity<>(emsJobCodeService.getall(), HttpStatus.OK);
			
		
		
	}

}
