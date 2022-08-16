package com.hc.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the PRTS_PROJECT_MANAGERS database table.
 * 
 */
@Entity
@Table(name="PRTS_PROJECT_MANAGERS")
@NamedQuery(name="PrtsProjectManager.findAll", query="SELECT p FROM PrtsProjectManager p")
public class PrtsProjectManager implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PrtsProjectManagerPK id;

	//bi-directional many-to-one association to PrtsProject
//	@ManyToOne
//	@JoinColumn(name="PROJECT_ID")
//	private PrtsProject prtsProject;

	public PrtsProjectManager() {
	}

	public PrtsProjectManagerPK getId() {
		return this.id;
	}

	public void setId(PrtsProjectManagerPK id) {
		this.id = id;
	}

//	public PrtsProject getPrtsProject() {
//		return this.prtsProject;
//	}
//
//	public void setPrtsProject(PrtsProject prtsProject) {
//		this.prtsProject = prtsProject;
//	}

}