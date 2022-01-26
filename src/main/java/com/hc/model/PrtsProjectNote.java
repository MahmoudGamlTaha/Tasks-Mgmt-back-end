package com.hc.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the PRTS_PROJECT_NOTE database table.
 * 
 */
@Entity
@Table(name="PRTS_PROJECT_NOTE")
@NamedQuery(name="PrtsProjectNote.findAll", query="SELECT p FROM PrtsProjectNote p")
@IdClass(PrtsProjectNotePK.class)
public class PrtsProjectNote implements Serializable {
	private static final long serialVersionUID = 1L;
    
	@Id
	@Column(name="PROJECT_ID")
	private long projectId;
    
    @Id
	@Column(name="NOTE_ID")
	private long noteId;

	@Temporal(TemporalType.DATE)
	@Column(name="NOTE_DATE")
	private Date noteDate;

	@Column(name="NOTE_TEXT")
	private String noteText;

	@Column(name="USER_ID")
	private java.math.BigDecimal userId;

	//bi-directional many-to-one association to PrtsProject
	@ManyToOne
	@JoinColumn(name="PROJECT_ID", insertable = false, updatable = false)
	private PrtsProject prtsProject;
	
	/*@ManyToOne
	@JoinColumn(name="NOTE_ID", insertable = false, updatable = false)
	private PrtsProjectNote prtsNotes;
*/
	public PrtsProjectNote() {
	}

	public Date getNoteDate() {
		return this.noteDate;
	}

	public void setNoteDate(Date noteDate) {
		this.noteDate = noteDate;
	}

	public String getNoteText() {
		return this.noteText;
	}

	public void setNoteText(String noteText) {
		this.noteText = noteText;
	}

	public java.math.BigDecimal getUserId() {
		return this.userId;
	}

	public void setUserId(java.math.BigDecimal userId) {
		this.userId = userId;
	}

	public PrtsProject getPrtsProject() {
		return this.prtsProject;
	}

	public void setPrtsProject(PrtsProject prtsProject) {
		this.prtsProject = prtsProject;
	}

}