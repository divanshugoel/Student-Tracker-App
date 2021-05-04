package org.student.management.app.academics.tracker.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.student.management.app.academics.tracker.exceptions.AppException;
import org.student.management.app.academics.tracker.model.Student;
import org.student.management.app.academics.tracker.repository.StudentRepository;
import org.student.management.app.academics.tracker.request.dto.StudentRequestDTO;
import org.student.management.app.academics.tracker.response.dto.GeneralErrorEnum;
import org.student.management.app.academics.tracker.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;

	private static AtomicLong idCounter = new AtomicLong();

	@Override
	public Student getStudent(Integer id) {
		Student student = new Student();
		Optional<Student> studentEntity = studentRepository.findById(id);
		if (studentEntity.isPresent()) {
			student = studentEntity.get();
		} else {
			throw new AppException(GeneralErrorEnum.ERR_MISSING_STUDENT.getCode(),
					GeneralErrorEnum.ERR_MISSING_STUDENT.getErrorMessage());

		}
		return student;
	}

	@Override
	public Student createStudent(StudentRequestDTO studentRequest) throws Exception {
		Student student = new Student();
		student.setUserName(createUserName());
		student.setRegNumber(student.getUserName());
		mapObjectsToStudent(studentRequest, student);
		if (studentExistsByEmail(student)) {
			throw new Exception("student exists already, cannot add");
		}
		Student addedStudnet = studentRepository.save(student);
		System.out.println(" student by the username " + student.getUserName() + " added successfully ");
		return addedStudnet;
	}

	@Override
	public Student updateStudent(StudentRequestDTO studentRequest) {
		Integer studentId = studentRequest.getStudentId();
		Optional<Student> student = studentRepository.findById(studentId);
		if (!student.isPresent()) {
			throw new AppException(GeneralErrorEnum.ERR_MISSING_STUDENT.getCode(),
					GeneralErrorEnum.ERR_MISSING_STUDENT.getErrorMessage());

		}

		Student updatedStudent = student.get();
		mapObjectsToStudent(studentRequest, updatedStudent);
		Student studentEntity = studentRepository.save(updatedStudent);
		System.out.println(" student by the username " + updatedStudent.getUserName() + " updated successfully ");
		return studentEntity;
	}

	@Override
	public void deleteStudent(Integer id) {
		if (studentRepository.existsById(id)) {
			studentRepository.deleteById(id);
		} else {
			throw new AppException(GeneralErrorEnum.ERR_MISSING_STUDENT.getCode(),
					GeneralErrorEnum.ERR_MISSING_STUDENT.getErrorMessage());
		}
	}

	@Override
	public List<Student> getAllStudents() {
		List<Student> students = new ArrayList<Student>();
		Iterable<Student> studentList = studentRepository.findAll();
		for (Student student : studentList) {
			students.add(student);
		}
		return students;
	}

	private Student mapObjectsToStudent(StudentRequestDTO studentRequest, Student student) {
		student.setFirstName(studentRequest.getFirstName());
		student.setLastName(studentRequest.getLastName());
		student.setEmail(studentRequest.getEmail());
		student.setPassword(studentRequest.getPassword());
		student.setPhoneNumber(studentRequest.getPhoneNumber());
		student.setCity(studentRequest.getCity());
		student.setState(studentRequest.getState());
		return student;
	}

	private String createUserName() {
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		StringBuffer sb = new StringBuffer();
		sb.append(year).append("00").append(idCounter.getAndIncrement());
		String userName = sb.toString();
		return userName;

	}

	private boolean studentExistsByEmail(Student student) {
		Optional<Student> studentE = studentRepository.findByEmail(student.getEmail());
		if (!studentE.isPresent()) {
			return false;
		}
		return true;
	}

}
