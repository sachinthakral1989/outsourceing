package com.property.exception;

public class InvalidEntityFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidEntityFoundException(String errMsg) {
		super(errMsg);
	}

	public InvalidEntityFoundException(String errMsg, Throwable e) {
		super(errMsg, e);
	}

}
