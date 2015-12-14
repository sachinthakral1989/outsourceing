package com.property.util;
public enum Status {
	APPROVED("A"), REJECT("R"), NONE("N");

	private String statusCode;

	private Status(String s) {
		statusCode = s;
	}

	public String getStatusCode() {
		return statusCode;
	}

}