package com.hc.Controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hc.managers.PrtsProjectItemService;
import com.hc.managers.PrtsProjectItemsPlanningService;
import com.hc.model.DynamicResponse;
import com.hc.model.PrtsProjectItem;
import com.hc.model.PrtsProjectItemsPlanning;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/projectitem")
@RequiredArgsConstructor
public class ProjectItemPlanningController {
	@Autowired
	  private final  PrtsProjectItemsPlanningService prtsProjectItemPlanningService;
	
	
	@PostMapping("/saveItemsPlan")
		public ResponseEntity<DynamicResponse<Object>> saveItem(@RequestBody List<PrtsProjectItemsPlanning> projItem) {
						
		 DynamicResponse<Object> res=new DynamicResponse<Object>();

		
		  try {
			 prtsProjectItemPlanningService.saveListOfItems(projItem);	
				//res.setData(Saved);
				res.setStatusCode("0");
				res.setMessage("Success");
				return new ResponseEntity<>(res, HttpStatus.OK);	
		 }catch(Exception e) {
			   if (e.getMessage().contains("TABLE1_PK")) {
				   res.setStatusCode("-2");
					res.setMessage("project Item  Must Be Unique");
			   }
			   else {
				   res.setStatusCode("-1");
					res.setMessage("Unexpected Error Please Contact Your Administrator");
					
			   }
				return new ResponseEntity<>(res, HttpStatus.OK);	
		 } 		
			
		}

}
