package org.student.management.app.academics.tracker.util;

import java.util.List;
import java.util.UUID;

import org.student.management.app.academics.tracker.response.dto.GeneralErrorEnum;
import org.student.management.app.academics.tracker.response.dto.ResponseHeaderDTO;
import org.student.management.app.academics.tracker.response.dto.StudentResponse;
import org.student.management.app.academics.tracker.response.dto.StudentResponseDTO;

public class ApplicationUtil {
	private ApplicationUtil() {

	}

	public static StudentResponse prepareResponse(StudentResponseDTO studentResponseDTO, GeneralErrorEnum responseStatus,
			long startTime) {
		StudentResponse studentResponse = new StudentResponse();
		studentResponse.setResponseBody(studentResponseDTO);
		studentResponse.setResponseHeader(prepareResponseHeader(responseStatus, startTime));

		return studentResponse;
	}
	

	private static ResponseHeaderDTO prepareResponseHeader(GeneralErrorEnum responseStatus, long startTime) {
		ResponseHeaderDTO responseHeaderDTO = new ResponseHeaderDTO();

		responseHeaderDTO.setTransactionId(UUID.randomUUID().toString());
		responseHeaderDTO.setResponseCode(responseStatus.getCode());
		responseHeaderDTO.setResponseStatus(responseStatus.getErrorMessage());
		responseHeaderDTO.setResponseTime(String.valueOf(System.currentTimeMillis() - startTime));
		return responseHeaderDTO;
	}
}
