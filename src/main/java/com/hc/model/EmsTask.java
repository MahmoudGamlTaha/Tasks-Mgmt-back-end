package com.hc.model;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.Formula;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the EMS_TASK database table.
 * 
 */
@Entity
@Table(name="EMS_TASK")
@NamedQuery(name="EmsTask.findAll", query="SELECT e FROM EmsTask e")
public class EmsTask implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EmsTaskPK id;

	@Column(name="TASK_ACTUAL_HOUR")
	private BigDecimal taskActualHour;

	@Column(name="TASK_ACTUAL_MINUTE")
	private BigDecimal taskActualMinute;

	@Temporal(TemporalType.DATE)
	@Column(name="TASK_CREATE_DATE")
	private Date taskCreateDate;

	@Column(name="TASK_DESC")
	private String taskDesc;

	@Temporal(TemporalType.DATE)
	@Column(name="TASK_EXPECTED_DATE")
	private Date taskExpectedDate;

	@Column(name="TASK_EXPECTED_HOUR")
	private BigDecimal taskExpectedHour;

	@Column(name="TASK_EXPECTED_MINUTE")
	private BigDecimal taskExpectedMinute;

	@Column(name="TASK_NAME")
	private String taskName;

	@Column(name="USER_ID")
	private BigDecimal userId;
	
	public String getTaskIdParent() {
		return taskIdParent;
	}


	public void setTaskIdParent(String taskIdParent) {
		this.taskIdParent = taskIdParent;
	}

	@Column(name="CREATED_BY",updatable=false, insertable=false)
	private String createdBy;
    
	@Column(name="TASK_ID_PARENT",updatable=false, insertable=false)
	private String taskIdParent;
	//bi-directional many-to-one association to EmsFinancialRequestDtl
	//@OneToMany(mappedBy="emsTask")
	//private List<EmsFinancialRequestDtl> emsFinancialRequestDtls;

	
	public String getCreatedBy() {
		return createdBy;
	}

	
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	//bi-directional many-to-one association to EmsExpert
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="EXPERT_ID")
	private EmsExpert emsExpert;

	//bi-directional many-to-one association to EmsTask
	@JsonIgnore
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="PROJECT_ID_PARENT", referencedColumnName="PROJECT_ID"),
		@JoinColumn(name="TASK_ID_PARENT", referencedColumnName="TASK_ID")
		})
	private EmsTask emsTask;

	
	
	//bi-directional many-to-one association to EmsTask
	@OneToMany(mappedBy="emsTask")
	private List<EmsTask> emsTasks;

	//bi-directional many-to-one association to EmsTaskStatusCode
	@ManyToOne
	@JoinColumn(name="TASK_STATUS_ID")
	private EmsTaskStatusCode emsTaskStatusCode;

	//bi-directional many-to-one association to EmsTaskComment
	@OneToMany(mappedBy="emsTask")
	private List<EmsTaskComment> emsTaskComments;

	//bi-directional many-to-one association to EmsTaskDocument
	@OneToMany(mappedBy="emsTask")
	private List<EmsTaskDocument> emsTaskDocuments;

	public EmsTask() {
	}

	public EmsTaskPK getId() {
		return this.id;
	}

	public void setId(EmsTaskPK id) {
		this.id = id;
	}

	public BigDecimal getTaskActualHour() {
		return this.taskActualHour;
	}

	public void setTaskActualHour(BigDecimal taskActualHour) {
		this.taskActualHour = taskActualHour;
	}

	public BigDecimal getTaskActualMinute() {
		return this.taskActualMinute;
	}

	public void setTaskActualMinute(BigDecimal taskActualMinute) {
		this.taskActualMinute = taskActualMinute;
	}

	public Date getTaskCreateDate() {
		return this.taskCreateDate;
	}

	public void setTaskCreateDate(Date taskCreateDate) {
		this.taskCreateDate = taskCreateDate;
	}

	public String getTaskDesc() {
		return this.taskDesc;
	}

	public void setTaskDesc(String taskDesc) {
		this.taskDesc = taskDesc;
	}

	public Date getTaskExpectedDate() {
		return this.taskExpectedDate;
	}

	public void setTaskExpectedDate(Date taskExpectedDate) {
		this.taskExpectedDate = taskExpectedDate;
	}

	public BigDecimal getTaskExpectedHour() {
		return this.taskExpectedHour;
	}

	public void setTaskExpectedHour(BigDecimal taskExpectedHour) {
		this.taskExpectedHour = taskExpectedHour;
	}

	public BigDecimal getTaskExpectedMinute() {
		return this.taskExpectedMinute;
	}

	public void setTaskExpectedMinute(BigDecimal taskExpectedMinute) {
		this.taskExpectedMinute = taskExpectedMinute;
	}

	public String getTaskName() {
		return this.taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public BigDecimal getUserId() {
		return this.userId;
	}

	public void setUserId(BigDecimal userId) {
		this.userId = userId;
	}

//	public List<EmsFinancialRequestDtl> getEmsFinancialRequestDtls() {
//		return this.emsFinancialRequestDtls;
//	}
//
//	public void setEmsFinancialRequestDtls(List<EmsFinancialRequestDtl> emsFinancialRequestDtls) {
//		this.emsFinancialRequestDtls = emsFinancialRequestDtls;
//	}
//
//	public EmsFinancialRequestDtl addEmsFinancialRequestDtl(EmsFinancialRequestDtl emsFinancialRequestDtl) {
//		getEmsFinancialRequestDtls().add(emsFinancialRequestDtl);
//		emsFinancialRequestDtl.setEmsTask(this);
//
//		return emsFinancialRequestDtl;
//	}
//
//	public EmsFinancialRequestDtl removeEmsFinancialRequestDtl(EmsFinancialRequestDtl emsFinancialRequestDtl) {
//		getEmsFinancialRequestDtls().remove(emsFinancialRequestDtl);
//		emsFinancialRequestDtl.setEmsTask(null);
//
//		return emsFinancialRequestDtl;
//	}
//
	public EmsExpert getEmsExpert() {
		return this.emsExpert;
	}

	public void setEmsExpert(EmsExpert emsExpert) {
		this.emsExpert = emsExpert;
	}

	public EmsTask getEmsTask() {
		return this.emsTask;
	}

	public void setEmsTask(EmsTask emsTask) {
		this.emsTask = emsTask;
	}

	public List<EmsTask> getEmsTasks() {
		return this.emsTasks;
	}

	public void setEmsTasks(List<EmsTask> emsTasks) {
		this.emsTasks = emsTasks;
	}

	public EmsTask addEmsTask(EmsTask emsTask) {
		getEmsTasks().add(emsTask);
		emsTask.setEmsTask(this);

		return emsTask;
	}

	public EmsTask removeEmsTask(EmsTask emsTask) {
		getEmsTasks().remove(emsTask);
		emsTask.setEmsTask(null);

		return emsTask;
	}

	public EmsTaskStatusCode getEmsTaskStatusCode() {
		return this.emsTaskStatusCode;
	}

	public void setEmsTaskStatusCode(EmsTaskStatusCode emsTaskStatusCode) {
		this.emsTaskStatusCode = emsTaskStatusCode;
	}

	public List<EmsTaskComment> getEmsTaskComments() {
		return this.emsTaskComments;
	}

	public void setEmsTaskComments(List<EmsTaskComment> emsTaskComments) {
		this.emsTaskComments = emsTaskComments;
	}

	public EmsTaskComment addEmsTaskComment(EmsTaskComment emsTaskComment) {
		getEmsTaskComments().add(emsTaskComment);
		emsTaskComment.setEmsTask(this);

		return emsTaskComment;
	}

	public EmsTaskComment removeEmsTaskComment(EmsTaskComment emsTaskComment) {
		getEmsTaskComments().remove(emsTaskComment);
		emsTaskComment.setEmsTask(null);

		return emsTaskComment;
	}

	public List<EmsTaskDocument> getEmsTaskDocuments() {
		return this.emsTaskDocuments;
	}

	public void setEmsTaskDocuments(List<EmsTaskDocument> emsTaskDocuments) {
		this.emsTaskDocuments = emsTaskDocuments;
	}

	public EmsTaskDocument addEmsTaskDocument(EmsTaskDocument emsTaskDocument) {
		getEmsTaskDocuments().add(emsTaskDocument);
		emsTaskDocument.setEmsTask(this);

		return emsTaskDocument;
	}

	public EmsTaskDocument removeEmsTaskDocument(EmsTaskDocument emsTaskDocument) {
		getEmsTaskDocuments().remove(emsTaskDocument);
		emsTaskDocument.setEmsTask(null);

		return emsTaskDocument;
	}

}