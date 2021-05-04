package org.student.management.app.academics.tracker.util;

import org.springframework.util.Assert;
import org.student.management.app.academics.tracker.request.dto.StudentRequestDTO;

public class ValidationUtil {
	public static void validate(StudentRequestDTO studentRequest, String method) {
		if (method.equals("PUT")) {
			Assert.notNull(studentRequest.getStudentId(), " id cannot be null , student cannot be updated ");
		}
		Assert.notNull(studentRequest, "student request object cannot be null");
		Assert.hasText(studentRequest.getFirstName(), "student first name cannot be null or empty ");
		Assert.hasText(studentRequest.getLastName(), "student last name cannot be null or empty ");
		Assert.hasText(studentRequest.getEmail(), "student e-mail cannot be null or empty ");
		isValidEmail(studentRequest.getEmail(), "enter a valid email address");
		Assert.hasText(studentRequest.getPhoneNumber(), "student phone number cannot be nullor empty ");
		isValidNumber(studentRequest.getPhoneNumber(), "invalid phone number");
		Assert.hasText(studentRequest.getPassword(), "student password cannot be null or empty");
		Assert.hasText(studentRequest.getCity(), "student city cannot be null or empty ");
		Assert.hasText(studentRequest.getState(), "student state cannot be nullor empty ");
	}

	private static void isValidNumber(String phoneNumber, String message) {
		String regex = "[7-9][0-9]{9}";
		if (!phoneNumber.matches(regex)) {
			throw new IllegalArgumentException(message);
		}

	}

	private static void isValidEmail(String email, String message) {
		String regex = "^(.+)@(.+)$";
		if (!email.matches(regex)) {
			throw new IllegalArgumentException(message);
		}

	}

}
