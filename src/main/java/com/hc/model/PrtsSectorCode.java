package com.hc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="PRTS_SECTOR_CODE")
@NamedQuery(name="PrtsSectorCode.findAll", query="SELECT p FROM PrtsSectorCode p")
public class PrtsSectorCode {

	@Id
	@Column(name="SECTOR_CODE", insertable = false, updatable = false)
	private long SectorCode;

	@Column(name="SECTOR_NAME")
	private String SectorName;

	public long getSectorCode() {
		return SectorCode;
	}

	public void setSectorCode(long sectorCode) {
		SectorCode = sectorCode;
	}

	public String getSectorName() {
		return SectorName;
	}

	public void setSectorName(String sectorName) {
		SectorName = sectorName;
	}

}
