package com.hc.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the PRTS_USER_ROLE database table.
 * 
 */
@Entity
@Table(name="PRTS_USER_ROLE")
@NamedQuery(name="PrtsUserRole.findAll", query="SELECT p FROM PrtsUserRole p")
public class PrtsUserRole implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	@Column(name="IS_AVALIABLE")
	private BigDecimal isAvaliable;
   
	@Column(name="USER_ID")
	private BigDecimal userId;
  
	@Column(name="USER_ROLE_CODE")
	private BigDecimal userRoleCode;
    @Id
	@Column(name="USER_ROLE_ID")
	private BigDecimal userRoleId;

	public PrtsUserRole() {
	}

	public BigDecimal getIsAvaliable() {
		return this.isAvaliable;
	}

	public void setIsAvaliable(BigDecimal isAvaliable) {
		this.isAvaliable = isAvaliable;
	}

	public BigDecimal getUserId() {
		return this.userId;
	}

	public void setUserId(BigDecimal userId) {
		this.userId = userId;
	}

	public BigDecimal getUserRoleCode() {
		return this.userRoleCode;
	}

	public void setUserRoleCode(BigDecimal userRoleCode) {
		this.userRoleCode = userRoleCode;
	}

	public BigDecimal getUserRoleId() {
		return this.userRoleId;
	}

	public void setUserRoleId(BigDecimal userRoleId) {
		this.userRoleId = userRoleId;
	}

}