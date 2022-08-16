package com.hc.model;

import java.util.Date;

public interface ProjectDashBoard {
	public Integer getPROJECT_ID();
	public Long getTOTAL_AMOUNT();
	public Double getEXEC_PERCENTAGE();
	public Double getTIMEEXECUTED();
	public String getREGION_NAME();
	public String getDEPT_NAME();
	public String getCONTRACT_STATUS_NAME();
	public String getEXEC_STATUS_NAME();
	public String getEXPERT_NAME();
	public String getCONTRACTOR_STATUS_NAME();
	public Long getPROJECT_AMOUNT();
	public Date getPROJECT_STARTDATE();
	public Date getPROJECT_ENDDATE();
	public String getPROJECT_STATUS();


	



}
