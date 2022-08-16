package com.hc.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

public interface EmsDashboardCounts {
	
     BigDecimal getID();
	BigDecimal getTOTAL_TASK_COUNT();
	BigDecimal getCOMPLETED_TASK_COUNT();
	
	Double getTOTAL_HOURS();
	
	Double getCOMPLETED_HOURS();
	
	Double getCOMPLETED_BUDGET();
	
	Double getEXPECTED_BUDGET();
	
}
