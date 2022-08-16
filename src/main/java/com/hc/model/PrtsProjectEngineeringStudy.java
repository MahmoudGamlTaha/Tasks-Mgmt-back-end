package com.hc.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the PRTS_PROJECT_ENGINEERING_STUDY database table.
 * 
 */
@Entity
@Table(name="PRTS_PROJECT_ENGINEERING_STUDY")
@NamedQuery(name="PrtsProjectEngineeringStudy.findAll", query="SELECT p FROM PrtsProjectEngineeringStudy p")
public class PrtsProjectEngineeringStudy implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="PROJECT_ID", insertable = false, updatable = false)
	private long PROJECT_ID;

	@Temporal(TemporalType.DATE)
	@Column(name="ACTUAL_END_DATE")
	private Date actualEndDate;

	@Temporal(TemporalType.DATE)
	@Column(name="ACTUAL_START_DATE")
	private Date actualStartDate;

	@Column(name="COMPLETION_RATE")
	private BigDecimal completionRate;

	@Column(name="ELAPSED_TIME_RATE")
	private BigDecimal elapsedTimeRate;

	@Temporal(TemporalType.DATE)
	@Column(name="PLAN_END_DATE")
	private Date planEndDate;

	@Temporal(TemporalType.DATE)
	@Column(name="PLAN_START_DATE")
	private Date planStartDate;

	//bi-directional one-to-one association to PrtsProject
	@JsonIgnore
	@OneToOne
	@JoinColumn(name="PROJECT_ID", insertable = false, updatable = false)
	private PrtsProject prtsProject;

	public PrtsProjectEngineeringStudy() {
	}

	public Date getActualEndDate() {
		return this.actualEndDate;
	}

	public void setActualEndDate(Date actualEndDate) {
		this.actualEndDate = actualEndDate;
	}

	public Date getActualStartDate() {
		return this.actualStartDate;
	}

	public void setActualStartDate(Date actualStartDate) {
		this.actualStartDate = actualStartDate;
	}

	public BigDecimal getCompletionRate() {
		return this.completionRate;
	}

	public void setCompletionRate(BigDecimal completionRate) {
		this.completionRate = completionRate;
	}

	public BigDecimal getElapsedTimeRate() {
		return this.elapsedTimeRate;
	}

	public void setElapsedTimeRate(BigDecimal elapsedTimeRate) {
		this.elapsedTimeRate = elapsedTimeRate;
	}

	public Date getPlanEndDate() {
		return this.planEndDate;
	}

	public void setPlanEndDate(Date planEndDate) {
		this.planEndDate = planEndDate;
	}

	public Date getPlanStartDate() {
		return this.planStartDate;
	}

	public void setPlanStartDate(Date planStartDate) {
		this.planStartDate = planStartDate;
	}

	public PrtsProject getPrtsProject() {
		return this.prtsProject;
	}

	public void setPrtsProject(PrtsProject prtsProject) {
		this.prtsProject = prtsProject;
	}

}