package com.hc.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the EMS_EXPERT_EDUCATION database table.
 * 
 */
@Embeddable
public class EmsExpertEducationPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="EXPERT_ID", insertable=false, updatable=false)
	private long expertId;

	@Column(name="EDUCATION_ID")
	private long educationId;

	public EmsExpertEducationPK() {
	}
	public long getExpertId() {
		return this.expertId;
	}
	public void setExpertId(long expertId) {
		this.expertId = expertId;
	}
	public long getEducationId() {
		return this.educationId;
	}
	public void setEducationId(long educationId) {
		this.educationId = educationId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof EmsExpertEducationPK)) {
			return false;
		}
		EmsExpertEducationPK castOther = (EmsExpertEducationPK)other;
		return 
			(this.expertId == castOther.expertId)
			&& (this.educationId == castOther.educationId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.expertId ^ (this.expertId >>> 32)));
		hash = hash * prime + ((int) (this.educationId ^ (this.educationId >>> 32)));
		
		return hash;
	}
}