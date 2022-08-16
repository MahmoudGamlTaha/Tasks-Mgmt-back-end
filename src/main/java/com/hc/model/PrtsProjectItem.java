package com.hc.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the PRTS_PROJECT_ITEMS database table.
 * 
 */
@Entity
@Table(name="PRTS_PROJECT_ITEMS")
@NamedQuery(name="PrtsProjectItem.findAll", query="SELECT p FROM PrtsProjectItem p")
public class PrtsProjectItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ITEM_ID")
	private long itemId;

	@Column(name="ITEM_NAME")
	private String itemName;

	@Column(name="ITEM_TOTAL_AMOUNT")
	private BigDecimal itemTotalAmount;

	@Column(name="ITEM_WEIGHT")
	private BigDecimal itemWeight;

	@Column(name="PROJECT_ID")
	private Long projectId;
	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	//bi-directional many-to-one association to PrtsProject
//	@JsonIgnore
//	@ManyToOne
//	@JoinColumn(name="PROJECT_ID")
//	private PrtsProject prtsProject;

	//bi-directional many-to-one association to PrtsProjectItemsPlanning
	@OneToMany(mappedBy="prtsProjectItem")
	private List<PrtsProjectItemsPlanning> prtsProjectItemsPlannings;

	public PrtsProjectItem() {
	}

	public long getItemId() {
		return this.itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return this.itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public BigDecimal getItemTotalAmount() {
		return this.itemTotalAmount;
	}

	public void setItemTotalAmount(BigDecimal itemTotalAmount) {
		this.itemTotalAmount = itemTotalAmount;
	}

	public BigDecimal getItemWeight() {
		return this.itemWeight;
	}

	public void setItemWeight(BigDecimal itemWeight) {
		this.itemWeight = itemWeight;
	}

//	public PrtsProject getPrtsProject() {
//		return this.prtsProject;
//	}
//
//	public void setPrtsProject(PrtsProject prtsProject) {
//		this.prtsProject = prtsProject;
//	}

	public List<PrtsProjectItemsPlanning> getPrtsProjectItemsPlannings() {
		return this.prtsProjectItemsPlannings;
	}

	public void setPrtsProjectItemsPlannings(List<PrtsProjectItemsPlanning> prtsProjectItemsPlannings) {
		this.prtsProjectItemsPlannings = prtsProjectItemsPlannings;
	}

	public PrtsProjectItemsPlanning addPrtsProjectItemsPlanning(PrtsProjectItemsPlanning prtsProjectItemsPlanning) {
		getPrtsProjectItemsPlannings().add(prtsProjectItemsPlanning);
		prtsProjectItemsPlanning.setPrtsProjectItem(this);

		return prtsProjectItemsPlanning;
	}

	public PrtsProjectItemsPlanning removePrtsProjectItemsPlanning(PrtsProjectItemsPlanning prtsProjectItemsPlanning) {
		getPrtsProjectItemsPlannings().remove(prtsProjectItemsPlanning);
		prtsProjectItemsPlanning.setPrtsProjectItem(null);

		return prtsProjectItemsPlanning;
	}

}