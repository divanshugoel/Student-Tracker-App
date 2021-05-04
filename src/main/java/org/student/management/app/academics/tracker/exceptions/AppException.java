package org.student.management.app.academics.tracker.exceptions;

public class AppException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private Integer errorCode;
	private String errorMessage;

	public AppException(Integer errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
}
