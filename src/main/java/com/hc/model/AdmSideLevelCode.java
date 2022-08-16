package com.hc.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the ADM_SIDE_LEVEL_CODE database table.
 * 
 */
@Entity
@Table(name="ADM_SIDE_LEVEL_CODE")
@NamedQuery(name="AdmSideLevelCode.findAll", query="SELECT a FROM AdmSideLevelCode a")
public class AdmSideLevelCode implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	
	@Column(name="SIDE_LEVEL_CODE")
	private long sideLevelCode;

	@Column(name="SIDE_LEVEL_NAME")
	private String sideLevelName;

	@Column(name="SIDE_LEVEL_ORDER")
	private BigDecimal sideLevelOrder;

	public AdmSideLevelCode() {
	}

	public long getSideLevelCode() {
		return this.sideLevelCode;
	}

	public void setSideLevelCode(long sideLevelCode) {
		this.sideLevelCode = sideLevelCode;
	}

	public String getSideLevelName() {
		return this.sideLevelName;
	}

	public void setSideLevelName(String sideLevelName) {
		this.sideLevelName = sideLevelName;
	}

	public BigDecimal getSideLevelOrder() {
		return this.sideLevelOrder;
	}

	public void setSideLevelOrder(BigDecimal sideLevelOrder) {
		this.sideLevelOrder = sideLevelOrder;
	}

}