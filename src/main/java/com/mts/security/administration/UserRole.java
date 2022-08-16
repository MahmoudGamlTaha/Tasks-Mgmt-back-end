package com.mts.security.administration;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="PRTS_USER_ROLE")
public class UserRole {

	@Id
	@Column(name = "USER_ROLE_ID")
	private Long ROLE_ID;
	
	@OneToOne
	@JoinColumn(name = "USER_ID")
	private com.hc.security.administration.User user;
	
}
