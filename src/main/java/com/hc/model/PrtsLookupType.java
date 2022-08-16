package com.hc.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the PRTS_LOOKUP_TYPE database table.
 * 
 */
@Entity
@Table(name="PRTS_LOOKUP_TYPE")
@NamedQuery(name="PrtsLookupType.findAll", query="SELECT p FROM PrtsLookupType p")
public class PrtsLookupType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	
	@Column(name="LOOKUP_TYPE")
	private long lookupType;

	@Column(name="LOOKUP_TYPE_NAME")
	private String lookupTypeName;

//	//bi-directional many-to-one association to PrtsLookupMainCode
//	@OneToMany(mappedBy="prtsLookupType")
//	private List<PrtsLookupMainCode> prtsLookupMainCodes;

	public PrtsLookupType() {
	}

	public long getLookupType() {
		return this.lookupType;
	}

	public void setLookupType(long lookupType) {
		this.lookupType = lookupType;
	}

	public String getLookupTypeName() {
		return this.lookupTypeName;
	}

	public void setLookupTypeName(String lookupTypeName) {
		this.lookupTypeName = lookupTypeName;
	}

//	public List<PrtsLookupMainCode> getPrtsLookupMainCodes() {
//		return this.prtsLookupMainCodes;
//	}
//
//	public void setPrtsLookupMainCodes(List<PrtsLookupMainCode> prtsLookupMainCodes) {
//		this.prtsLookupMainCodes = prtsLookupMainCodes;
//	}
//
//	public PrtsLookupMainCode addPrtsLookupMainCode(PrtsLookupMainCode prtsLookupMainCode) {
//		getPrtsLookupMainCodes().add(prtsLookupMainCode);
//		prtsLookupMainCode.setPrtsLookupType(this);
//
//		return prtsLookupMainCode;
//	}
//
//	public PrtsLookupMainCode removePrtsLookupMainCode(PrtsLookupMainCode prtsLookupMainCode) {
//		getPrtsLookupMainCodes().remove(prtsLookupMainCode);
//		prtsLookupMainCode.setPrtsLookupType(null);
//
//		return prtsLookupMainCode;
//	}

}