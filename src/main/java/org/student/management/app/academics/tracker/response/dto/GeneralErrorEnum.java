package org.student.management.app.academics.tracker.response.dto;

public enum GeneralErrorEnum {

	SUCCESS(100, "SUCCESS", "Success"), FAILED(101, "FAILED", "failed to load"),
	ERR_INVALID_REQUEST(102, "ERR_INVALID_REQUEST", "Invalid Request"),
	ERR_MISSING_STUDENT(103, "ERR_MISSING_STUDENT", "student not found"),
	ERR_ALREADY_EXISTING_STUDENT(104, "ERR_ALREADY_EXISTING_STUDENT", "student already exists"),

	UNKNOWN(0, "UNKNOWN", "Unknown");

	private int code;
	private String errorCode;
	private String errorMessage;

	GeneralErrorEnum(int code, String errorCode, String errorMessage) {
		this.code = code;
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public int getCode() {
		return code;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

}
