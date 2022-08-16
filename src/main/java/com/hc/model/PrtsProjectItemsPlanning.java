package com.hc.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;


/**
 * The persistent class for the PRTS_PROJECT_ITEMS_PLANNING database table.
 * 
 */
@Entity
@Table(name="PRTS_PROJECT_ITEMS_PLANNING")
@NamedQuery(name="PrtsProjectItemsPlanning.findAll", query="SELECT p FROM PrtsProjectItemsPlanning p")
public class PrtsProjectItemsPlanning implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ITEM_PLAN_ID")
	private long itemPlanId;

	public BigDecimal getPlannedAmount() {
		return plannedAmount;
	}

	public void setPlannedAmount(BigDecimal plannedAmount) {
		this.plannedAmount = plannedAmount;
	}

	public BigDecimal getActualAmount() {
		return actualAmount;
	}

	public void setActualAmount(BigDecimal actualAmount) {
		this.actualAmount = actualAmount;
	}

	@Column(name="ACTUAL_PERCENTAGE")
	private BigDecimal actualPercentage;

	@Column(name="MONTH")
	private BigDecimal month;

	@Column(name="PLANNED_PERCENTAGE")
	private BigDecimal plannedPercentage;

	@Column(name="PROJECT_ID")
	private BigDecimal projectId;

	@Column(name="YEAR")
	private BigDecimal year;
	
	@Column(name="PLANNED_EXEC_AMOUNT")
	private BigDecimal plannedAmount;
	
	@Column(name="ACTUAL_EXEC_AMOUNT")
	private BigDecimal actualAmount;
	
	//bi-directional many-to-one association to PrtsProjectItem
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="ITEM_ID",insertable = false,updatable = false)
	private PrtsProjectItem prtsProjectItem;

	public PrtsProjectItemsPlanning() {
	}

	public long getItemPlanId() {
		return this.itemPlanId;
	}

	public void setItemPlanId(long itemPlanId) {
		this.itemPlanId = itemPlanId;
	}

	public BigDecimal getActualPercentage() {
		return this.actualPercentage;
	}

	public void setActualPercentage(BigDecimal actualPercentage) {
		this.actualPercentage = actualPercentage;
	}

	public BigDecimal getMonth() {
		return this.month;
	}

	public void setMonth(BigDecimal month) {
		this.month = month;
	}

	public BigDecimal getPlannedPercentage() {
		return this.plannedPercentage;
	}

	public void setPlannedPercentage(BigDecimal plannedPercentage) {
		this.plannedPercentage = plannedPercentage;
	}

	public BigDecimal getProjectId() {
		return this.projectId;
	}

	public void setProjectId(BigDecimal projectId) {
		this.projectId = projectId;
	}

	public BigDecimal getYear() {
		return this.year;
	}

	public void setYear(BigDecimal year) {
		this.year = year;
	}

	public PrtsProjectItem getPrtsProjectItem() {
		return this.prtsProjectItem;
	}

	public void setPrtsProjectItem(PrtsProjectItem prtsProjectItem) {
		this.prtsProjectItem = prtsProjectItem;
	}

}