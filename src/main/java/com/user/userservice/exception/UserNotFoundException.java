package com.user.userservice.exception;

public class UserNotFoundException extends RuntimeException {

	/**
	 * Field name to create a custom error response for not found exception,
	 */
	private String message;
	private String errorName;

	public UserNotFoundException(String message, String errorName) {
		this.errorName = errorName;
		this.message = message;

	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getErrorName() {
		return errorName;
	}

	public void setErrorName(String errorName) {
		this.errorName = errorName;
	}

}
