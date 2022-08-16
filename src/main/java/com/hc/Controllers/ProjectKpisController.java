package com.hc.Controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hc.managers.PrtsProjectService;
import com.hc.model.FilterProject;
import com.hc.model.KpisMonitor;
import com.hc.model.KpisResults;
import com.hc.model.ProjectResults;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/kpis")
@RequiredArgsConstructor
public class ProjectKpisController {
	@Autowired
	  private final  PrtsProjectService prtsprojectservice;
	
	@PostMapping("/SearchForProjects")
	public ResponseEntity< List<Map<String, Object>>> SearchForProjects(@RequestBody KpisMonitor params) {
					
		
			return new ResponseEntity<>(prtsprojectservice.calculateKpis(params), HttpStatus.OK);	
		
	}
  
}
