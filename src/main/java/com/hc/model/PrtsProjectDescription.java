package com.hc.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the PRTS_PROJECT_DESCRIPTION database table.
 * 
 */
@Entity
@Table(name="PRTS_PROJECT_DESCRIPTION")
@NamedQuery(name="PrtsProjectDescription.findAll", query="SELECT p FROM PrtsProjectDescription p")
public class PrtsProjectDescription implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="PROJECT_ID", insertable = false, updatable = false)
	private long PROJECT_ID;


	@Column(name="LOOKUP_ID_3")
	private java.math.BigDecimal lookupId3;

	@Column(name="LOOKUP_ID_4")
	private java.math.BigDecimal lookupId4;

	@Column(name="LOOKUP_ID_5")
	private java.math.BigDecimal lookupId5;

	@Column(name="LOOKUP_ID_6")
	private java.math.BigDecimal lookupId6;

	@Column(name="LOOKUP_ID_7")
	private java.math.BigDecimal lookupId7;

	@Column(name="LOOKUP_ID_8")
	private java.math.BigDecimal lookupId8;

	@Column(name="PROJECT_DESC")
	private String projectDesc;

	@Column(name="PROJECT_GOAL")
	private String projectGoal;

	@Column(name="PROJECT_OUTPUT")
	private String projectOutput;

	//bi-directional one-to-one association to PrtsProject
	@JsonIgnore
	@OneToOne
	@JoinColumn(name="PROJECT_ID", insertable = false, updatable = false)
	private PrtsProject prtsProject;

	public PrtsProjectDescription() {
	}

	

	public java.math.BigDecimal getLookupId3() {
		return this.lookupId3;
	}

	public void setLookupId3(java.math.BigDecimal lookupId3) {
		this.lookupId3 = lookupId3;
	}

	public java.math.BigDecimal getLookupId4() {
		return this.lookupId4;
	}

	public void setLookupId4(java.math.BigDecimal lookupId4) {
		this.lookupId4 = lookupId4;
	}

	public java.math.BigDecimal getLookupId5() {
		return this.lookupId5;
	}

	public void setLookupId5(java.math.BigDecimal lookupId5) {
		this.lookupId5 = lookupId5;
	}

	public java.math.BigDecimal getLookupId6() {
		return this.lookupId6;
	}

	public void setLookupId6(java.math.BigDecimal lookupId6) {
		this.lookupId6 = lookupId6;
	}

	public java.math.BigDecimal getLookupId7() {
		return this.lookupId7;
	}

	public void setLookupId7(java.math.BigDecimal lookupId7) {
		this.lookupId7 = lookupId7;
	}

	public java.math.BigDecimal getLookupId8() {
		return this.lookupId8;
	}

	public void setLookupId8(java.math.BigDecimal lookupId8) {
		this.lookupId8 = lookupId8;
	}

	public String getProjectDesc() {
		return this.projectDesc;
	}

	public void setProjectDesc(String projectDesc) {
		this.projectDesc = projectDesc;
	}

	public String getProjectGoal() {
		return this.projectGoal;
	}

	public void setProjectGoal(String projectGoal) {
		this.projectGoal = projectGoal;
	}

	public String getProjectOutput() {
		return this.projectOutput;
	}

	public void setProjectOutput(String projectOutput) {
		this.projectOutput = projectOutput;
	}

	public PrtsProject getPrtsProject() {
		return this.prtsProject;
	}

	public void setPrtsProject(PrtsProject prtsProject) {
		this.prtsProject = prtsProject;
	}

}