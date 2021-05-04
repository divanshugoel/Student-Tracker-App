package org.student.management.app.academics.tracker.response.dto;

//import java.util.Date;

public class ResponseHeaderDTO {
	
	private String transactionId;
//	private Date responseTimeStamp;
	private String responseTime;
	private String responseStatus;
	private int responseCode;
	private ErrorDTO error;
	
	
	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

//	public Date getResponseTimeStamp() {
//		return responseTimeStamp;
//	}
//
//	public void setResponseTimeStamp(Date responseTimeStamp) {
//		this.responseTimeStamp = responseTimeStamp;
//	}

	public String getResponseTime() {
		return responseTime;
	}

	public void setResponseTime(String responseTime) {
		this.responseTime = responseTime;
	}

	public String getResponseStatus() {
		return responseStatus;
	}

	public void setResponseStatus(String responseStatus) {
		this.responseStatus = responseStatus;
	}

	public int getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

	public ErrorDTO getError() {
		return error;
	}

	public void setError(ErrorDTO error) {
		this.error = error;
	}

}
