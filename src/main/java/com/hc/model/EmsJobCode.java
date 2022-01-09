package com.hc.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the EMS_JOB_CODE database table.
 * 
 */
@Entity
@Table(name="EMS_JOB_CODE")
@NamedQuery(name="EmsJobCode.findAll", query="SELECT e FROM EmsJobCode e")
public class EmsJobCode implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="JOB_ID")
	private String jobId;

	@Column(name="JOB_NAME_A")
	private String jobNameA;

	@Column(name="JOB_NAME_E")
	private String jobNameE;

	//bi-directional many-to-one association to EmsExpertExperience
	@OneToMany(mappedBy="emsJobCode")
	private List<EmsExpertExperience> emsExpertExperiences;

	public EmsJobCode() {
	}

	public String getJobId() {
		return this.jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getJobNameA() {
		return this.jobNameA;
	}

	public void setJobNameA(String jobNameA) {
		this.jobNameA = jobNameA;
	}

	public String getJobNameE() {
		return this.jobNameE;
	}

	public void setJobNameE(String jobNameE) {
		this.jobNameE = jobNameE;
	}

	public List<EmsExpertExperience> getEmsExpertExperiences() {
		return this.emsExpertExperiences;
	}

	public void setEmsExpertExperiences(List<EmsExpertExperience> emsExpertExperiences) {
		this.emsExpertExperiences = emsExpertExperiences;
	}

	public EmsExpertExperience addEmsExpertExperience(EmsExpertExperience emsExpertExperience) {
		getEmsExpertExperiences().add(emsExpertExperience);
		emsExpertExperience.setEmsJobCode(this);

		return emsExpertExperience;
	}

	public EmsExpertExperience removeEmsExpertExperience(EmsExpertExperience emsExpertExperience) {
		getEmsExpertExperiences().remove(emsExpertExperience);
		emsExpertExperience.setEmsJobCode(null);

		return emsExpertExperience;
	}

}