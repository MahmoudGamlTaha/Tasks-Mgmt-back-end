package com.hc.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the EMS_COUNTRY_CODE database table.
 * 
 */
@Entity
@Table(name="EMS_COUNTRY_CODE")
@NamedQuery(name="EmsCountryCode.findAll", query="SELECT e FROM EmsCountryCode e")
public class EmsCountryCode implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="COUNTRY_ID")
	private long countryId;

	@Column(name="COUNTRY_CODE")
	private String countryCode;

	@Column(name="COUNTRY_NAME_A")
	private String countryNameA;

	@Column(name="COUNTRY_NAME_E")
	private String countryNameE;

	//bi-directional many-to-one association to EmsExpert
	@OneToMany(mappedBy="emsCountryCode")
	private List<EmsExpert> emsExperts;

	//bi-directional many-to-one association to EmsGovernorateCode
	@OneToMany(mappedBy="emsCountryCode")
	private List<EmsGovernorateCode> emsGovernorateCodes;

	public EmsCountryCode() {
	}

	public long getCountryId() {
		return this.countryId;
	}

	public void setCountryId(long countryId) {
		this.countryId = countryId;
	}

	public String getCountryCode() {
		return this.countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountryNameA() {
		return this.countryNameA;
	}

	public void setCountryNameA(String countryNameA) {
		this.countryNameA = countryNameA;
	}

	public String getCountryNameE() {
		return this.countryNameE;
	}

	public void setCountryNameE(String countryNameE) {
		this.countryNameE = countryNameE;
	}

	public List<EmsExpert> getEmsExperts() {
		return this.emsExperts;
	}

	public void setEmsExperts(List<EmsExpert> emsExperts) {
		this.emsExperts = emsExperts;
	}

	public EmsExpert addEmsExpert(EmsExpert emsExpert) {
		getEmsExperts().add(emsExpert);
		emsExpert.setEmsCountryCode(this);

		return emsExpert;
	}

	public EmsExpert removeEmsExpert(EmsExpert emsExpert) {
		getEmsExperts().remove(emsExpert);
		emsExpert.setEmsCountryCode(null);

		return emsExpert;
	}

	public List<EmsGovernorateCode> getEmsGovernorateCodes() {
		return this.emsGovernorateCodes;
	}

	public void setEmsGovernorateCodes(List<EmsGovernorateCode> emsGovernorateCodes) {
		this.emsGovernorateCodes = emsGovernorateCodes;
	}

	public EmsGovernorateCode addEmsGovernorateCode(EmsGovernorateCode emsGovernorateCode) {
		getEmsGovernorateCodes().add(emsGovernorateCode);
		emsGovernorateCode.setEmsCountryCode(this);

		return emsGovernorateCode;
	}

	public EmsGovernorateCode removeEmsGovernorateCode(EmsGovernorateCode emsGovernorateCode) {
		getEmsGovernorateCodes().remove(emsGovernorateCode);
		emsGovernorateCode.setEmsCountryCode(null);

		return emsGovernorateCode;
	}

}