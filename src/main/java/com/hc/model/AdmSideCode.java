package com.hc.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the ADM_SIDE_CODE database table.
 * 
 */
@Entity
@Table(name="ADM_SIDE_CODE")
@NamedQuery(name="AdmSideCode.findAll", query="SELECT a FROM AdmSideCode a")
public class AdmSideCode implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="SIDE_CODE")
	private long sideCode;

	@Column(name="PARENT_SIDE_CODE")
	private BigDecimal parentSideCode;

	@Column(name="SIDE_DESC")
	private String sideDesc;

	@Column(name="SIDE_LEVEL_CODE")
	private BigDecimal sideLevelCode;

	@Column(name="SIDE_NAME")
	private String sideName;

	public AdmSideCode() {
	}

	public long getSideCode() {
		return this.sideCode;
	}

	public void setSideCode(long sideCode) {
		this.sideCode = sideCode;
	}

	public BigDecimal getParentSideCode() {
		return this.parentSideCode;
	}

	public void setParentSideCode(BigDecimal parentSideCode) {
		this.parentSideCode = parentSideCode;
	}

	public String getSideDesc() {
		return this.sideDesc;
	}

	public void setSideDesc(String sideDesc) {
		this.sideDesc = sideDesc;
	}

	public BigDecimal getSideLevelCode() {
		return this.sideLevelCode;
	}

	public void setSideLevelCode(BigDecimal sideLevelCode) {
		this.sideLevelCode = sideLevelCode;
	}

	public String getSideName() {
		return this.sideName;
	}

	public void setSideName(String sideName) {
		this.sideName = sideName;
	}

}