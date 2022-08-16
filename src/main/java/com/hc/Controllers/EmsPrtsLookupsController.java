package com.hc.Controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hc.managers.PrtsProjectService;
import com.hc.managers.PrtsSectorCodeService;
import com.hc.model.EmsStudyFieldCode;
import com.hc.model.InitiativeCode;
import com.hc.model.PrtsLookup;
import com.hc.model.PrtsSectorCode;
import com.hc.model.SideCode;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/lookups")
@RequiredArgsConstructor
public class EmsPrtsLookupsController {
	final private PrtsSectorCodeService PrtsSectorCodeService;
	
	 @GetMapping("/getallSector")
		public ResponseEntity<List<PrtsSectorCode>> getall() {			
				return new ResponseEntity<>(PrtsSectorCodeService.getall(), HttpStatus.OK);
			
		}
	 @GetMapping("/getallInitiative")
		public ResponseEntity<List<InitiativeCode>> getallInitiative() {			
				return new ResponseEntity<>(PrtsSectorCodeService.getallInitiative(), HttpStatus.OK);
			
		}
	 @GetMapping("/getLookupObjects")
		public ResponseEntity<List<PrtsLookup>> getallObjectOflookup(long LookupId) {			
				return new ResponseEntity<>(PrtsSectorCodeService.getalLookupObject(LookupId), HttpStatus.OK);
			
		}
	 @GetMapping("/getAllSides")
		public ResponseEntity<List<SideCode>> getAllSides() {			
				return new ResponseEntity<>(PrtsSectorCodeService.getAllSides(), HttpStatus.OK);
			
		}
	 

}
