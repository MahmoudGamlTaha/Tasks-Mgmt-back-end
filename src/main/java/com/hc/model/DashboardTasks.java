package com.hc.model;

import java.math.BigDecimal;
import java.util.Date;

public interface DashboardTasks {
	BigDecimal getTASK_ID();
	String getTASK_Name();
	String getPROJECT_NAME();
	BigDecimal getPROJECT_ID();
	BigDecimal getTOTALMINUTES();
	String getTASK_STATUS_NAME();
	String getTASK_CREATE_DATE();
	String getTASK_EXPECTED_DATE();
	String getCOLOR();
	BigDecimal getTASK_STATUS_ID();
}
