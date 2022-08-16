package com.hc.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the EMS_FINANCIAL_REQUEST_DTL database table.
 * 
 */
@Entity
@Table(name="EMS_FINANCIAL_REQUEST_DTL")
@NamedQuery(name="EmsFinancialRequestDtl.findAll", query="SELECT e FROM EmsFinancialRequestDtl e")
public class EmsFinancialRequestDtl implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EmsFinancialRequestDtlPK id;

	//bi-directional many-to-one association to EmsFinancialRequest
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="REQUEST_ID", insertable = false, updatable = false)
	private EmsFinancialRequest emsFinancialRequest;

	//bi-directional many-to-one association to EmsTask
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="PROJECT_ID", referencedColumnName="PROJECT_ID"),
		@JoinColumn(name="TASK_ID", referencedColumnName="TASK_ID")
		})
	private EmsTask emsTask;

	public EmsFinancialRequestDtl() {
	}

	public EmsFinancialRequestDtlPK getId() {
		return this.id;
	}

	public void setId(EmsFinancialRequestDtlPK id) {
		this.id = id;
	}

	public EmsFinancialRequest getEmsFinancialRequest() {
		return this.emsFinancialRequest;
	}

	public void setEmsFinancialRequest(EmsFinancialRequest emsFinancialRequest) {
		this.emsFinancialRequest = emsFinancialRequest;
	}

	public EmsTask getEmsTask() {
		return this.emsTask;
	}

	public void setEmsTask(EmsTask emsTask) {
		this.emsTask = emsTask;
	}

}