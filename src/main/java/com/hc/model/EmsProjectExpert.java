package com.hc.model;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.data.domain.Persistable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;


/**
 * The persistent class for the EMS_PROJECT_EXPERT database table.
 * 
 */
@Entity
@Table(name="EMS_PROJECT_EXPERT")
@NamedQuery(name="EmsProjectExpert.findAll", query="SELECT e FROM EmsProjectExpert e")
public class EmsProjectExpert implements Serializable,Persistable<EmsProjectExpertPK> {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EmsProjectExpertPK id;

	@Column(name="HOUR_PRICE")
	private BigDecimal hourPrice;

	@Column(name="TOTAL_COUNT",insertable = false, updatable = false)
	private Long totalCount;
	
	@Column(name="COMPLETED_COUNT",insertable = false, updatable = false)
	private Long completedCount;
	
	@Column(name="TOTAL_HOURS",insertable = false, updatable = false)
	private Double totalHours;
	
	@Column(name="COMPLETED_HOURS",insertable = false, updatable = false)
	private Double completedHours;
	
	//bi-directional many-to-one association to EmsExpert
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="EXPERT_ID" , insertable = false, updatable = false)
	private EmsExpert emsExpert;

	
	@ManyToOne
	@JoinColumn(name="PROJECT_ID" , insertable = false, updatable = false)
	private PrtsProject prtsProject;

	
	public EmsProjectExpert() {
	}

	public EmsProjectExpertPK getId() {
		return this.id;
	}

	public void setId(EmsProjectExpertPK id) {
		this.id = id;
	}

	public BigDecimal getHourPrice() {
		return this.hourPrice;
	}

	public void setHourPrice(BigDecimal hourPrice) {
		this.hourPrice = hourPrice;
	}

	public EmsExpert getEmsExpert() {
		return this.emsExpert;
	}

	public void setEmsExpert(EmsExpert emsExpert) {
		this.emsExpert = emsExpert;
	}

	public PrtsProject getPrtsProject() {
		return prtsProject;
	}

	public void setPrtsProject(PrtsProject prtsProject) {
		this.prtsProject = prtsProject;
	}

	public Long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}

	public Long getCompletedCount() {
		return completedCount;
	}

	public void setCompletedCount(Long completedCount) {
		this.completedCount = completedCount;
	}

	public Double getTotalHours() {
		return totalHours;
	}

	public void setTotalHours(Double totalHours) {
		this.totalHours = totalHours;
	}

	public Double getCompletedHours() {
		return completedHours;
	}

	public void setCompletedHours(Double completedHours) {
		this.completedHours = completedHours;
	}
	@Override
	  public boolean isNew() {
	    return true; // this makes every entity a new one
	  }
}