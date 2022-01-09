package com.hc.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the EMS_EXPERT_CERTIFICATE database table.
 * 
 */
@Entity
@Table(name="EMS_EXPERT_CERTIFICATE")
@NamedQuery(name="EmsExpertCertificate.findAll", query="SELECT e FROM EmsExpertCertificate e")
public class EmsExpertCertificate implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EmsExpertCertificatePK id;

	@Column(name="CERTIFICATE_DESC")
	private String certificateDesc;

	@Temporal(TemporalType.DATE)
	@Column(name="CERTIFICATE_ENDDATE")
	private Date certificateEnddate;

	@Column(name="CERTIFICATE_LINK")
	private String certificateLink;

	@Column(name="CERTIFICATE_NAME")
	private String certificateName;

	@Column(name="CERTIFICATE_REF_NUMBER")
	private String certificateRefNumber;

	@Temporal(TemporalType.DATE)
	@Column(name="CERTIFICATE_STARTDATE")
	private Date certificateStartdate;

	//bi-directional many-to-one association to EmsExpert
	@ManyToOne
	@JoinColumn(name="EXPERT_ID", insertable = false, updatable = false)
	private EmsExpert emsExpert;

	//bi-directional many-to-one association to EmsUniversityCode
	@ManyToOne
	@JoinColumn(name="UNIVERSITY_ID")
	private EmsUniversityCode emsUniversityCode;

	public EmsExpertCertificate() {
	}

	public EmsExpertCertificatePK getId() {
		return this.id;
	}

	public void setId(EmsExpertCertificatePK id) {
		this.id = id;
	}

	public String getCertificateDesc() {
		return this.certificateDesc;
	}

	public void setCertificateDesc(String certificateDesc) {
		this.certificateDesc = certificateDesc;
	}

	public Date getCertificateEnddate() {
		return this.certificateEnddate;
	}

	public void setCertificateEnddate(Date certificateEnddate) {
		this.certificateEnddate = certificateEnddate;
	}

	public String getCertificateLink() {
		return this.certificateLink;
	}

	public void setCertificateLink(String certificateLink) {
		this.certificateLink = certificateLink;
	}

	public String getCertificateName() {
		return this.certificateName;
	}

	public void setCertificateName(String certificateName) {
		this.certificateName = certificateName;
	}

	public String getCertificateRefNumber() {
		return this.certificateRefNumber;
	}

	public void setCertificateRefNumber(String certificateRefNumber) {
		this.certificateRefNumber = certificateRefNumber;
	}

	public Date getCertificateStartdate() {
		return this.certificateStartdate;
	}

	public void setCertificateStartdate(Date certificateStartdate) {
		this.certificateStartdate = certificateStartdate;
	}

	public EmsExpert getEmsExpert() {
		return this.emsExpert;
	}

	public void setEmsExpert(EmsExpert emsExpert) {
		this.emsExpert = emsExpert;
	}

	public EmsUniversityCode getEmsUniversityCode() {
		return this.emsUniversityCode;
	}

	public void setEmsUniversityCode(EmsUniversityCode emsUniversityCode) {
		this.emsUniversityCode = emsUniversityCode;
	}

}