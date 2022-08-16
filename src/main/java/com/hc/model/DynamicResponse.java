package com.hc.model;

import lombok.Data;

@Data
public class DynamicResponse<T> {
	String statusCode;
	String message;
	T Data;

}
