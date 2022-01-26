package com.hc.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the PRTS_ROLE_CODE database table.
 * 
 */
@Entity
@Table(name="PRTS_ROLE_CODE")
@NamedQuery(name="PrtsRoleCode.findAll", query="SELECT p FROM PrtsRoleCode p")
public class PrtsRoleCode implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "PRTS_USER_ROLE_SEQ")
	@SequenceGenerator(name = "PRTS_USER_ROLE_SEQ", sequenceName = "PRTS_USER_ROLE_SEQ", allocationSize = 1)
	@Column(name="USER_ROLE_CODE", unique=true, nullable=false, precision=2)
	private long userRoleCode;

	@Column(name="USER_ROLE_NAME", nullable=false, length=150)
	private String userRoleName;

	//bi-directional many-to-one association to PrtsRoleCode
	@ManyToOne
	@JoinColumn(name="USER_ROLE_CODE", nullable=false, insertable=false, updatable=false)
	private PrtsRoleCode prtsRoleCode;

	//bi-directional many-to-one association to PrtsRoleCode
	@OneToMany(mappedBy="prtsRoleCode")
	private List<PrtsRoleCode> prtsRoleCodes;

	public PrtsRoleCode() {
	}

	public long getUserRoleCode() {
		return this.userRoleCode;
	}

	public void setUserRoleCode(long userRoleCode) {
		this.userRoleCode = userRoleCode;
	}

	public String getUserRoleName() {
		return this.userRoleName;
	}

	public void setUserRoleName(String userRoleName) {
		this.userRoleName = userRoleName;
	}

	public PrtsRoleCode getPrtsRoleCode() {
		return this.prtsRoleCode;
	}

	public void setPrtsRoleCode(PrtsRoleCode prtsRoleCode) {
		this.prtsRoleCode = prtsRoleCode;
	}

	public List<PrtsRoleCode> getPrtsRoleCodes() {
		return this.prtsRoleCodes;
	}

	public void setPrtsRoleCodes(List<PrtsRoleCode> prtsRoleCodes) {
		this.prtsRoleCodes = prtsRoleCodes;
	}

	public PrtsRoleCode addPrtsRoleCode(PrtsRoleCode prtsRoleCode) {
		getPrtsRoleCodes().add(prtsRoleCode);
		prtsRoleCode.setPrtsRoleCode(this);

		return prtsRoleCode;
	}

	public PrtsRoleCode removePrtsRoleCode(PrtsRoleCode prtsRoleCode) {
		getPrtsRoleCodes().remove(prtsRoleCode);
		prtsRoleCode.setPrtsRoleCode(null);

		return prtsRoleCode;
	}

}