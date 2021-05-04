package org.student.management.app.academics.tracker.service;

import java.util.List;

import org.student.management.app.academics.tracker.model.Student;
import org.student.management.app.academics.tracker.request.dto.StudentRequestDTO;

public interface StudentService {

	public Student getStudent(Integer id);

	public Student createStudent(StudentRequestDTO studentRequest)throws Exception;

	public Student updateStudent(StudentRequestDTO studentRequest);

	public void deleteStudent(Integer id);

	public List<Student> getAllStudents();
}
