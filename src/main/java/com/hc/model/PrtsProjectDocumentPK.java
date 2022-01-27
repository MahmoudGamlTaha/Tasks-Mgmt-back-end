package com.hc.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the PRTS_PROJECT_DOCUMENT database table.
 * 
 */
@Embeddable
public class PrtsProjectDocumentPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
    
	@Column(name="PROJECT_ID", insertable=false, updatable=false)
	private long projectId;

	@Column(name="DOCUMENT_ID")
	private long documentId;

	public PrtsProjectDocumentPK() {
	}
	public long getProjectId() {
		return this.projectId;
	}
	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}
	public long getDocumentId() {
		return this.documentId;
	}
	public void setDocumentId(long documentId) {
		this.documentId = documentId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PrtsProjectDocumentPK)) {
			return false;
		}
		PrtsProjectDocumentPK castOther = (PrtsProjectDocumentPK)other;
		return 
			(this.projectId == castOther.projectId)
			&& (this.documentId == castOther.documentId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.projectId ^ (this.projectId >>> 32)));
		hash = hash * prime + ((int) (this.documentId ^ (this.documentId >>> 32)));
		
		return hash;
	}
}