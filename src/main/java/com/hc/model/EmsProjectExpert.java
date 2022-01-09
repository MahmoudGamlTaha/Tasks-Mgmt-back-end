package com.hc.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the EMS_PROJECT_EXPERT database table.
 * 
 */
@Entity
@Table(name="EMS_PROJECT_EXPERT")
@NamedQuery(name="EmsProjectExpert.findAll", query="SELECT e FROM EmsProjectExpert e")
public class EmsProjectExpert implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EmsProjectExpertPK id;

	@Column(name="HOUR_PRICE")
	private BigDecimal hourPrice;

	//bi-directional many-to-one association to EmsExpert
	@ManyToOne
	@JoinColumn(name="EXPERT_ID" , insertable = false, updatable = false)
	private EmsExpert emsExpert;

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

}