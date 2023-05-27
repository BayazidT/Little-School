package com.school.Little.School.repository;

import com.school.Little.School.model.Student;
import com.school.Little.School.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Teacher> findByEmail(String email);
}
