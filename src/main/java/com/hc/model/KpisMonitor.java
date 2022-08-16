package com.hc.model;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class KpisMonitor implements Serializable {
	
	String firstSide;
	String secondSide;
	List<String> firstSideValues;
	List<String> secondSideValues;
	


}
