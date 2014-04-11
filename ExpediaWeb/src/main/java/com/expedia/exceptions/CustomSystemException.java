package com.expedia.exceptions;

public class CustomSystemException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomSystemException() {

	}

	public CustomSystemException(String message) {
		super(message);
	}

	public CustomSystemException(String message, Throwable cause) {
		super(message, cause);
	}
}
