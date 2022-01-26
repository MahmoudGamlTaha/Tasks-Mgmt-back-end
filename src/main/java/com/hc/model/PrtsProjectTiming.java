package com.hc.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the PRTS_PROJECT_TIMING database table.
 * 
 */
@Entity
@Table(name="PRTS_PROJECT_TIMING")
@NamedQuery(name="PrtsProjectTiming.findAll", query="SELECT p FROM PrtsProjectTiming p")
public class PrtsProjectTiming  {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="fake_Id", insertable = false, updatable = false)
	private long fakeId;

	@Temporal(TemporalType.DATE)
	@Column(name="ACTUAL_AWARD_DATE")
	private Date actualAwardDate;

	@Temporal(TemporalType.DATE)
	@Column(name="ACTUAL_CONFIDENTIAL_LETTER")
	private Date actualConfidentialLetter;

	@Temporal(TemporalType.DATE)
	@Column(name="ACTUAL_CONTRACT_DATE")
	private Date actualContractDate;

	@Temporal(TemporalType.DATE)
	@Column(name="ACTUAL_DECISION_DATE")
	private Date actualDecisionDate;

	@Temporal(TemporalType.DATE)
	@Column(name="ACTUAL_OFFERING_DATE")
	private Date actualOfferingDate;

	@Temporal(TemporalType.DATE)
	@Column(name="ACTUAL_OPENING_DATE")
	private Date actualOpeningDate;

	@Temporal(TemporalType.DATE)
	@Column(name="ACTUAL_RECEIVING_OFFERS")
	private Date actualReceivingOffers;

	@Temporal(TemporalType.DATE)
	@Column(name="ACTUAL_SITE_RECEIPT_DATE")
	private Date actualSiteReceiptDate;

	@Temporal(TemporalType.DATE)
	@Column(name="PLAN_AWARD_DATE")
	private Date planAwardDate;

	@Temporal(TemporalType.DATE)
	@Column(name="PLAN_CONFIDENTIAL_LETTER")
	private Date planConfidentialLetter;

	@Temporal(TemporalType.DATE)
	@Column(name="PLAN_CONTRACT_DATE")
	private Date planContractDate;

	@Temporal(TemporalType.DATE)
	@Column(name="PLAN_DECISION_DATE")
	private Date planDecisionDate;

	@Temporal(TemporalType.DATE)
	@Column(name="PLAN_OFFERING_DATE")
	private Date planOfferingDate;

	@Temporal(TemporalType.DATE)
	@Column(name="PLAN_OPENING_DATE")
	private Date planOpeningDate;

	@Temporal(TemporalType.DATE)
	@Column(name="PLAN_RECEIVING_OFFERS")
	private Date planReceivingOffers;

	@Temporal(TemporalType.DATE)
	@Column(name="PLAN_SITE_RECEIPT_DATE")
	private Date planSiteReceiptDate;

	//bi-directional one-to-one association to PrtsProject
	@OneToOne
	@JoinColumn(name="PROJECT_ID")
	private PrtsProject prtsProject;

	public PrtsProjectTiming() {
	}


	public Date getActualAwardDate() {
		return this.actualAwardDate;
	}

	public void setActualAwardDate(Date actualAwardDate) {
		this.actualAwardDate = actualAwardDate;
	}

	public Date getActualConfidentialLetter() {
		return this.actualConfidentialLetter;
	}

	public void setActualConfidentialLetter(Date actualConfidentialLetter) {
		this.actualConfidentialLetter = actualConfidentialLetter;
	}

	public Date getActualContractDate() {
		return this.actualContractDate;
	}

	public void setActualContractDate(Date actualContractDate) {
		this.actualContractDate = actualContractDate;
	}

	public Date getActualDecisionDate() {
		return this.actualDecisionDate;
	}

	public void setActualDecisionDate(Date actualDecisionDate) {
		this.actualDecisionDate = actualDecisionDate;
	}

	public Date getActualOfferingDate() {
		return this.actualOfferingDate;
	}

	public void setActualOfferingDate(Date actualOfferingDate) {
		this.actualOfferingDate = actualOfferingDate;
	}

	public Date getActualOpeningDate() {
		return this.actualOpeningDate;
	}

	public void setActualOpeningDate(Date actualOpeningDate) {
		this.actualOpeningDate = actualOpeningDate;
	}

	public Date getActualReceivingOffers() {
		return this.actualReceivingOffers;
	}

	public void setActualReceivingOffers(Date actualReceivingOffers) {
		this.actualReceivingOffers = actualReceivingOffers;
	}

	public Date getActualSiteReceiptDate() {
		return this.actualSiteReceiptDate;
	}

	public void setActualSiteReceiptDate(Date actualSiteReceiptDate) {
		this.actualSiteReceiptDate = actualSiteReceiptDate;
	}

	public Date getPlanAwardDate() {
		return this.planAwardDate;
	}

	public void setPlanAwardDate(Date planAwardDate) {
		this.planAwardDate = planAwardDate;
	}

	public Date getPlanConfidentialLetter() {
		return this.planConfidentialLetter;
	}

	public void setPlanConfidentialLetter(Date planConfidentialLetter) {
		this.planConfidentialLetter = planConfidentialLetter;
	}

	public Date getPlanContractDate() {
		return this.planContractDate;
	}

	public void setPlanContractDate(Date planContractDate) {
		this.planContractDate = planContractDate;
	}

	public Date getPlanDecisionDate() {
		return this.planDecisionDate;
	}

	public void setPlanDecisionDate(Date planDecisionDate) {
		this.planDecisionDate = planDecisionDate;
	}

	public Date getPlanOfferingDate() {
		return this.planOfferingDate;
	}

	public void setPlanOfferingDate(Date planOfferingDate) {
		this.planOfferingDate = planOfferingDate;
	}

	public Date getPlanOpeningDate() {
		return this.planOpeningDate;
	}

	public void setPlanOpeningDate(Date planOpeningDate) {
		this.planOpeningDate = planOpeningDate;
	}

	public Date getPlanReceivingOffers() {
		return this.planReceivingOffers;
	}

	public void setPlanReceivingOffers(Date planReceivingOffers) {
		this.planReceivingOffers = planReceivingOffers;
	}

	public Date getPlanSiteReceiptDate() {
		return this.planSiteReceiptDate;
	}

	public void setPlanSiteReceiptDate(Date planSiteReceiptDate) {
		this.planSiteReceiptDate = planSiteReceiptDate;
	}

	public PrtsProject getPrtsProject() {
		return this.prtsProject;
	}

	public void setPrtsProject(PrtsProject prtsProject) {
		this.prtsProject = prtsProject;
	}

}