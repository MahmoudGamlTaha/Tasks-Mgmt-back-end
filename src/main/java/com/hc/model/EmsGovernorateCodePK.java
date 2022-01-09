package com.hc.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the EMS_GOVERNORATE_CODE database table.
 * 
 */
@Embeddable
public class EmsGovernorateCodePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="COUNTRY_ID", insertable=false, updatable=false)
	private long countryId;

	@Column(name="GOVERNORATE_ID")
	private long governorateId;

	public EmsGovernorateCodePK() {
	}
	public long getCountryId() {
		return this.countryId;
	}
	public void setCountryId(long countryId) {
		this.countryId = countryId;
	}
	public long getGovernorateId() {
		return this.governorateId;
	}
	public void setGovernorateId(long governorateId) {
		this.governorateId = governorateId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof EmsGovernorateCodePK)) {
			return false;
		}
		EmsGovernorateCodePK castOther = (EmsGovernorateCodePK)other;
		return 
			(this.countryId == castOther.countryId)
			&& (this.governorateId == castOther.governorateId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.countryId ^ (this.countryId >>> 32)));
		hash = hash * prime + ((int) (this.governorateId ^ (this.governorateId >>> 32)));
		
		return hash;
	}
}