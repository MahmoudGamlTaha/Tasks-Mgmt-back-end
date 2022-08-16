package com.hc.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the EMS_STUDY_FIELD_CODE database table.
 * 
 */
@Entity
@Table(name="EMS_STUDY_FIELD_CODE")
@NamedQuery(name="EmsStudyFieldCode.findAll", query="SELECT e FROM EmsStudyFieldCode e")
public class EmsStudyFieldCode implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="STUDY_FIELD_ID")
	private long studyFieldId;

	@Column(name="STUDY_FIELD_NAME_A")
	private String studyFieldNameA;

	@Column(name="STUDY_FIELD_NAME_E")
	private String studyFieldNameE;

	//bi-directional many-to-one association to EmsExpertEducation
	//@OneToMany(mappedBy="emsStudyFieldCode")
	//private List<EmsExpertEducation> emsExpertEducations;

	public EmsStudyFieldCode() {
	}

	public long getStudyFieldId() {
		return this.studyFieldId;
	}

	public void setStudyFieldId(long studyFieldId) {
		this.studyFieldId = studyFieldId;
	}

	public String getStudyFieldNameA() {
		return this.studyFieldNameA;
	}

	public void setStudyFieldNameA(String studyFieldNameA) {
		this.studyFieldNameA = studyFieldNameA;
	}

	public String getStudyFieldNameE() {
		return this.studyFieldNameE;
	}

	public void setStudyFieldNameE(String studyFieldNameE) {
		this.studyFieldNameE = studyFieldNameE;
	}

	/*public List<EmsExpertEducation> getEmsExpertEducations() {
		return this.emsExpertEducations;
	}

	public void setEmsExpertEducations(List<EmsExpertEducation> emsExpertEducations) {
		this.emsExpertEducations = emsExpertEducations;
	}

	public EmsExpertEducation addEmsExpertEducation(EmsExpertEducation emsExpertEducation) {
		getEmsExpertEducations().add(emsExpertEducation);
		emsExpertEducation.setEmsStudyFieldCode(this);

		return emsExpertEducation;
	}

	public EmsExpertEducation removeEmsExpertEducation(EmsExpertEducation emsExpertEducation) {
		getEmsExpertEducations().remove(emsExpertEducation);
		emsExpertEducation.setEmsStudyFieldCode(null);

		return emsExpertEducation;
	}*/

}