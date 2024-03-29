package com.mts.security.administration;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@Entity
//@Table(name = "SC_ROLES", schema = "BPM_ADMINISTRATION")
@Proxy(lazy = false)
public class Role {

	@Id
	private Long ROLE_ID;
	private String ROLE_NAME;
	private Long PARENT_ROLE_ID;
	private String LAST_MODIFIED_BY;
	private String DESCRIPTION;
	
}
