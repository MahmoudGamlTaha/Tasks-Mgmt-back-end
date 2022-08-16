package com.hc.model;

import java.io.Serializable;
import javax.persistence.*;



import java.math.BigDecimal;


/**
 * The persistent class for the PRTS_LOOKUP_MAIN_CODE database table.
 * 
 */
@Entity
@Table(name="PRTS_LOOKUP_MAIN_CODE")
@NamedQuery(name="PrtsLookupMainCode.findAll", query="SELECT p FROM PrtsLookupMainCode p")
public class PrtsLookupMainCode implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PRTS_LOOKUP_MAIN_CODE_LOOKUPID_GENERATOR")
	@SequenceGenerator(name="PRTS_LOOKUP_MAIN_CODE_LOOKUPID_GENERATOR", sequenceName="PRTS_LOOKUP_MAIN_CODE_SEQ", allocationSize = 1)

	@Column(name="LOOKUP_ID")
	private long lookupId;

	@Column(name="LOOKUP_ID_PARENT")
	private BigDecimal lookupIdParent;

	@Column(name="LOOKUP_MAIN_CODE",updatable = false,insertable = false)
	private BigDecimal lookupMainCode;

	@Column(name="LOOKUP_MAIN_NAME")
	private String lookupMainName;

	@Column(name="LOOKUP_TYPE")
	private String lookupType;
	
	//bi-directional many-to-one association to PrtsLookupType
//	@ManyToOne
//	@JoinColumn(name="LOOKUP_TYPE")
//	private PrtsLookupType prtsLookupType;

	public String getLookupType() {
		return lookupType;
	}

	public void setLookupType(String lookupType) {
		this.lookupType = lookupType;
	}

	public PrtsLookupMainCode() {
	}

	public long getLookupId() {
		return this.lookupId;
	}

	public void setLookupId(long lookupId) {
		this.lookupId = lookupId;
	}

	public BigDecimal getLookupIdParent() {
		return this.lookupIdParent;
	}

	public void setLookupIdParent(BigDecimal lookupIdParent) {
		this.lookupIdParent = lookupIdParent;
	}

	public BigDecimal getLookupMainCode() {
		return this.lookupMainCode;
	}

	public void setLookupMainCode(BigDecimal lookupMainCode) {
		this.lookupMainCode = lookupMainCode;
	}

	public String getLookupMainName() {
		return this.lookupMainName;
	}

	public void setLookupMainName(String lookupMainName) {
		this.lookupMainName = lookupMainName;
	}

//	public PrtsLookupType getPrtsLookupType() {
//		return this.prtsLookupType;
//	}
//
//	public void setPrtsLookupType(PrtsLookupType prtsLookupType) {
//		this.prtsLookupType = prtsLookupType;
//	}

}