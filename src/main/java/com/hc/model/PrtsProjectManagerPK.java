package com.hc.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the PRTS_PROJECT_MANAGERS database table.
 * 
 */
@Embeddable
public class PrtsProjectManagerPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="PROJECT_ID", insertable=false, updatable=false)
	private long projectId;

	@Column(name="USER_ID", insertable=false, updatable=false)
	private long userId;

	public PrtsProjectManagerPK() {
	}
	public long getProjectId() {
		return this.projectId;
	}
	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}
	public long getUserId() {
		return this.userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PrtsProjectManagerPK)) {
			return false;
		}
		PrtsProjectManagerPK castOther = (PrtsProjectManagerPK)other;
		return 
			(this.projectId == castOther.projectId)
			&& (this.userId == castOther.userId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.projectId ^ (this.projectId >>> 32)));
		hash = hash * prime + ((int) (this.userId ^ (this.userId >>> 32)));
		
		return hash;
	}
}