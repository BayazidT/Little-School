package com.school.Little.School.controller;

import com.school.Little.School.model.Student;
import com.school.Little.School.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/student-list")
    public List<Student> getAllStudent(){
        return studentRepository.findAll();
    }

    @PostMapping("/insert-student")
    public Student insertStudent(@RequestBody Student student){
        return studentRepository.save(student);
    }
}
