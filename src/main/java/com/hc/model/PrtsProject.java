package com.hc.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the PRTS_PROJECT database table.
 * 
 */
@Entity
@Table(name="PRTS_PROJECT")
@NamedQuery(name="PrtsProject.findAll", query="SELECT p FROM PrtsProject p")
public class PrtsProject implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRTS_PROJECT_SEQ" )
	@SequenceGenerator(name = "PRTS_PROJECT_SEQ", sequenceName = "PRTS_PROJECT_SEQ", allocationSize = 1)
	@Column(name="PROJECT_ID")
	private long projectId;

	@Column(name="BROCHURES_NUM")
	private BigDecimal brochuresNum;

	@Column(name="INITIATIVE_CODE")
	private BigDecimal initiativeCode;

	@Column(name="PROJECT_CODE")
	private String projectCode;

	@Column(name="PROJECT_DURATION")
	private BigDecimal projectDuration;

	@Column(name="PROJECT_NAME")
	private String projectName;

	@Column(name="PROJECT_NAME_RURAL")
	private String projectNameRural;

	@Column(name="SECTOR_CODE")
	private BigDecimal sectorCode;

	@Column(name="SIDE_CODE")
	private BigDecimal sideCode;

	@Column(name="STAGE_CODE")
	private BigDecimal stageCode;

	@Column(name="TYPE_CODE")
	private BigDecimal typeCode;

	//bi-directional one-to-one association to PrtsProjectDescription
	@OneToOne(mappedBy="prtsProject")
	private PrtsProjectDescription prtsProjectDescription;

	//bi-directional many-to-one association to PrtsProjectDocument
	/*@OneToMany(mappedBy="prtsProject")
	private List<PrtsProjectDocument> prtsProjectDocuments;
*/
	//bi-directional one-to-one association to PrtsProjectEngineeringStudy
	@OneToOne(mappedBy="prtsProject")
	private PrtsProjectEngineeringStudy prtsProjectEngineeringStudy;

	//bi-directional one-to-one association to PrtsProjectFinance
	@OneToOne(mappedBy="prtsProject")
	private PrtsProjectFinance prtsProjectFinance;

	//bi-directional many-to-one association to PrtsProjectNote
	@OneToMany(mappedBy="prtsProject")
	private List<PrtsProjectNote> prtsProjectNotes;

	//bi-directional one-to-one association to PrtsProjectOfferingComponen
	@OneToOne(mappedBy="prtsProject")
	private PrtsProjectOfferingComponen prtsProjectOfferingComponen;

	//bi-directional many-to-one association to PrtsProjectPerson
	@OneToMany(mappedBy="prtsProject")
	private List<PrtsProjectPerson> prtsProjectPersons;

	//bi-directional many-to-one association to PrtsProjectProcedure
	@OneToMany(mappedBy="prtsProject")
	private List<PrtsProjectProcedure> prtsProjectProcedures;

	//bi-directional one-to-one association to PrtsProjectPurchase
	@OneToOne(mappedBy="prtsProject")
	private PrtsProjectPurchase prtsProjectPurchase;

	//bi-directional one-to-one association to PrtsProjectStatus
	@OneToOne(mappedBy="prtsProject")
	private PrtsProjectStatus prtsProjectStatus;

	//bi-directional one-to-one association to PrtsProjectTechnicalStudy
	@OneToOne(mappedBy="prtsProject")
	private PrtsProjectTechnicalStudy prtsProjectTechnicalStudy;

	//bi-directional one-to-one association to PrtsProjectTenderWriting
	@OneToOne(mappedBy="prtsProject")
	private PrtsProjectTenderWriting prtsProjectTenderWriting;

	//bi-directional one-to-one association to PrtsProjectTiming
	@OneToOne(mappedBy="prtsProject")
	private PrtsProjectTiming prtsProjectTiming;

	public PrtsProject() {
	}

	public long getProjectId() {
		return this.projectId;
	}

	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}

	public BigDecimal getBrochuresNum() {
		return this.brochuresNum;
	}

	public void setBrochuresNum(BigDecimal brochuresNum) {
		this.brochuresNum = brochuresNum;
	}

	public BigDecimal getInitiativeCode() {
		return this.initiativeCode;
	}

	public void setInitiativeCode(BigDecimal initiativeCode) {
		this.initiativeCode = initiativeCode;
	}

	public String getProjectCode() {
		return this.projectCode;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	public BigDecimal getProjectDuration() {
		return this.projectDuration;
	}

	public void setProjectDuration(BigDecimal projectDuration) {
		this.projectDuration = projectDuration;
	}

	public String getProjectName() {
		return this.projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectNameRural() {
		return this.projectNameRural;
	}

	public void setProjectNameRural(String projectNameRural) {
		this.projectNameRural = projectNameRural;
	}

	public BigDecimal getSectorCode() {
		return this.sectorCode;
	}

	public void setSectorCode(BigDecimal sectorCode) {
		this.sectorCode = sectorCode;
	}

	public BigDecimal getSideCode() {
		return this.sideCode;
	}

	public void setSideCode(BigDecimal sideCode) {
		this.sideCode = sideCode;
	}

	public BigDecimal getStageCode() {
		return this.stageCode;
	}

	public void setStageCode(BigDecimal stageCode) {
		this.stageCode = stageCode;
	}

	public BigDecimal getTypeCode() {
		return this.typeCode;
	}

	public void setTypeCode(BigDecimal typeCode) {
		this.typeCode = typeCode;
	}

	public PrtsProjectDescription getPrtsProjectDescription() {
		return this.prtsProjectDescription;
	}

	public void setPrtsProjectDescription(PrtsProjectDescription prtsProjectDescription) {
		this.prtsProjectDescription = prtsProjectDescription;
	}

	/*public List<PrtsProjectDocument> getPrtsProjectDocuments() {
		return this.prtsProjectDocuments;
	}

	public void setPrtsProjectDocuments(List<PrtsProjectDocument> prtsProjectDocuments) {
		this.prtsProjectDocuments = prtsProjectDocuments;
	}

	public PrtsProjectDocument addPrtsProjectDocument(PrtsProjectDocument prtsProjectDocument) {
		getPrtsProjectDocuments().add(prtsProjectDocument);
		prtsProjectDocument.setPrtsProject(this);

		return prtsProjectDocument;
	}

	public PrtsProjectDocument removePrtsProjectDocument(PrtsProjectDocument prtsProjectDocument) {
		getPrtsProjectDocuments().remove(prtsProjectDocument);
		prtsProjectDocument.setPrtsProject(null);

		return prtsProjectDocument;
	}
*/
	public PrtsProjectEngineeringStudy getPrtsProjectEngineeringStudy() {
		return this.prtsProjectEngineeringStudy;
	}

	public void setPrtsProjectEngineeringStudy(PrtsProjectEngineeringStudy prtsProjectEngineeringStudy) {
		this.prtsProjectEngineeringStudy = prtsProjectEngineeringStudy;
	}

	public PrtsProjectFinance getPrtsProjectFinance() {
		return this.prtsProjectFinance;
	}

	public void setPrtsProjectFinance(PrtsProjectFinance prtsProjectFinance) {
		this.prtsProjectFinance = prtsProjectFinance;
	}

	public List<PrtsProjectNote> getPrtsProjectNotes() {
		return this.prtsProjectNotes;
	}

	public void setPrtsProjectNotes(List<PrtsProjectNote> prtsProjectNotes) {
		this.prtsProjectNotes = prtsProjectNotes;
	}

	public PrtsProjectNote addPrtsProjectNote(PrtsProjectNote prtsProjectNote) {
		getPrtsProjectNotes().add(prtsProjectNote);
		prtsProjectNote.setPrtsProject(this);

		return prtsProjectNote;
	}

	public PrtsProjectNote removePrtsProjectNote(PrtsProjectNote prtsProjectNote) {
		getPrtsProjectNotes().remove(prtsProjectNote);
		prtsProjectNote.setPrtsProject(null);

		return prtsProjectNote;
	}

	public PrtsProjectOfferingComponen getPrtsProjectOfferingComponen() {
		return this.prtsProjectOfferingComponen;
	}

	public void setPrtsProjectOfferingComponen(PrtsProjectOfferingComponen prtsProjectOfferingComponen) {
		this.prtsProjectOfferingComponen = prtsProjectOfferingComponen;
	}

	public List<PrtsProjectPerson> getPrtsProjectPersons() {
		return this.prtsProjectPersons;
	}

	public void setPrtsProjectPersons(List<PrtsProjectPerson> prtsProjectPersons) {
		this.prtsProjectPersons = prtsProjectPersons;
	}

	public PrtsProjectPerson addPrtsProjectPerson(PrtsProjectPerson prtsProjectPerson) {
		getPrtsProjectPersons().add(prtsProjectPerson);
		prtsProjectPerson.setPrtsProject(this);

		return prtsProjectPerson;
	}

	public PrtsProjectPerson removePrtsProjectPerson(PrtsProjectPerson prtsProjectPerson) {
		getPrtsProjectPersons().remove(prtsProjectPerson);
		prtsProjectPerson.setPrtsProject(null);

		return prtsProjectPerson;
	}

	public List<PrtsProjectProcedure> getPrtsProjectProcedures() {
		return this.prtsProjectProcedures;
	}

	public void setPrtsProjectProcedures(List<PrtsProjectProcedure> prtsProjectProcedures) {
		this.prtsProjectProcedures = prtsProjectProcedures;
	}

	public PrtsProjectProcedure addPrtsProjectProcedure(PrtsProjectProcedure prtsProjectProcedure) {
		getPrtsProjectProcedures().add(prtsProjectProcedure);
		prtsProjectProcedure.setPrtsProject(this);

		return prtsProjectProcedure;
	}

	public PrtsProjectProcedure removePrtsProjectProcedure(PrtsProjectProcedure prtsProjectProcedure) {
		getPrtsProjectProcedures().remove(prtsProjectProcedure);
		prtsProjectProcedure.setPrtsProject(null);

		return prtsProjectProcedure;
	}

	public PrtsProjectPurchase getPrtsProjectPurchase() {
		return this.prtsProjectPurchase;
	}

	public void setPrtsProjectPurchase(PrtsProjectPurchase prtsProjectPurchase) {
		this.prtsProjectPurchase = prtsProjectPurchase;
	}

	public PrtsProjectStatus getPrtsProjectStatus() {
		return this.prtsProjectStatus;
	}

	public void setPrtsProjectStatus(PrtsProjectStatus prtsProjectStatus) {
		this.prtsProjectStatus = prtsProjectStatus;
	}

	public PrtsProjectTechnicalStudy getPrtsProjectTechnicalStudy() {
		return this.prtsProjectTechnicalStudy;
	}

	public void setPrtsProjectTechnicalStudy(PrtsProjectTechnicalStudy prtsProjectTechnicalStudy) {
		this.prtsProjectTechnicalStudy = prtsProjectTechnicalStudy;
	}

	public PrtsProjectTenderWriting getPrtsProjectTenderWriting() {
		return this.prtsProjectTenderWriting;
	}

	public void setPrtsProjectTenderWriting(PrtsProjectTenderWriting prtsProjectTenderWriting) {
		this.prtsProjectTenderWriting = prtsProjectTenderWriting;
	}

	public PrtsProjectTiming getPrtsProjectTiming() {
		return this.prtsProjectTiming;
	}

	public void setPrtsProjectTiming(PrtsProjectTiming prtsProjectTiming) {
		this.prtsProjectTiming = prtsProjectTiming;
	}

}