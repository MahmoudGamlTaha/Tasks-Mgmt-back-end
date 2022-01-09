package com.hc.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the EMS_TASK_COMMENT database table.
 * 
 */
@Embeddable
public class EmsTaskCommentPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="PROJECT_ID", insertable=false, updatable=false)
	private long projectId;

	@Column(name="TASK_ID", insertable=false, updatable=false)
	private long taskId;

	@Column(name="TASK_COMMENT_ID")
	private long taskCommentId;

	public EmsTaskCommentPK() {
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
	public long getTaskCommentId() {
		return this.taskCommentId;
	}
	public void setTaskCommentId(long taskCommentId) {
		this.taskCommentId = taskCommentId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof EmsTaskCommentPK)) {
			return false;
		}
		EmsTaskCommentPK castOther = (EmsTaskCommentPK)other;
		return 
			(this.projectId == castOther.projectId)
			&& (this.taskId == castOther.taskId)
			&& (this.taskCommentId == castOther.taskCommentId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.projectId ^ (this.projectId >>> 32)));
		hash = hash * prime + ((int) (this.taskId ^ (this.taskId >>> 32)));
		hash = hash * prime + ((int) (this.taskCommentId ^ (this.taskCommentId >>> 32)));
		
		return hash;
	}
}