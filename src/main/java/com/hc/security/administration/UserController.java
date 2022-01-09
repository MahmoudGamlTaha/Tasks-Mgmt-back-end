package com.hc.security.administration;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hc.security.administration.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;
	
	@PostMapping("/logout")
	public ResponseEntity<String> logoutUser(@RequestParam String username) {
		
		try {
			userService.logoutUser(username);	
			return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
			
		} catch(Exception ex) {
			
			ex.printStackTrace();
			return new ResponseEntity<>("FAILED, ERROR: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
	}
	
}
