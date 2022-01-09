package com.hc.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the EMS_UNIVERSITY_CODE database table.
 * 
 */
@Entity
@Table(name="EMS_UNIVERSITY_CODE")
@NamedQuery(name="EmsUniversityCode.findAll", query="SELECT e FROM EmsUniversityCode e")
public class EmsUniversityCode implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="UNIVERSITY_ID")
	private long universityId;

	@Column(name="UNIVERSITY_NAME_A")
	private String universityNameA;

	@Column(name="UNIVERSITY_NAME_E")
	private String universityNameE;

	//bi-directional many-to-one association to EmsExpertCertificate
	@OneToMany(mappedBy="emsUniversityCode")
	private List<EmsExpertCertificate> emsExpertCertificates;

	//bi-directional many-to-one association to EmsExpertEducation
	@OneToMany(mappedBy="emsUniversityCode")
	private List<EmsExpertEducation> emsExpertEducations;

	//bi-directional many-to-one association to EmsCityCode
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="CITY_ID", referencedColumnName="CITY_ID"),
		@JoinColumn(name="COUNTRY_ID", referencedColumnName="COUNTRY_ID"),
		@JoinColumn(name="GOVERNORATE_ID", referencedColumnName="GOVERNORATE_ID")
		})
	private EmsCityCode emsCityCode;

	public EmsUniversityCode() {
	}

	public long getUniversityId() {
		return this.universityId;
	}

	public void setUniversityId(long universityId) {
		this.universityId = universityId;
	}

	public String getUniversityNameA() {
		return this.universityNameA;
	}

	public void setUniversityNameA(String universityNameA) {
		this.universityNameA = universityNameA;
	}

	public String getUniversityNameE() {
		return this.universityNameE;
	}

	public void setUniversityNameE(String universityNameE) {
		this.universityNameE = universityNameE;
	}

	public List<EmsExpertCertificate> getEmsExpertCertificates() {
		return this.emsExpertCertificates;
	}

	public void setEmsExpertCertificates(List<EmsExpertCertificate> emsExpertCertificates) {
		this.emsExpertCertificates = emsExpertCertificates;
	}

	public EmsExpertCertificate addEmsExpertCertificate(EmsExpertCertificate emsExpertCertificate) {
		getEmsExpertCertificates().add(emsExpertCertificate);
		emsExpertCertificate.setEmsUniversityCode(this);

		return emsExpertCertificate;
	}

	public EmsExpertCertificate removeEmsExpertCertificate(EmsExpertCertificate emsExpertCertificate) {
		getEmsExpertCertificates().remove(emsExpertCertificate);
		emsExpertCertificate.setEmsUniversityCode(null);

		return emsExpertCertificate;
	}

	public List<EmsExpertEducation> getEmsExpertEducations() {
		return this.emsExpertEducations;
	}

	public void setEmsExpertEducations(List<EmsExpertEducation> emsExpertEducations) {
		this.emsExpertEducations = emsExpertEducations;
	}

	public EmsExpertEducation addEmsExpertEducation(EmsExpertEducation emsExpertEducation) {
		getEmsExpertEducations().add(emsExpertEducation);
		emsExpertEducation.setEmsUniversityCode(this);

		return emsExpertEducation;
	}

	public EmsExpertEducation removeEmsExpertEducation(EmsExpertEducation emsExpertEducation) {
		getEmsExpertEducations().remove(emsExpertEducation);
		emsExpertEducation.setEmsUniversityCode(null);

		return emsExpertEducation;
	}

	public EmsCityCode getEmsCityCode() {
		return this.emsCityCode;
	}

	public void setEmsCityCode(EmsCityCode emsCityCode) {
		this.emsCityCode = emsCityCode;
	}

}