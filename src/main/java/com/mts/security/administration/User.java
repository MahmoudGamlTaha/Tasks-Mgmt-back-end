package com.mts.security.administration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="ADM_USER", schema = "EMS")
public class User implements UserDetails{

	@Id
	private Long USER_ID;
	private String USER_NAME;
	private String USER_EMAIL;
	private String USER_LOGIN;
	private String LAST_MODIFIED_BY;
	private Long SIDE_CODE;
	private String USER_PASS;
	private String USER_TYPE;
	private String USER_JOB;
	private String USER_MOBIL_1;
	private String USER_MOBIL_2;
	
	@Transient
	private List<Role> roles;
	
	@Transient
	private List<UserPermission> permissions;
	
	@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();

        // Extract list of permissions (name)
        getPermissionsStrings().forEach(p -> {
            GrantedAuthority authority = new SimpleGrantedAuthority(p);
            authorities.add(authority);
        });

        // Extract list of roles (ROLE_name)
        getRolesStrings().forEach(r -> {
            GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + r);
            authorities.add(authority);
        });

        return authorities;
    }

	public List<String> getRolesStrings() {
		
		List<String> rolesStrings = new ArrayList<String>();
		roles.forEach( role -> {
			rolesStrings.add(role.getROLE_NAME());
		});
		
		return rolesStrings;
	}
	
	public List<String> getPermissionsStrings() {
		
		List<String> permissionsStrings = new ArrayList<String>();
		permissions.forEach( permission -> {
			permissionsStrings.add(permission.getRULE_NAME());
		});
		
		return permissionsStrings;
	}

	@Override
    public String getPassword() {
        return getUSER_PASS();
    }

    @Override
    public String getUsername() {
        return getUSER_LOGIN();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
	
}
