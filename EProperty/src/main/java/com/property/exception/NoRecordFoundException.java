package com.property.exception;

public class NoRecordFoundException extends Exception {


	private static final long serialVersionUID = 1L;

	public NoRecordFoundException(String errMsg) {
		super(errMsg);
	}

	public NoRecordFoundException(String errMsg, Throwable e) {
		super(errMsg, e);
	}
}
