package org.student.management.app.academics.tracker.response.dto;

public class BaseResponseDTO<T> {

	private ResponseHeaderDTO responseHeader;

	private T responseBody;

	public ResponseHeaderDTO getResponseHeader() {
		return responseHeader;
	}

	public void setResponseHeader(ResponseHeaderDTO responseHeader) {
		this.responseHeader = responseHeader;
	}

	public T getResponseBody() {
		return responseBody;
	}

	public void setResponseBody(T responseBody) {
		this.responseBody = responseBody;
	}
}
