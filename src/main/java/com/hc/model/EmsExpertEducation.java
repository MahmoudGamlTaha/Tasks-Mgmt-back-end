package com.hc.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the EMS_EXPERT_EDUCATION database table.
 * 
 */
@Entity
@Table(name="EMS_EXPERT_EDUCATION")
@NamedQuery(name="EmsExpertEducation.findAll", query="SELECT e FROM EmsExpertEducation e")
public class EmsExpertEducation implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EmsExpertEducationPK id;

	@Column(name="EDUCATION_DESC")
	private String educationDesc;

	@Temporal(TemporalType.DATE)
	@Column(name="EDUCATION_ENDDATE")
	private Date educationEnddate;

	@Column(name="EDUCATION_RATING")
	private String educationRating;

	@Temporal(TemporalType.DATE)
	@Column(name="EDUCATION_STARTDATE")
	private Date educationStartdate;

	//bi-directional many-to-one association to EmsEducationDegreeCode
	@ManyToOne
	@JoinColumn(name="QUAL_CLASS_ID")
	private EmsEducationDegreeCode emsEducationDegreeCode;

	//bi-directional many-to-one association to EmsExpert
	@ManyToOne
	@JoinColumn(name="EXPERT_ID",insertable = false, updatable = false)
	private EmsExpert emsExpert;

	//bi-directional many-to-one association to EmsStudyFieldCode
	@ManyToOne
	@JoinColumn(name="STUDY_FIELD_ID")
	private EmsStudyFieldCode emsStudyFieldCode;

	//bi-directional many-to-one association to EmsUniversityCode
	@ManyToOne
	@JoinColumn(name="UNIVERSITY_ID")
	private EmsUniversityCode emsUniversityCode;

	public EmsExpertEducation() {
	}

	public EmsExpertEducationPK getId() {
		return this.id;
	}

	public void setId(EmsExpertEducationPK id) {
		this.id = id;
	}

	public String getEducationDesc() {
		return this.educationDesc;
	}

	public void setEducationDesc(String educationDesc) {
		this.educationDesc = educationDesc;
	}

	public Date getEducationEnddate() {
		return this.educationEnddate;
	}

	public void setEducationEnddate(Date educationEnddate) {
		this.educationEnddate = educationEnddate;
	}

	public String getEducationRating() {
		return this.educationRating;
	}

	public void setEducationRating(String educationRating) {
		this.educationRating = educationRating;
	}

	public Date getEducationStartdate() {
		return this.educationStartdate;
	}

	public void setEducationStartdate(Date educationStartdate) {
		this.educationStartdate = educationStartdate;
	}

	public EmsEducationDegreeCode getEmsEducationDegreeCode() {
		return this.emsEducationDegreeCode;
	}

	public void setEmsEducationDegreeCode(EmsEducationDegreeCode emsEducationDegreeCode) {
		this.emsEducationDegreeCode = emsEducationDegreeCode;
	}

	public EmsExpert getEmsExpert() {
		return this.emsExpert;
	}

	public void setEmsExpert(EmsExpert emsExpert) {
		this.emsExpert = emsExpert;
	}

	public EmsStudyFieldCode getEmsStudyFieldCode() {
		return this.emsStudyFieldCode;
	}

	public void setEmsStudyFieldCode(EmsStudyFieldCode emsStudyFieldCode) {
		this.emsStudyFieldCode = emsStudyFieldCode;
	}

	public EmsUniversityCode getEmsUniversityCode() {
		return this.emsUniversityCode;
	}

	public void setEmsUniversityCode(EmsUniversityCode emsUniversityCode) {
		this.emsUniversityCode = emsUniversityCode;
	}

}