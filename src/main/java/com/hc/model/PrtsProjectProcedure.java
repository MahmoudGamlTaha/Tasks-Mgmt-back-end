package com.hc.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import com.hc.model.PrtsProjectProcedurePK;

/**
 * The persistent class for the PRTS_PROJECT_PROCEDURE database table.
 * 
 */
@Entity
@Table(name="PRTS_PROJECT_PROCEDURE")
@NamedQuery(name="PrtsProjectProcedure.findAll", query="SELECT p FROM PrtsProjectProcedure p")
public class PrtsProjectProcedure implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PrtsProjectProcedurePK id;

	@Temporal(TemporalType.DATE)
	@Column(name="PROCEDURE_DATE")
	private Date procedureDate;

	@Column(name="PROCEDURE_TEXT")
	private String procedureText;

	@Column(name="PROCEDURE_TYPE_CODE")
	private java.math.BigDecimal procedureTypeCode;

	@Column(name="USER_ID")
	private java.math.BigDecimal userId;

	//bi-directional many-to-one association to PrtsProject
	@ManyToOne
	@JoinColumn(name="PROJECT_ID",updatable = false, insertable = false)
	private PrtsProject prtsProject;

	public PrtsProjectProcedure() {
	}

	public PrtsProjectProcedurePK getId() {
		return this.id;
	}

	public void setId(PrtsProjectProcedurePK id) {
		this.id = id;
	}

	public Date getProcedureDate() {
		return this.procedureDate;
	}

	public void setProcedureDate(Date procedureDate) {
		this.procedureDate = procedureDate;
	}

	public String getProcedureText() {
		return this.procedureText;
	}

	public void setProcedureText(String procedureText) {
		this.procedureText = procedureText;
	}

	public java.math.BigDecimal getProcedureTypeCode() {
		return this.procedureTypeCode;
	}

	public void setProcedureTypeCode(java.math.BigDecimal procedureTypeCode) {
		this.procedureTypeCode = procedureTypeCode;
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