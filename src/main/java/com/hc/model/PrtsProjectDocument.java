package com.hc.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the PRTS_PROJECT_DOCUMENT database table.
 * 
 */
@Entity
@Table(name="PRTS_PROJECT_DOCUMENT")
@NamedQuery(name="PrtsProjectDocument.findAll", query="SELECT p FROM PrtsProjectDocument p")
public class PrtsProjectDocument {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PrtsProjectDocumentPK id;

	@Column(name="DOCUMENT_DESC")
	private String documentDesc;

	@Lob
	@Column(name="DOCUMENT_FILE")
	private byte[] documentFile;

	@Column(name="FILE_FULL_PATH")
	private String fileFullPath;

	@Temporal(TemporalType.DATE)
	@Column(name="UPLOAD_DATE")
	private Date uploadDate;

	@Column(name="USER_ID")
	private java.math.BigDecimal userId;

	//bi-directional many-to-one association to PrtsProject
	//@ManyToOne
//	@JoinColumn(name="PROJECT_ID")
	//private PrtsProject prtsProject;

	public PrtsProjectDocument() {
	}

	public PrtsProjectDocumentPK getId() {
		return this.id;
	}

	public void setId(PrtsProjectDocumentPK id) {
		this.id = id;
	}

	public String getDocumentDesc() {
		return this.documentDesc;
	}

	public void setDocumentDesc(String documentDesc) {
		this.documentDesc = documentDesc;
	}

	public byte[] getDocumentFile() {
		return this.documentFile;
	}

	public void setDocumentFile(byte[] documentFile) {
		this.documentFile = documentFile;
	}

	public String getFileFullPath() {
		return this.fileFullPath;
	}

	public void setFileFullPath(String fileFullPath) {
		this.fileFullPath = fileFullPath;
	}

	public Date getUploadDate() {
		return this.uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	public java.math.BigDecimal getUserId() {
		return this.userId;
	}

	public void setUserId(java.math.BigDecimal userId) {
		this.userId = userId;
	}

	/*public PrtsProject getPrtsProject() {
		return this.prtsProject;
	}

	public void setPrtsProject(PrtsProject prtsProject) {
		this.prtsProject = prtsProject;
	}*/

}