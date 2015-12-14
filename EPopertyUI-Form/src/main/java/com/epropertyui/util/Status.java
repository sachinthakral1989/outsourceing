package com.epropertyui.util;
public enum Status {
	APPROVED("A"), REJECTED("R"), NONE("N");

	private String statusCode;

	private Status(String s) {
		statusCode = s;
	}

	public String getStatusCode() {
		return statusCode;
	}

}