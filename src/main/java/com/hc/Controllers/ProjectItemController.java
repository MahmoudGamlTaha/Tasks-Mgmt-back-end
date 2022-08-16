package com.hc.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hc.managers.PrtsProjectItemService;
import com.hc.managers.PrtsProjectService;
import com.hc.model.DynamicResponse;
import com.hc.model.GeneralResponse;
import com.hc.model.PrtsProject;
import com.hc.model.PrtsProjectItem;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/projectitem")
@RequiredArgsConstructor
public class ProjectItemController {
	@Autowired
	  private final  PrtsProjectItemService prtsProjectItemService;
	
	 @GetMapping("/getProjectItems")
		public ResponseEntity<List<PrtsProjectItem>> getall(@RequestParam Long ProjectId) {
						
				return new ResponseEntity<>(prtsProjectItemService.getAllProjectItemOfProject(ProjectId), HttpStatus.OK);	
			
		}
	 
	    @PostMapping("/saveItem")
		public ResponseEntity<DynamicResponse<PrtsProjectItem>> saveItem(@RequestBody PrtsProjectItem projItem) {
						
		String Result= prtsProjectItemService.validateProjectItems(Integer.parseInt(projItem.getProjectId().toString()), Integer.parseInt(projItem.getItemTotalAmount().toPlainString()),  Integer.parseInt(projItem.getItemWeight().toPlainString()));
		 
		 DynamicResponse<PrtsProjectItem> res=new DynamicResponse<PrtsProjectItem>();
          if(!Result.equalsIgnoreCase("VALID")) {
        	 
				   res.setStatusCode("-1");
					res.setMessage(Result);
					
			 
				return new ResponseEntity<>(res, HttpStatus.OK);
          }
		  try {
			  PrtsProjectItem Saved =prtsProjectItemService.saveProjectItem(projItem);	
				res.setData(Saved);
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
	 
	 
	 @GetMapping("/deletProjectItem")
		public ResponseEntity<DynamicResponse<Object>> deletProjectItem(@RequestParam Long ProjectItemId) {
		 DynamicResponse<Object> res=new DynamicResponse<Object>();
		  try {
				prtsProjectItemService.deleteProjectItem(ProjectItemId);
				res.setStatusCode("0");
				res.setMessage("Success");
				return new ResponseEntity<>(res, HttpStatus.OK);	
				
		  } catch(Exception e) {
			  res.setStatusCode("-1");
				res.setMessage("Unexpected Error Please Contact Your Administrator");
				return new ResponseEntity<>(res, HttpStatus.OK);	
		  }
		}

}
