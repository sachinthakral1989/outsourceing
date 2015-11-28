package com.property.exception;

public class InsufficientInventoryException extends Exception {

	
	private static final long serialVersionUID = 1L;

	public InsufficientInventoryException() {
		super();
	}

	public InsufficientInventoryException(String errMsg) {
		super(errMsg);
	}

	public InsufficientInventoryException(String errMsg, Throwable e) {
		super(errMsg, e);
	}

}
