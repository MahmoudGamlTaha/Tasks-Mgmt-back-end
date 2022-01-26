package com.hc.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the PRTS_PROJECT_NOTE database table.
 * 
 */
public class PrtsProjectNotePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private long projectId;

	private long noteId;

	public PrtsProjectNotePK() {
	}
	public long getProjectId() {
		return this.projectId;
	}
	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}
	public long getNoteId() {
		return this.noteId;
	}
	public void setNoteId(long noteId) {
		this.noteId = noteId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PrtsProjectNotePK)) {
			return false;
		}
		PrtsProjectNotePK castOther = (PrtsProjectNotePK)other;
		return 
			(this.projectId == castOther.projectId)
			&& (this.noteId == castOther.noteId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.projectId ^ (this.projectId >>> 32)));
		hash = hash * prime + ((int) (this.noteId ^ (this.noteId >>> 32)));
		
		return hash;
	}
}