package com.hc.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the EMS_EDUCATION_DEGREE_CODE database table.
 * 
 */
@Entity
@Table(name="EMS_EDUCATION_DEGREE_CODE")
@NamedQuery(name="EmsEducationDegreeCode.findAll", query="SELECT e FROM EmsEducationDegreeCode e")
public class EmsEducationDegreeCode implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="QUAL_CLASS_ID")
	private long qualClassId;

	@Column(name="QUAL_CLASS_NAME_A")
	private String qualClassNameA;

	@Column(name="QUAL_CLASS_NAME_E")
	private String qualClassNameE;

	//bi-directional many-to-one association to EmsExpertEducation
	//@OneToMany(mappedBy="emsEducationDegreeCode")
	//private List<EmsExpertEducation> emsExpertEducations;

	public EmsEducationDegreeCode() {
	}

	public long getQualClassId() {
		return this.qualClassId;
	}

	public void setQualClassId(long qualClassId) {
		this.qualClassId = qualClassId;
	}

	public String getQualClassNameA() {
		return this.qualClassNameA;
	}

	public void setQualClassNameA(String qualClassNameA) {
		this.qualClassNameA = qualClassNameA;
	}

	public String getQualClassNameE() {
		return this.qualClassNameE;
	}

	public void setQualClassNameE(String qualClassNameE) {
		this.qualClassNameE = qualClassNameE;
	}

	//public List<EmsExpertEducation> getEmsExpertEducations() {
	//	return this.emsExpertEducations;
	//}

	//public void setEmsExpertEducations(List<EmsExpertEducation> emsExpertEducations) {
	//	this.emsExpertEducations = emsExpertEducations;
	//}

	//public EmsExpertEducation addEmsExpertEducation(EmsExpertEducation emsExpertEducation) {
	//	getEmsExpertEducations().add(emsExpertEducation);
	//	emsExpertEducation.setEmsEducationDegreeCode(this);

	//	return emsExpertEducation;
	//}

	//public EmsExpertEducation removeEmsExpertEducation(EmsExpertEducation emsExpertEducation) {
	//	getEmsExpertEducations().remove(emsExpertEducation);
	//	emsExpertEducation.setEmsEducationDegreeCode(null);

//		return emsExpertEducation;
//	}

}