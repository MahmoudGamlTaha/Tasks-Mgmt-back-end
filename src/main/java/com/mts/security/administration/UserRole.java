package com.mts.security.administration;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="SC_USERROLE", schema = "BPM_ADMINISTRATION")
public class UserRole {

	@Id
	private Long ROLE_ID;
	private Long USER_ID;
	private String LAST_MODIFIED_BY;
	
}
