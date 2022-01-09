package com.hc.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the EMS_TASK_DOCUMENT database table.
 * 
 */
@Embeddable
public class EmsTaskDocumentPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="PROJECT_ID", insertable=false, updatable=false)
	private long projectId;

	@Column(name="TASK_ID", insertable=false, updatable=false)
	private long taskId;

	@Column(name="TASK_DOCUMENT_ID")
	private long taskDocumentId;

	public EmsTaskDocumentPK() {
	}
	public long getProjectId() {
		return this.projectId;
	}
	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}
	public long getTaskId() {
		return this.taskId;
	}
	public void setTaskId(long taskId) {
		this.taskId = taskId;
	}
	public long getTaskDocumentId() {
		return this.taskDocumentId;
	}
	public void setTaskDocumentId(long taskDocumentId) {
		this.taskDocumentId = taskDocumentId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof EmsTaskDocumentPK)) {
			return false;
		}
		EmsTaskDocumentPK castOther = (EmsTaskDocumentPK)other;
		return 
			(this.projectId == castOther.projectId)
			&& (this.taskId == castOther.taskId)
			&& (this.taskDocumentId == castOther.taskDocumentId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.projectId ^ (this.projectId >>> 32)));
		hash = hash * prime + ((int) (this.taskId ^ (this.taskId >>> 32)));
		hash = hash * prime + ((int) (this.taskDocumentId ^ (this.taskDocumentId >>> 32)));
		
		return hash;
	}
}