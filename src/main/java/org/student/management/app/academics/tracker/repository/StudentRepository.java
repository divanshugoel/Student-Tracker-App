package org.student.management.app.academics.tracker.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.student.management.app.academics.tracker.model.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {
	@Query("Select student from Student student where student.email =:email")
	Optional<Student> findByEmail(String email);
}
