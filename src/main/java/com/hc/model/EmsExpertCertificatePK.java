package com.hc.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the EMS_EXPERT_CERTIFICATE database table.
 * 
 */
@Embeddable
public class EmsExpertCertificatePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="EXPERT_ID", insertable=false, updatable=false)
	private long expertId;

	@Column(name="CERTIFICATE_ID")
	private Long certificateId;

	public EmsExpertCertificatePK() {
	}
	public long getExpertId() {
		return this.expertId;
	}
	public void setExpertId(long expertId) {
		this.expertId = expertId;
	}
	public Long getCertificateId() {
		return this.certificateId;
	}
	public void setCertificateId(Long certificateId) {
		this.certificateId = certificateId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof EmsExpertCertificatePK)) {
			return false;
		}
		EmsExpertCertificatePK castOther = (EmsExpertCertificatePK)other;
		return 
			(this.expertId == castOther.expertId)
			&& (this.certificateId == castOther.certificateId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.expertId ^ (this.expertId >>> 32)));
		hash = hash * prime + ((int) (this.certificateId ^ (this.certificateId >>> 32)));
		
		return hash;
	}
}