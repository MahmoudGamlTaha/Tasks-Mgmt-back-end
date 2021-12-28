package com.mts.security.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.env.Environment;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mts.security.administration.Role;
import com.mts.security.administration.RoleRepo;
import com.mts.security.administration.User;
import com.mts.security.administration.UserPermission;
import com.mts.security.administration.UserPermissionRepo;
import com.mts.security.administration.UserRepo;
import com.mts.security.administration.UserRole;
import com.mts.security.administration.UserRoleRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService{

	private final UserRepo userRepository;
	private final RoleRepo roleRepository;
	private final UserRoleRepo userRoleRepository;
	private final UserPermissionRepo userPermissionRepo;
	private final Environment env;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = this.userRepository.findByUsername(username);
		
		if(user == null) 
			throw new UsernameNotFoundException("User not found");

		// get user roles and permissions 
		// then load them in the object user
		//List<UserRole> userRoles = userRoleRepository.getUserRolesById(user.getUSER_ID());
		//List<Role> roles = new ArrayList<Role>();
	//	userRoles.forEach(r -> {
		//	roles.add(roleRepository.getById(r.getROLE_ID()));
	//	});
		//user.setRoles(roles);
		
		List<UserPermission> userPermissions = userPermissionRepo.getUserPermissionsById(user.getUSER_ID(), Long.valueOf(env.getProperty("app.moduleID")));
		user.setPermissions(userPermissions);
		
        return user;
	}

}