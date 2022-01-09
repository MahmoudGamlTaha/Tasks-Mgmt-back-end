package com.hc.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the EMS_TASK_DOCUMENT database table.
 * 
 */
@Entity
@Table(name = "EMS_TASK_DOCUMENT")
@NamedQuery(name = "EmsTaskDocument.findAll", query = "SELECT e FROM EmsTaskDocument e")
public class EmsTaskDocument implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EmsTaskDocumentPK id;

	@Lob
	@Column(name = "DOCUMENT_FILE")
	private byte[] documentFile;

	@Column(name = "DOCUMENT_TEXT")
	private String documentText;

	@Column(name = "USER_ID")
	private java.math.BigDecimal userId;

	// bi-directional many-to-one association to EmsTask
	@ManyToOne
	@JoinColumns({
			@JoinColumn(name = "PROJECT_ID", referencedColumnName = "PROJECT_ID", insertable = false, updatable = false),
			@JoinColumn(name = "TASK_ID", referencedColumnName = "TASK_ID", insertable = false, updatable = false) })
	private EmsTask emsTask;

	public EmsTaskDocument() {
	}

	public EmsTaskDocumentPK getId() {
		return this.id;
	}

	public void setId(EmsTaskDocumentPK id) {
		this.id = id;
	}

	public byte[] getDocumentFile() {
		return this.documentFile;
	}

	public void setDocumentFile(byte[] documentFile) {
		this.documentFile = documentFile;
	}

	public String getDocumentText() {
		return this.documentText;
	}

	public void setDocumentText(String documentText) {
		this.documentText = documentText;
	}

	public java.math.BigDecimal getUserId() {
		return this.userId;
	}

	public void setUserId(java.math.BigDecimal userId) {
		this.userId = userId;
	}

	public EmsTask getEmsTask() {
		return this.emsTask;
	}

	public void setEmsTask(EmsTask emsTask) {
		this.emsTask = emsTask;
	}

}