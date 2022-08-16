package com.hc.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Clob;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the EMS_EXPERT database table.
 * 
 */
@Entity
@Table(name="EMS_EXPERT")
@NamedQuery(name="EmsExpert.findAll", query="SELECT e FROM EmsExpert e")
public class EmsExpert implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="EXPERT_ID")
	private long expertId;

	private String biography;

	@Column(name="CURRENT_ADDRESS")
	private String currentAddress;

	@Lob
	@Column(name="CURRICULUM_VITAE_FILE")
	private byte[] curriculumVitaeFile;

	
	
	@Column(name="EXPERT_EMAIL")
	private String expertEmail;

	@Column(name="EXPERT_MOBIL_1")
	private String expertMobil1;

	@Column(name="EXPERT_MOBIL_2")
	private String expertMobil2;

	@Column(name="EXPERT_NAME_A")
	private String expertNameA;

	@Column(name="EXPERT_NAME_E")
	private String expertNameE;

	@Column(name="EXPERT_SHORT_NAME")
	private String expertShortName;
    
	public String getExpertUserName() {
		return expertUserName;
	}

	public void setExpertUserName(String expertUserName) {
		this.expertUserName = expertUserName;
	}

	public String getExpertUserType() {
		return expertUserType;
	}

	public void setExpertUserType(String expertUserType) {
		this.expertUserType = expertUserType;
	}

	public String getExpertPassword() {
		return expertPassword;
	}

	public void setExpertPassword(String expertPassword) {
		this.expertPassword = expertPassword;
	}

	@Column(name="EXPERT_USERNAME")
	private String expertUserName;
    
	@Column(name="EXPERT_USER_TYPE")
	private String expertUserType;
    
	@Column(name="EXPERT_PASSWORD")
	private String expertPassword;
    
	@JsonIgnore
	@Lob
	@Column(name="RECENT_PHOTO_FILE")
	private byte[] recentPhotoFile;

	
	@Column(name="PRICE_PER_HOUR")
	private BigDecimal pricePerHour;

	public BigDecimal getPricePerHour() {
		return pricePerHour;
	}

	public void setPricePerHour(BigDecimal pricePerHour) {
		this.pricePerHour = pricePerHour;
	}

	@Transient
	private String imageDecode;
	
	
	
	public String getImageDecode() {
		return imageDecode;

	}

	public void setImageDecode(String imageDecode) {
		this.imageDecode = imageDecode;
	}

	@Column(name="USER_ID")
	private java.math.BigDecimal userId;

	//bi-directional many-to-one association to EmsCityCode
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="CITY_ID", referencedColumnName="CITY_ID"),
		@JoinColumn(name="COUNTRY_ID", referencedColumnName="COUNTRY_ID"),
		@JoinColumn(name="GOVERNORATE_ID", referencedColumnName="GOVERNORATE_ID")
		})
	private EmsCityCode emsCityCode;

	//bi-directional many-to-one association to EmsCountryCode
	@ManyToOne
	@JoinColumn(name="COUNTRY_ID_NATIONALITY")
	private EmsCountryCode emsCountryCode;

	//bi-directional many-to-one association to EmsExpertCertificate
	@OneToMany(mappedBy="emsExpert")
	private List<EmsExpertCertificate> emsExpertCertificates;

	//bi-directional many-to-one association to EmsExpertEducation
	@OneToMany(mappedBy="emsExpert")
	private List<EmsExpertEducation> emsExpertEducations;

	//bi-directional many-to-one association to EmsExpertExperience
	@OneToMany(mappedBy="emsExpert")
	private List<EmsExpertExperience> emsExpertExperiences;

	//bi-directional many-to-one association to EmsFinancialRequest
	@OneToMany(mappedBy="emsExpert")
	private List<EmsFinancialRequest> emsFinancialRequests;

	//bi-directional many-to-one association to EmsProjectExpert
	@OneToMany(mappedBy="emsExpert")
	private List<EmsProjectExpert> emsProjectExperts;

	////bi-directional many-to-one association to EmsTask
	//@OneToMany(mappedBy="emsExpert")
	//private List<EmsTask> emsTasks;

	public EmsExpert() {
	}

	public long getExpertId() {
		return this.expertId;
	}

	public void setExpertId(long expertId) {
		this.expertId = expertId;
	}

	public String getBiography() {
		return this.biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	public String getCurrentAddress() {
		return this.currentAddress;
	}

	public void setCurrentAddress(String currentAddress) {
		this.currentAddress = currentAddress;
	}

	public byte[] getCurriculumVitaeFile() {
		return this.curriculumVitaeFile;
	}

	public void setCurriculumVitaeFile(byte[] curriculumVitaeFile) {
		this.curriculumVitaeFile = curriculumVitaeFile;
	}

	public String getExpertEmail() {
		return this.expertEmail;
	}

	public void setExpertEmail(String expertEmail) {
		this.expertEmail = expertEmail;
	}

	public String getExpertMobil1() {
		return this.expertMobil1;
	}

	public void setExpertMobil1(String expertMobil1) {
		this.expertMobil1 = expertMobil1;
	}

	public String getExpertMobil2() {
		return this.expertMobil2;
	}

	public void setExpertMobil2(String expertMobil2) {
		this.expertMobil2 = expertMobil2;
	}

	public String getExpertNameA() {
		return this.expertNameA;
	}

	public void setExpertNameA(String expertNameA) {
		this.expertNameA = expertNameA;
	}

	public String getExpertNameE() {
		return this.expertNameE;
	}

	public void setExpertNameE(String expertNameE) {
		this.expertNameE = expertNameE;
	}

	public String getExpertShortName() {
		return this.expertShortName;
	}

	public void setExpertShortName(String expertShortName) {
		this.expertShortName = expertShortName;
	}

	public byte[] getRecentPhotoFile() {
		return this.recentPhotoFile;
	}

	public void setRecentPhotoFile(byte[] recentPhotoFile) {
		System.out.println(recentPhotoFile);
		this.recentPhotoFile = recentPhotoFile;
	}

	public java.math.BigDecimal getUserId() {
		return this.userId;
	}

	public void setUserId(java.math.BigDecimal userId) {
		this.userId = userId;
	}

	public EmsCityCode getEmsCityCode() {
		return this.emsCityCode;
	}

	public void setEmsCityCode(EmsCityCode emsCityCode) {
		this.emsCityCode = emsCityCode;
	}

	public EmsCountryCode getEmsCountryCode() {
		return this.emsCountryCode;
	}

	public void setEmsCountryCode(EmsCountryCode emsCountryCode) {
		this.emsCountryCode = emsCountryCode;
	}

	public List<EmsExpertCertificate> getEmsExpertCertificates() {
		return this.emsExpertCertificates;
	}

	public void setEmsExpertCertificates(List<EmsExpertCertificate> emsExpertCertificates) {
		this.emsExpertCertificates = emsExpertCertificates;
	}

	public EmsExpertCertificate addEmsExpertCertificate(EmsExpertCertificate emsExpertCertificate) {
		getEmsExpertCertificates().add(emsExpertCertificate);
		emsExpertCertificate.setEmsExpert(this);

		return emsExpertCertificate;
	}

	public EmsExpertCertificate removeEmsExpertCertificate(EmsExpertCertificate emsExpertCertificate) {
		getEmsExpertCertificates().remove(emsExpertCertificate);
		emsExpertCertificate.setEmsExpert(null);

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
	//	emsExpertEducation.setEmsExpert(this);

		return emsExpertEducation;
	}

	public EmsExpertEducation removeEmsExpertEducation(EmsExpertEducation emsExpertEducation) {
		getEmsExpertEducations().remove(emsExpertEducation);
		//emsExpertEducation.setEmsExpert(null);

		return emsExpertEducation;
	}

	public List<EmsExpertExperience> getEmsExpertExperiences() {
		return this.emsExpertExperiences;
	}

	public void setEmsExpertExperiences(List<EmsExpertExperience> emsExpertExperiences) {
		this.emsExpertExperiences = emsExpertExperiences;
	}

	public EmsExpertExperience addEmsExpertExperience(EmsExpertExperience emsExpertExperience) {
		getEmsExpertExperiences().add(emsExpertExperience);
		emsExpertExperience.setEmsExpert(this);

		return emsExpertExperience;
	}

	public EmsExpertExperience removeEmsExpertExperience(EmsExpertExperience emsExpertExperience) {
		getEmsExpertExperiences().remove(emsExpertExperience);
		emsExpertExperience.setEmsExpert(null);

		return emsExpertExperience;
	}
/*
	public List<EmsFinancialRequest> getEmsFinancialRequests() {
		return this.emsFinancialRequests;
	}

	public void setEmsFinancialRequests(List<EmsFinancialRequest> emsFinancialRequests) {
		this.emsFinancialRequests = emsFinancialRequests;
	}

	public EmsFinancialRequest addEmsFinancialRequest(EmsFinancialRequest emsFinancialRequest) {
		getEmsFinancialRequests().add(emsFinancialRequest);
		emsFinancialRequest.setEmsExpert(this);

		return emsFinancialRequest;
	}

	public EmsFinancialRequest removeEmsFinancialRequest(EmsFinancialRequest emsFinancialRequest) {
		getEmsFinancialRequests().remove(emsFinancialRequest);
		emsFinancialRequest.setEmsExpert(null);

		return emsFinancialRequest;
	}
	*/
/*
	public List<EmsProjectExpert> getEmsProjectExperts() {
		return this.emsProjectExperts;
	}

	public void setEmsProjectExperts(List<EmsProjectExpert> emsProjectExperts) {
		this.emsProjectExperts = emsProjectExperts;
	}

	public EmsProjectExpert addEmsProjectExpert(EmsProjectExpert emsProjectExpert) {
		getEmsProjectExperts().add(emsProjectExpert);
		emsProjectExpert.setEmsExpert(this);

		return emsProjectExpert;
	}

	public EmsProjectExpert removeEmsProjectExpert(EmsProjectExpert emsProjectExpert) {
		getEmsProjectExperts().remove(emsProjectExpert);
		emsProjectExpert.setEmsExpert(null);

		return emsProjectExpert;
	}
*/
	/*public List<EmsTask> getEmsTasks() {
		return this.emsTasks;
	}

	public void setEmsTasks(List<EmsTask> emsTasks) {
		this.emsTasks = emsTasks;
	}

	public EmsTask addEmsTask(EmsTask emsTask) {
		getEmsTasks().add(emsTask);
		emsTask.setEmsExpert(this);

		return emsTask;
	}

	public EmsTask removeEmsTask(EmsTask emsTask) {
		getEmsTasks().remove(emsTask);
		emsTask.setEmsExpert(null);

		return emsTask;
	}*/

}