package com.hc.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the EMS_PROJECT_EXPERT database table.
 * 
 */
@Embeddable
public class EmsProjectExpertPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="PROJECT_ID", insertable=false, updatable=false)
	private long projectId;

	@Column(name="EXPERT_ID", insertable=false, updatable=false)
	private long expertId;

	public EmsProjectExpertPK() {
	}
	public long getProjectId() {
		return this.projectId;
	}
	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}
	public long getExpertId() {
		return this.expertId;
	}
	public void setExpertId(long expertId) {
		this.expertId = expertId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof EmsProjectExpertPK)) {
			return false;
		}
		EmsProjectExpertPK castOther = (EmsProjectExpertPK)other;
		return 
			(this.projectId == castOther.projectId)
			&& (this.expertId == castOther.expertId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.projectId ^ (this.projectId >>> 32)));
		hash = hash * prime + ((int) (this.expertId ^ (this.expertId >>> 32)));
		
		return hash;
	}
}