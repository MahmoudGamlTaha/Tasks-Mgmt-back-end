package com.hc.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hc.managers.EmsStudyFieldCodeService;
import com.hc.managers.EmsUniversityCodeService;
import com.hc.model.EmsStudyFieldCode;
import com.hc.model.EmsUniversityCode;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/StudyField")
@RequiredArgsConstructor
public class EmsStudyFieldController {

	@Autowired
    private final EmsStudyFieldCodeService emsStudyFieldCodeService;
    
    @GetMapping("/getall")
	public ResponseEntity<List<EmsStudyFieldCode>> getall() {
		
		
			
			return new ResponseEntity<>(emsStudyFieldCodeService.getall(), HttpStatus.OK);
			
		
		
	}
}
