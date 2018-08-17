package com.capgemini.exception;

public class IncorrectParameterException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public IncorrectParameterException() {
		super("Incorrect parameter");
	}

	public IncorrectParameterException(String message) {
		super("Incorrect parameter" + message);
	}
}
