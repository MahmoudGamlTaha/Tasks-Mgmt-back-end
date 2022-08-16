package com.hc.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;


/**
 * The persistent class for the PRTS_PROJECT_STATUS database table.
 * 
 */
@Entity
@Table(name="PRTS_PROJECT_STATUS")
@NamedQuery(name="PrtsProjectStatus.findAll", query="SELECT p FROM PrtsProjectStatus p")
public class PrtsProjectStatus implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="PROJECT_ID", insertable = false, updatable = false)
	private long PROJECT_ID;
	
	@Temporal(TemporalType.DATE)
	@Column(name="CHANGE_DATE_10")
	private Date changeDate10;

	@Temporal(TemporalType.DATE)
	@Column(name="CHANGE_DATE_11")
	private Date changeDate11;

	@Temporal(TemporalType.DATE)
	@Column(name="CHANGE_DATE_12")
	private Date changeDate12;

	@Temporal(TemporalType.DATE)
	@Column(name="CHANGE_DATE_9")
	private Date changeDate9;

	@Column(name="LOOKUP_ID_10")
	private java.math.BigDecimal lookupId10;

	@Column(name="LOOKUP_ID_11")
	private java.math.BigDecimal lookupId11;

	@Column(name="LOOKUP_ID_12")
	private java.math.BigDecimal lookupId12;

	@Column(name="LOOKUP_ID_9")
	private java.math.BigDecimal lookupId9;

	@Column(name="USER_ID_10")
	private java.math.BigDecimal userId10;

	@Column(name="USER_ID_11")
	private java.math.BigDecimal userId11;

	@Column(name="USER_ID_12")
	private java.math.BigDecimal userId12;

	@Column(name="USER_ID_9")
	private java.math.BigDecimal userId9;

	//bi-directional one-to-one association to PrtsProject
	@JsonIgnore
	@OneToOne
	@JoinColumn(name="PROJECT_ID", insertable = false, updatable = false)
	private PrtsProject prtsProject;

	public PrtsProjectStatus() {
	}


	public Date getChangeDate10() {
		return this.changeDate10;
	}

	public void setChangeDate10(Date changeDate10) {
		this.changeDate10 = changeDate10;
	}

	public Date getChangeDate11() {
		return this.changeDate11;
	}

	public void setChangeDate11(Date changeDate11) {
		this.changeDate11 = changeDate11;
	}

	public Date getChangeDate12() {
		return this.changeDate12;
	}

	public void setChangeDate12(Date changeDate12) {
		this.changeDate12 = changeDate12;
	}

	public Date getChangeDate9() {
		return this.changeDate9;
	}

	public void setChangeDate9(Date changeDate9) {
		this.changeDate9 = changeDate9;
	}

	public java.math.BigDecimal getLookupId10() {
		return this.lookupId10;
	}

	public void setLookupId10(java.math.BigDecimal lookupId10) {
		this.lookupId10 = lookupId10;
	}

	public java.math.BigDecimal getLookupId11() {
		return this.lookupId11;
	}

	public void setLookupId11(java.math.BigDecimal lookupId11) {
		this.lookupId11 = lookupId11;
	}

	public java.math.BigDecimal getLookupId12() {
		return this.lookupId12;
	}

	public void setLookupId12(java.math.BigDecimal lookupId12) {
		this.lookupId12 = lookupId12;
	}

	public java.math.BigDecimal getLookupId9() {
		return this.lookupId9;
	}

	public void setLookupId9(java.math.BigDecimal lookupId9) {
		this.lookupId9 = lookupId9;
	}

	public java.math.BigDecimal getUserId10() {
		return this.userId10;
	}

	public void setUserId10(java.math.BigDecimal userId10) {
		this.userId10 = userId10;
	}

	public java.math.BigDecimal getUserId11() {
		return this.userId11;
	}

	public void setUserId11(java.math.BigDecimal userId11) {
		this.userId11 = userId11;
	}

	public java.math.BigDecimal getUserId12() {
		return this.userId12;
	}

	public void setUserId12(java.math.BigDecimal userId12) {
		this.userId12 = userId12;
	}

	public java.math.BigDecimal getUserId9() {
		return this.userId9;
	}

	public void setUserId9(java.math.BigDecimal userId9) {
		this.userId9 = userId9;
	}

	public PrtsProject getPrtsProject() {
		return this.prtsProject;
	}

	public void setPrtsProject(PrtsProject prtsProject) {
		this.prtsProject = prtsProject;
	}

}