package com.hc.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import com.hc.model.PrtsProjectPersonPK;
/**
 * The persistent class for the PRTS_PROJECT_PERSON database table.
 * 
 */
@Entity
@Table(name="PRTS_PROJECT_PERSON")
@NamedQuery(name="PrtsProjectPerson.findAll", query="SELECT p FROM PrtsProjectPerson p")
public class PrtsProjectPerson implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PrtsProjectPersonPK id;

	@Column(name="IS_VISABLE")
	private BigDecimal isVisable;

	@Column(name="USER_ID")
	private BigDecimal userId;

	//bi-directional many-to-one association to PrtsProject
	@ManyToOne
	@JoinColumn(name="PROJECT_ID", updatable = false, insertable = false)
	private PrtsProject prtsProject;

	public PrtsProjectPerson() {
	}

	public PrtsProjectPersonPK getId() {
		return this.id;
	}

	public void setId(PrtsProjectPersonPK id) {
		this.id = id;
	}

	public BigDecimal getIsVisable() {
		return this.isVisable;
	}

	public void setIsVisable(BigDecimal isVisable) {
		this.isVisable = isVisable;
	}

	public BigDecimal getUserId() {
		return this.userId;
	}

	public void setUserId(BigDecimal userId) {
		this.userId = userId;
	}

	public PrtsProject getPrtsProject() {
		return this.prtsProject;
	}

	public void setPrtsProject(PrtsProject prtsProject) {
		this.prtsProject = prtsProject;
	}

}