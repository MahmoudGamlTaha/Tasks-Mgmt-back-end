package com.hc.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the PRTS_PROJECT_PROCEDURE database table.
 * 
 */
@Embeddable
public class PrtsProjectProcedurePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="PROJECT_ID", insertable=false, updatable=false)
	private long projectId;

	@Column(name="PROCEDURE_ID")
	private long procedureId;

	public PrtsProjectProcedurePK() {
	}
	public long getProjectId() {
		return this.projectId;
	}
	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}
	public long getProcedureId() {
		return this.procedureId;
	}
	public void setProcedureId(long procedureId) {
		this.procedureId = procedureId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PrtsProjectProcedurePK)) {
			return false;
		}
		PrtsProjectProcedurePK castOther = (PrtsProjectProcedurePK)other;
		return 
			(this.projectId == castOther.projectId)
			&& (this.procedureId == castOther.procedureId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.projectId ^ (this.projectId >>> 32)));
		hash = hash * prime + ((int) (this.procedureId ^ (this.procedureId >>> 32)));
		
		return hash;
	}
}