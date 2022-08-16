package com.hc.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the PRTS_PROJECT_OFFERING_COMPONEN database table.
 * 
 */
@Entity
@Table(name="PRTS_PROJECT_OFFERING_COMPONEN")
@NamedQuery(name="PrtsProjectOfferingComponen.findAll", query="SELECT p FROM PrtsProjectOfferingComponen p")
public class PrtsProjectOfferingComponen implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="PROJECT_ID", insertable = false, updatable = false)
	private long PROJECT_ID;

	@Temporal(TemporalType.DATE)
	@Column(name="DOC_ACTUALDATE")
	private Date docActualdate;

	@Temporal(TemporalType.DATE)
	@Column(name="DOC_PLANDATE")
	private Date docPlandate;

	@Temporal(TemporalType.DATE)
	@Column(name="ENGINEER_ACTUALDATE")
	private Date engineerActualdate;

	@Temporal(TemporalType.DATE)
	@Column(name="ENGINEER_PLANDATE")
	private Date engineerPlandate;

	@Column(name="ENGINEER_STUDY_APPROVAL")
	private BigDecimal engineerStudyApproval;

	@Temporal(TemporalType.DATE)
	@Column(name="LAND_ALLOCATE_ACTUALDATE")
	private Date landAllocateActualdate;

	@Temporal(TemporalType.DATE)
	@Column(name="LAND_ALLOCATE_PLANDATE")
	private Date landAllocatePlandate;

	@Column(name="LAND_ALLOCATION")
	private BigDecimal landAllocation;

	@Temporal(TemporalType.DATE)
	@Column(name="NATIONAL_ACTUALDATE")
	private Date nationalActualdate;

	@Column(name="NATIONAL_DIRECTOR_APPROVAL")
	private BigDecimal nationalDirectorApproval;

	@Temporal(TemporalType.DATE)
	@Column(name="NATIONAL_PLANDATE")
	private Date nationalPlandate;

	@Temporal(TemporalType.DATE)
	@Column(name="OWNER_ACTAULDATE")
	private Date ownerActauldate;

	@Column(name="OWNER_APPROVAL")
	private BigDecimal ownerApproval;

	@Temporal(TemporalType.DATE)
	@Column(name="OWNER_PLANDATE")
	private Date ownerPlandate;

	@Temporal(TemporalType.DATE)
	@Column(name="PROGRAM_ACTUALDATE")
	private Date programActualdate;

	@Column(name="PROGRAM_APPROVAL")
	private BigDecimal programApproval;

	@Temporal(TemporalType.DATE)
	@Column(name="PROGRAM_PLANDATE")
	private Date programPlandate;

	@Column(name="PROJECT_DOCUMENT_APPROVAL")
	private BigDecimal projectDocumentApproval;

	@Temporal(TemporalType.DATE)
	@Column(name="TECHNICAL_ACTUALDATE")
	private Date technicalActualdate;

	@Temporal(TemporalType.DATE)
	@Column(name="TECHNICAL_PLANDATE")
	private Date technicalPlandate;

	@Column(name="TECHNICAL_STUDY_APPROVAL")
	private BigDecimal technicalStudyApproval;

	@Temporal(TemporalType.DATE)
	@Column(name="TENDER_ACTUALDATE")
	private Date tenderActualdate;

	@Column(name="TENDER_APPROVAL")
	private BigDecimal tenderApproval;

	@Temporal(TemporalType.DATE)
	@Column(name="TENDER_PLANDATE")
	private Date tenderPlandate;

	//bi-directional one-to-one association to PrtsProject
	@JsonIgnore
	@OneToOne
	@JoinColumn(name="PROJECT_ID", insertable = false, updatable = false)
	private PrtsProject prtsProject;

	public PrtsProjectOfferingComponen() {
	}

	public Date getDocActualdate() {
		return this.docActualdate;
	}

	public void setDocActualdate(Date docActualdate) {
		this.docActualdate = docActualdate;
	}

	public Date getDocPlandate() {
		return this.docPlandate;
	}

	public void setDocPlandate(Date docPlandate) {
		this.docPlandate = docPlandate;
	}

	public Date getEngineerActualdate() {
		return this.engineerActualdate;
	}

	public void setEngineerActualdate(Date engineerActualdate) {
		this.engineerActualdate = engineerActualdate;
	}

	public Date getEngineerPlandate() {
		return this.engineerPlandate;
	}

	public void setEngineerPlandate(Date engineerPlandate) {
		this.engineerPlandate = engineerPlandate;
	}

	public BigDecimal getEngineerStudyApproval() {
		return this.engineerStudyApproval;
	}

	public void setEngineerStudyApproval(BigDecimal engineerStudyApproval) {
		this.engineerStudyApproval = engineerStudyApproval;
	}

	public Date getLandAllocateActualdate() {
		return this.landAllocateActualdate;
	}

	public void setLandAllocateActualdate(Date landAllocateActualdate) {
		this.landAllocateActualdate = landAllocateActualdate;
	}

	public Date getLandAllocatePlandate() {
		return this.landAllocatePlandate;
	}

	public void setLandAllocatePlandate(Date landAllocatePlandate) {
		this.landAllocatePlandate = landAllocatePlandate;
	}

	public BigDecimal getLandAllocation() {
		return this.landAllocation;
	}

	public void setLandAllocation(BigDecimal landAllocation) {
		this.landAllocation = landAllocation;
	}

	public Date getNationalActualdate() {
		return this.nationalActualdate;
	}

	public void setNationalActualdate(Date nationalActualdate) {
		this.nationalActualdate = nationalActualdate;
	}

	public BigDecimal getNationalDirectorApproval() {
		return this.nationalDirectorApproval;
	}

	public void setNationalDirectorApproval(BigDecimal nationalDirectorApproval) {
		this.nationalDirectorApproval = nationalDirectorApproval;
	}

	public Date getNationalPlandate() {
		return this.nationalPlandate;
	}

	public void setNationalPlandate(Date nationalPlandate) {
		this.nationalPlandate = nationalPlandate;
	}

	public Date getOwnerActauldate() {
		return this.ownerActauldate;
	}

	public void setOwnerActauldate(Date ownerActauldate) {
		this.ownerActauldate = ownerActauldate;
	}

	public BigDecimal getOwnerApproval() {
		return this.ownerApproval;
	}

	public void setOwnerApproval(BigDecimal ownerApproval) {
		this.ownerApproval = ownerApproval;
	}

	public Date getOwnerPlandate() {
		return this.ownerPlandate;
	}

	public void setOwnerPlandate(Date ownerPlandate) {
		this.ownerPlandate = ownerPlandate;
	}

	public Date getProgramActualdate() {
		return this.programActualdate;
	}

	public void setProgramActualdate(Date programActualdate) {
		this.programActualdate = programActualdate;
	}

	public BigDecimal getProgramApproval() {
		return this.programApproval;
	}

	public void setProgramApproval(BigDecimal programApproval) {
		this.programApproval = programApproval;
	}

	public Date getProgramPlandate() {
		return this.programPlandate;
	}

	public void setProgramPlandate(Date programPlandate) {
		this.programPlandate = programPlandate;
	}

	public BigDecimal getProjectDocumentApproval() {
		return this.projectDocumentApproval;
	}

	public void setProjectDocumentApproval(BigDecimal projectDocumentApproval) {
		this.projectDocumentApproval = projectDocumentApproval;
	}

	public Date getTechnicalActualdate() {
		return this.technicalActualdate;
	}

	public void setTechnicalActualdate(Date technicalActualdate) {
		this.technicalActualdate = technicalActualdate;
	}

	public Date getTechnicalPlandate() {
		return this.technicalPlandate;
	}

	public void setTechnicalPlandate(Date technicalPlandate) {
		this.technicalPlandate = technicalPlandate;
	}

	public BigDecimal getTechnicalStudyApproval() {
		return this.technicalStudyApproval;
	}

	public void setTechnicalStudyApproval(BigDecimal technicalStudyApproval) {
		this.technicalStudyApproval = technicalStudyApproval;
	}

	public Date getTenderActualdate() {
		return this.tenderActualdate;
	}

	public void setTenderActualdate(Date tenderActualdate) {
		this.tenderActualdate = tenderActualdate;
	}

	public BigDecimal getTenderApproval() {
		return this.tenderApproval;
	}

	public void setTenderApproval(BigDecimal tenderApproval) {
		this.tenderApproval = tenderApproval;
	}

	public Date getTenderPlandate() {
		return this.tenderPlandate;
	}

	public void setTenderPlandate(Date tenderPlandate) {
		this.tenderPlandate = tenderPlandate;
	}

	public PrtsProject getPrtsProject() {
		return this.prtsProject;
	}

	public void setPrtsProject(PrtsProject prtsProject) {
		this.prtsProject = prtsProject;
	}

}