package com.hc.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;


/**
 * The persistent class for the PRTS_PROJECT_FINANCE database table.
 * 
 */
@Entity
@Table(name="PRTS_PROJECT_FINANCE")
@NamedQuery(name="PrtsProjectFinance.findAll", query="SELECT p FROM PrtsProjectFinance p")
public class PrtsProjectFinance implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="PROJECT_ID", insertable = false, updatable = false)
	private long PROJECT_ID;

	@Column(name="PROJECT_CAPITAL_EXPENSES")
	private BigDecimal projectCapitalExpenses;

	@Column(name="PROJECT_CAPITAL_VALUE")
	private BigDecimal projectCapitalValue;

	@Column(name="PROJECT_OPERATIONAL_EXPENSES")
	private BigDecimal projectOperationalExpenses;

	@Column(name="PROJECT_OPERATIONAL_VALUE")
	private BigDecimal projectOperationalValue;

	@Column(name="PROJECT_SIGNED_VALUE")
	private BigDecimal projectSignedValue;

	//bi-directional one-to-one association to PrtsProject
	@JsonIgnore
	@OneToOne
	@JoinColumn(name="PROJECT_ID", insertable = false, updatable = false)
	private PrtsProject prtsProject;

	public PrtsProjectFinance() {
	}

	

	public BigDecimal getProjectCapitalExpenses() {
		return this.projectCapitalExpenses;
	}

	public void setProjectCapitalExpenses(BigDecimal projectCapitalExpenses) {
		this.projectCapitalExpenses = projectCapitalExpenses;
	}

	public BigDecimal getProjectCapitalValue() {
		return this.projectCapitalValue;
	}

	public void setProjectCapitalValue(BigDecimal projectCapitalValue) {
		this.projectCapitalValue = projectCapitalValue;
	}

	public BigDecimal getProjectOperationalExpenses() {
		return this.projectOperationalExpenses;
	}

	public void setProjectOperationalExpenses(BigDecimal projectOperationalExpenses) {
		this.projectOperationalExpenses = projectOperationalExpenses;
	}

	public BigDecimal getProjectOperationalValue() {
		return this.projectOperationalValue;
	}

	public void setProjectOperationalValue(BigDecimal projectOperationalValue) {
		this.projectOperationalValue = projectOperationalValue;
	}

	public BigDecimal getProjectSignedValue() {
		return this.projectSignedValue;
	}

	public void setProjectSignedValue(BigDecimal projectSignedValue) {
		this.projectSignedValue = projectSignedValue;
	}

	public PrtsProject getPrtsProject() {
		return this.prtsProject;
	}

	public void setPrtsProject(PrtsProject prtsProject) {
		this.prtsProject = prtsProject;
	}

}