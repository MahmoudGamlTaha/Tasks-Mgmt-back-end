package com.hc.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the EMS_TASK database table.
 * 
 */
@Embeddable
public class EmsTaskPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="PROJECT_ID", insertable=false, updatable=false)
	private long projectId;

	@Column(name="TASK_ID")
	private Long taskId;

	public EmsTaskPK() {
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

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof EmsTaskPK)) {
			return false;
		}
		EmsTaskPK castOther = (EmsTaskPK)other;
		return 
			(this.projectId == castOther.projectId)
			&& (this.taskId == castOther.taskId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.projectId ^ (this.projectId >>> 32)));
		hash = hash * prime + ((int) (this.taskId ^ (this.taskId >>> 32)));
		
		return hash;
	}
}