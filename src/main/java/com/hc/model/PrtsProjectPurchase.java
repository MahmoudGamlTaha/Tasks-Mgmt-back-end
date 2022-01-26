package com.hc.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the PRTS_PROJECT_PURCHASE database table.
 * 
 */
@Entity
@Table(name="PRTS_PROJECT_PURCHASE")
@NamedQuery(name="PrtsProjectPurchase.findAll", query="SELECT p FROM PrtsProjectPurchase p")
public class PrtsProjectPurchase implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="fake_id", insertable = false, updatable = false)
	private long fakeId;

	@Column(name="ANOTHER_NUM")
	private String anotherNum;

	@Column(name="AWARD_NUM")
	private String awardNum;

	@Column(name="BUDGET_RESERVE_NUM")
	private String budgetReserveNum;

	@Column(name="COMPETITION_NUM")
	private String competitionNum;

	@Column(name="PURCHASE_ORDER_NUM")
	private String purchaseOrderNum;

	@Column(name="SECRET_LETTER_ISSUED_NUM")
	private String secretLetterIssuedNum;

	//bi-directional one-to-one association to PrtsProject
	@OneToOne
	@JoinColumn(name="PROJECT_ID")
	private PrtsProject prtsProject;

	public PrtsProjectPurchase() {
	}

	
	public String getAnotherNum() {
		return this.anotherNum;
	}

	public void setAnotherNum(String anotherNum) {
		this.anotherNum = anotherNum;
	}

	public String getAwardNum() {
		return this.awardNum;
	}

	public void setAwardNum(String awardNum) {
		this.awardNum = awardNum;
	}

	public String getBudgetReserveNum() {
		return this.budgetReserveNum;
	}

	public void setBudgetReserveNum(String budgetReserveNum) {
		this.budgetReserveNum = budgetReserveNum;
	}

	public String getCompetitionNum() {
		return this.competitionNum;
	}

	public void setCompetitionNum(String competitionNum) {
		this.competitionNum = competitionNum;
	}

	public String getPurchaseOrderNum() {
		return this.purchaseOrderNum;
	}

	public void setPurchaseOrderNum(String purchaseOrderNum) {
		this.purchaseOrderNum = purchaseOrderNum;
	}

	public String getSecretLetterIssuedNum() {
		return this.secretLetterIssuedNum;
	}

	public void setSecretLetterIssuedNum(String secretLetterIssuedNum) {
		this.secretLetterIssuedNum = secretLetterIssuedNum;
	}

	public PrtsProject getPrtsProject() {
		return this.prtsProject;
	}

	public void setPrtsProject(PrtsProject prtsProject) {
		this.prtsProject = prtsProject;
	}

}