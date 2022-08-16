package com.hc.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the EMS_GOVERNORATE_CODE database table.
 * 
 */
@Entity
@Table(name="EMS_GOVERNORATE_CODE")
@NamedQuery(name="EmsGovernorateCode.findAll", query="SELECT e FROM EmsGovernorateCode e")
public class EmsGovernorateCode implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EmsGovernorateCodePK id;

	@Column(name="GOVERNORATE_CODE")
	private String governorateCode;

	@Column(name="GOVERNORATE_NAME_A")
	private String governorateNameA;

	@Column(name="GOVERNORATE_NAME_E")
	private String governorateNameE;

	//bi-directional many-to-one association to EmsCityCode
	@JsonIgnore
	@OneToMany(mappedBy="emsGovernorateCode")
	private List<EmsCityCode> emsCityCodes;

	//bi-directional many-to-one association to EmsCountryCode
	@ManyToOne
	@JoinColumn(name="COUNTRY_ID" , insertable = false, updatable = false)
	private EmsCountryCode emsCountryCode;

	public EmsGovernorateCode() {
	}

	public EmsGovernorateCodePK getId() {
		return this.id;
	}

	public void setId(EmsGovernorateCodePK id) {
		this.id = id;
	}

	public String getGovernorateCode() {
		return this.governorateCode;
	}

	public void setGovernorateCode(String governorateCode) {
		this.governorateCode = governorateCode;
	}

	public String getGovernorateNameA() {
		return this.governorateNameA;
	}

	public void setGovernorateNameA(String governorateNameA) {
		this.governorateNameA = governorateNameA;
	}

	public String getGovernorateNameE() {
		return this.governorateNameE;
	}

	public void setGovernorateNameE(String governorateNameE) {
		this.governorateNameE = governorateNameE;
	}

	public List<EmsCityCode> getEmsCityCodes() {
		return this.emsCityCodes;
	}

	public void setEmsCityCodes(List<EmsCityCode> emsCityCodes) {
		this.emsCityCodes = emsCityCodes;
	}

	public EmsCityCode addEmsCityCode(EmsCityCode emsCityCode) {
		getEmsCityCodes().add(emsCityCode);
		emsCityCode.setEmsGovernorateCode(this);

		return emsCityCode;
	}

	public EmsCityCode removeEmsCityCode(EmsCityCode emsCityCode) {
		getEmsCityCodes().remove(emsCityCode);
		emsCityCode.setEmsGovernorateCode(null);

		return emsCityCode;
	}

	public EmsCountryCode getEmsCountryCode() {
		return this.emsCountryCode;
	}

	public void setEmsCountryCode(EmsCountryCode emsCountryCode) {
		this.emsCountryCode = emsCountryCode;
	}

}