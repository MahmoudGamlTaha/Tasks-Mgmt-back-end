package com.hc.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the PRTS_PROJECT_PERSON database table.
 * 
 */
@Embeddable
public class PrtsProjectPersonPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="PROJECT_ID", insertable=false, updatable=false)
	private long projectId;

	@Column(name="USER_ROLE_CODE", insertable=false, updatable=false)
	private long userRoleCode;

	public PrtsProjectPersonPK() {
	}
	public long getProjectId() {
		return this.projectId;
	}
	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}
	public long getUserRoleCode() {
		return this.userRoleCode;
	}
	public void setUserRoleCode(long userRoleCode) {
		this.userRoleCode = userRoleCode;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PrtsProjectPersonPK)) {
			return false;
		}
		PrtsProjectPersonPK castOther = (PrtsProjectPersonPK)other;
		return 
			(this.projectId == castOther.projectId)
			&& (this.userRoleCode == castOther.userRoleCode);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.projectId ^ (this.projectId >>> 32)));
		hash = hash * prime + ((int) (this.userRoleCode ^ (this.userRoleCode >>> 32)));
		
		return hash;
	}
}