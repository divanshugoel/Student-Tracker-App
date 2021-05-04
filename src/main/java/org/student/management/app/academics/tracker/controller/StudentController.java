package org.student.management.app.academics.tracker.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.student.management.app.academics.tracker.model.Student;
import org.student.management.app.academics.tracker.request.dto.StudentRequestDTO;
import org.student.management.app.academics.tracker.response.dto.GeneralErrorEnum;
import org.student.management.app.academics.tracker.response.dto.StudentResponse;
import org.student.management.app.academics.tracker.response.dto.StudentResponseDTO;
import org.student.management.app.academics.tracker.service.impl.StudentServiceImpl;
import org.student.management.app.academics.tracker.util.ApplicationUtil;
import org.student.management.app.academics.tracker.util.ValidationUtil;

@RestController
@RequestMapping("/api/student")
public class StudentController {

	@Autowired
	StudentServiceImpl studentService;
	private static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

	@GetMapping
	public StudentResponse getStudent(@RequestParam("id") String studentId) {
		long startTime = System.currentTimeMillis();
		if (studentId == null) {
			System.out.println("id cannot be null");
			LOGGER.info("id cannot be null");
			throw new IllegalStateException("id cannot be null");
		}
		System.out.println("entered into the get student method");
		Student student = studentService.getStudent(Integer.parseInt(studentId));
		StudentResponseDTO studentResponseDTO = mapObjects(student);
		return ApplicationUtil.prepareResponse(studentResponseDTO, GeneralErrorEnum.SUCCESS, startTime);

	}

//	@GetMapping("/{id}")
//	public StudentResponseDTO getStudent(@PathVariable("id") Integer studentId) {
//		System.out.println("entered into the get student method");
//		Student student = studentService.getStudent(studentId);
//		return mapObjects(student);
//	}

	@GetMapping("/all")
	public List<StudentResponseDTO> getAllStudents() {
		System.out.println("eneter here");
		List<StudentResponseDTO> studentListResponse = new ArrayList<StudentResponseDTO>();
		List<Student> allStudents = studentService.getAllStudents();
		for (Student student : allStudents) {
			StudentResponseDTO studentResponseDto = mapObjects(student);
			studentListResponse.add(studentResponseDto);
		}
		return studentListResponse;
	}

	@PostMapping("/save")
	public StudentResponse createStudent(@RequestBody StudentRequestDTO studentrequest) throws Exception {
		long startTime = System.currentTimeMillis();
		ValidationUtil.validate(studentrequest, "POST");
		Student createdStudent = studentService.createStudent(studentrequest);
		StudentResponseDTO studentResponseDTO = mapObjects(createdStudent);
		return ApplicationUtil.prepareResponse(studentResponseDTO, GeneralErrorEnum.SUCCESS, startTime);
	}

	@PutMapping("/update")
	public StudentResponse updateStudent(@RequestBody StudentRequestDTO studentrequest) {
		long startTime = System.currentTimeMillis();
		ValidationUtil.validate(studentrequest, "PUT");
		Student updatedStudent = studentService.updateStudent(studentrequest);
		StudentResponseDTO studentResponseDTO = mapObjects(updatedStudent);
		return ApplicationUtil.prepareResponse(studentResponseDTO, GeneralErrorEnum.SUCCESS, startTime);

	}

	@DeleteMapping("/{id}")
	public String deleteStudent(@PathVariable("id") Integer studentId) {

		studentService.deleteStudent(studentId);
		return " student with studentid " + studentId + " deleted successfully ";
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	private StudentResponseDTO mapObjects(Student student) {
		StudentResponseDTO studentResponse = new StudentResponseDTO();
		studentResponse.setFirstName(student.getFirstName());
		studentResponse.setLastName(student.getLastName());
		studentResponse.setEmail(student.getEmail());
		studentResponse.setStudentId(student.getId());
		studentResponse.setUserName(student.getUserName());
		return studentResponse;
	}

}
