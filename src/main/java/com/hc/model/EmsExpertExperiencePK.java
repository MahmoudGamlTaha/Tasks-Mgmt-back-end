package com.hc.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the EMS_EXPERT_EXPERIENCE database table.
 * 
 */
@Embeddable
public class EmsExpertExperiencePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="EXPERT_ID", insertable=false, updatable=false)
	private long expertId;
	
	
	@Column(name="EXPERIENCE_ID")
	private Long experienceId;

	public EmsExpertExperiencePK() {
	}
	public long getExpertId() {
		return this.expertId;
	}
	public void setExpertId(long expertId) {
		this.expertId = expertId;
	}
	public Long getExperienceId() {
		return this.experienceId;
	}
	public void setExperienceId(Long experienceId) {
		this.experienceId = experienceId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof EmsExpertExperiencePK)) {
			return false;
		}
		EmsExpertExperiencePK castOther = (EmsExpertExperiencePK)other;
		return 
			(this.expertId == castOther.expertId)
			&& (this.experienceId == castOther.experienceId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.expertId ^ (this.expertId >>> 32)));
		hash = hash * prime + ((int) (this.experienceId ^ (this.experienceId >>> 32)));
		
		return hash;
	}
}