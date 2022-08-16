package com.hc.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;


/**
 * The persistent class for the EMS_EXPERT_EXPERIENCE database table.
 * 
 */
@Entity
@Table(name="EMS_EXPERT_EXPERIENCE")
@NamedQuery(name="EmsExpertExperience.findAll", query="SELECT e FROM EmsExpertExperience e")
public class EmsExpertExperience implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EmsExpertExperiencePK id;

	@Column(name="EXPERIENCE_DESC")
	private String experienceDesc;

	@Temporal(TemporalType.DATE)
	@Column(name="EXPERIENCE_ENDDATE")
	private Date experienceEnddate;

	@Temporal(TemporalType.DATE)
	@Column(name="EXPERIENCE_STARTDATE")
	private Date experienceStartdate;

	private String industry;

	@Column(name="WORK_NAME")
	private String workName;
	@Column(name="IS_WORKING")
	private Integer IS_WORKING;
	
	@Column(name="LOCATION")
	private String LOCATION;
	
	public String getLOCATION() {
		return LOCATION;
	}

	public void setLOCATION(String lOCATION) {
		LOCATION = lOCATION;
	}

	public Integer getIS_WORKING() {
		return IS_WORKING;
	}

	public void setIS_WORKING(Integer iS_WORKING) {
		IS_WORKING = iS_WORKING;
	}
	//bi-directional many-to-one association to EmsExpert
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="EXPERT_ID", insertable = false, updatable = false)
	private EmsExpert emsExpert;

	//bi-directional many-to-one association to EmsJobCode
	@ManyToOne
	@JoinColumn(name="JOB_ID")
	private EmsJobCode emsJobCode;

	public EmsExpertExperience() {
	}

	public EmsExpertExperiencePK getId() {
		return this.id;
	}

	public void setId(EmsExpertExperiencePK id) {
		this.id = id;
	}

	public String getExperienceDesc() {
		return this.experienceDesc;
	}

	public void setExperienceDesc(String experienceDesc) {
		this.experienceDesc = experienceDesc;
	}

	public Date getExperienceEnddate() {
		return this.experienceEnddate;
	}

	public void setExperienceEnddate(Date experienceEnddate) {
		this.experienceEnddate = experienceEnddate;
	}

	public Date getExperienceStartdate() {
		return this.experienceStartdate;
	}

	public void setExperienceStartdate(Date experienceStartdate) {
		this.experienceStartdate = experienceStartdate;
	}

	public String getIndustry() {
		return this.industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getWorkName() {
		return this.workName;
	}

	public void setWorkName(String workName) {
		this.workName = workName;
	}

	public EmsExpert getEmsExpert() {
		return this.emsExpert;
	}

	public void setEmsExpert(EmsExpert emsExpert) {
		this.emsExpert = emsExpert;
	}

	public EmsJobCode getEmsJobCode() {
		return this.emsJobCode;
	}

	public void setEmsJobCode(EmsJobCode emsJobCode) {
		this.emsJobCode = emsJobCode;
	}

}