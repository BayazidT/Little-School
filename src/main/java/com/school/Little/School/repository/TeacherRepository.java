package com.school.Little.School.repository;

import com.school.Little.School.model.Teacher;
import com.school.Little.School.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    Optional<Teacher> findByEmail(String email);
}
