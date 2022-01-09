package com.hc.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the EMS_FINANCIAL_REQUEST_DTL database table.
 * 
 */
@Embeddable
public class EmsFinancialRequestDtlPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="REQUEST_ID", insertable=false, updatable=false)
	private long requestId;

	@Column(name="REQUEST_ID_DTL")
	private long requestIdDtl;

	public EmsFinancialRequestDtlPK() {
	}
	public long getRequestId() {
		return this.requestId;
	}
	public void setRequestId(long requestId) {
		this.requestId = requestId;
	}
	public long getRequestIdDtl() {
		return this.requestIdDtl;
	}
	public void setRequestIdDtl(long requestIdDtl) {
		this.requestIdDtl = requestIdDtl;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof EmsFinancialRequestDtlPK)) {
			return false;
		}
		EmsFinancialRequestDtlPK castOther = (EmsFinancialRequestDtlPK)other;
		return 
			(this.requestId == castOther.requestId)
			&& (this.requestIdDtl == castOther.requestIdDtl);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.requestId ^ (this.requestId >>> 32)));
		hash = hash * prime + ((int) (this.requestIdDtl ^ (this.requestIdDtl >>> 32)));
		
		return hash;
	}
}