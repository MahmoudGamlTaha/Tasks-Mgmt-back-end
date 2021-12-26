package com.mts.security.administration;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="ADM_USER_PERMISSIONS", schema = "EMS")
@IdClass(UserPermissionId.class)
public class UserPermission {

	@Id
	private Long USER_ID;
	@Id
	private Long RULE_ID;
	@Id
	private Long MODULE_ID;
	private String USER_LOGIN;
	private String RULE_NAME;
	
}
