package com.mts.security.administration;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

	private final UserRepo userRepo;
	
	public void logoutUser (String username) {
		
		User user = userRepo.findByUsername(username);
		
		if(user == null)
			throw new UsernameNotFoundException("Username not found");
		
		try {		
			//userRepo.deactivateUser(username);	
		} catch(Exception ex) {
			log.error("Error deactivating user in database: {}", ex.getMessage());
			ex.printStackTrace();
		}
		
	}
	
}
