package com.hc.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

/**
 * The persistent class for the EMS_CITY_CODE database table.
 * 
 */
@Entity
@Table(name = "EMS_CITY_CODE")
@NamedQuery(name = "EmsCityCode.findAll", query = "SELECT e FROM EmsCityCode e")
public class EmsCityCode implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EmsCityCodePK id;

	@Column(name = "CITY_CODE")
	private String cityCode;

	@Column(name = "CITY_NAME_A")
	private String cityNameA;

	@Column(name = "CITY_NAME_E")
	private String cityNameE;

	// bi-directional many-to-one association to EmsGovernorateCode
	@ManyToOne
	@JoinColumns({ @JoinColumn(name = "COUNTRY_ID", referencedColumnName = "COUNTRY_ID" , insertable = false, updatable = false),
			@JoinColumn(name = "GOVERNORATE_ID", referencedColumnName = "GOVERNORATE_ID", insertable = false, updatable = false) })
	private EmsGovernorateCode emsGovernorateCode;

	// bi-directional many-to-one association to EmsExpert
	//@OneToMany(mappedBy = "emsCityCode")
	//private List<EmsExpert> emsExperts;

	// bi-directional many-to-one association to EmsUniversityCode
	@OneToMany(mappedBy = "emsCityCode")
	private List<EmsUniversityCode> emsUniversityCodes;

	public EmsCityCode() {
	}

	public EmsCityCodePK getId() {
		return this.id;
	}

	public void setId(EmsCityCodePK id) {
		this.id = id;
	}

	public String getCityCode() {
		return this.cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getCityNameA() {
		return this.cityNameA;
	}

	public void setCityNameA(String cityNameA) {
		this.cityNameA = cityNameA;
	}

	public String getCityNameE() {
		return this.cityNameE;
	}

	public void setCityNameE(String cityNameE) {
		this.cityNameE = cityNameE;
	}

	public EmsGovernorateCode getEmsGovernorateCode() {
		return this.emsGovernorateCode;
	}

	public void setEmsGovernorateCode(EmsGovernorateCode emsGovernorateCode) {
		this.emsGovernorateCode = emsGovernorateCode;
	}

	//public List<EmsExpert> getEmsExperts() {
	//	return this.emsExperts;
	//}

	//public void setEmsExperts(List<EmsExpert> emsExperts) {
	//	this.emsExperts = emsExperts;
//	}

	//public EmsExpert addEmsExpert(EmsExpert emsExpert) {
	//	getEmsExperts().add(emsExpert);
	//	emsExpert.setEmsCityCode(this);

	//	return emsExpert;
//	}

	//public EmsExpert removeEmsExpert(EmsExpert emsExpert) {
//		getEmsExperts().remove(emsExpert);
	//	emsExpert.setEmsCityCode(null);

		//return emsExpert;
//	}

	public List<EmsUniversityCode> getEmsUniversityCodes() {
		return this.emsUniversityCodes;
	}

	public void setEmsUniversityCodes(List<EmsUniversityCode> emsUniversityCodes) {
		this.emsUniversityCodes = emsUniversityCodes;
	}

	public EmsUniversityCode addEmsUniversityCode(EmsUniversityCode emsUniversityCode) {
		getEmsUniversityCodes().add(emsUniversityCode);
		emsUniversityCode.setEmsCityCode(this);

		return emsUniversityCode;
	}

	public EmsUniversityCode removeEmsUniversityCode(EmsUniversityCode emsUniversityCode) {
		getEmsUniversityCodes().remove(emsUniversityCode);
		emsUniversityCode.setEmsCityCode(null);

		return emsUniversityCode;
	}

}