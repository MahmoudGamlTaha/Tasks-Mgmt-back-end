package com.hc.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
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
	 @GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="PROJECT_ID")
	private long projectId;

	@Column(name="CONTRACT_STATUS")
	private BigDecimal contractStatus;

	@Column(name="CONTRACTOR_NAME")
	private String contractorName;

	@Column(name="DEPARTMENT_ID")
	private BigDecimal departmentId;

	@Temporal(TemporalType.DATE)
	@Column(name="END_DATE")
	private Date endDate;

	@Column(name="EXECUTION_STATUS")
	private BigDecimal executionStatus;

	@Column(name="EXPERT_NAME")
	private String expertName;

	@Column(name="INITIATIVE_ID")
	private BigDecimal initiativeId;

	@Column(name="PROJECT_CODE")
	private String projectCode;

	@Column(name="PROJECT_NAME")
	private String projectName;

	@Column(name="PROJECT_STATUS")
	private BigDecimal projectStatus;

	@Column(name="REGION_ID")
	private BigDecimal regionId;

	@Temporal(TemporalType.DATE)
	@Column(name="START_DATE")
	private Date startDate;

	@Column(name="TOTAL_AMOUNT")
	private BigDecimal totalAmount;

	@Column(name="WORK_AREA_ID")
	private BigDecimal workAreaId;

	//bi-directional many-to-one association to PrtsProjectItem
//    @Column(insertable=false, updatable=false)
//	@OneToMany(mappedBy="prtsProject")
//	private List<PrtsProjectItem> prtsProjectItems;

	//bi-directional many-to-one association to PrtsProjectManager
//	@OneToMany(mappedBy="prtsProject")
//	private List<PrtsProjectManager> prtsProjectManagers;

	public PrtsProject() {
	}

	public long getProjectId() {
		return this.projectId;
	}

	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}

	public BigDecimal getContractStatus() {
		return this.contractStatus;
	}

	public void setContractStatus(BigDecimal contractStatus) {
		this.contractStatus = contractStatus;
	}

	public String getContractorName() {
		return this.contractorName;
	}

	public void setContractorName(String contractorName) {
		this.contractorName = contractorName;
	}

	public BigDecimal getDepartmentId() {
		return this.departmentId;
	}

	public void setDepartmentId(BigDecimal departmentId) {
		this.departmentId = departmentId;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public BigDecimal getExecutionStatus() {
		return this.executionStatus;
	}

	public void setExecutionStatus(BigDecimal executionStatus) {
		this.executionStatus = executionStatus;
	}

	public String getExpertName() {
		return this.expertName;
	}

	public void setExpertName(String expertName) {
		this.expertName = expertName;
	}

	public BigDecimal getInitiativeId() {
		return this.initiativeId;
	}

	public void setInitiativeId(BigDecimal initiativeId) {
		this.initiativeId = initiativeId;
	}

	public String getProjectCode() {
		return this.projectCode;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	public String getProjectName() {
		return this.projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public BigDecimal getProjectStatus() {
		return this.projectStatus;
	}

	public void setProjectStatus(BigDecimal projectStatus) {
		this.projectStatus = projectStatus;
	}

	public BigDecimal getRegionId() {
		return this.regionId;
	}

	public void setRegionId(BigDecimal regionId) {
		this.regionId = regionId;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public BigDecimal getTotalAmount() {
		return this.totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public BigDecimal getWorkAreaId() {
		return this.workAreaId;
	}

	public void setWorkAreaId(BigDecimal workAreaId) {
		this.workAreaId = workAreaId;
	}

//	public List<PrtsProjectItem> getPrtsProjectItems() {
//		return this.prtsProjectItems;
//	}
//
//	public void setPrtsProjectItems(List<PrtsProjectItem> prtsProjectItems) {
//		this.prtsProjectItems = prtsProjectItems;
//	}
//
//	public PrtsProjectItem addPrtsProjectItem(PrtsProjectItem prtsProjectItem) {
//		getPrtsProjectItems().add(prtsProjectItem);
//		prtsProjectItem.setPrtsProject(this);
//
//		return prtsProjectItem;
//	}
//
//	public PrtsProjectItem removePrtsProjectItem(PrtsProjectItem prtsProjectItem) {
//		getPrtsProjectItems().remove(prtsProjectItem);
//		prtsProjectItem.setPrtsProject(null);
//
//		return prtsProjectItem;
//	}

//	public List<PrtsProjectManager> getPrtsProjectManagers() {
//		return this.prtsProjectManagers;
//	}
//
//	public void setPrtsProjectManagers(List<PrtsProjectManager> prtsProjectManagers) {
//		this.prtsProjectManagers = prtsProjectManagers;
//	}
//
//	public PrtsProjectManager addPrtsProjectManager(PrtsProjectManager prtsProjectManager) {
//		getPrtsProjectManagers().add(prtsProjectManager);
//		prtsProjectManager.setPrtsProject(this);
//
//		return prtsProjectManager;
//	}
//
//	public PrtsProjectManager removePrtsProjectManager(PrtsProjectManager prtsProjectManager) {
//		getPrtsProjectManagers().remove(prtsProjectManager);
//		prtsProjectManager.setPrtsProject(null);
//
//		return prtsProjectManager;
//	}

}