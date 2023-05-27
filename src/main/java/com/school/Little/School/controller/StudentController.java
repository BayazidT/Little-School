package com.school.Little.School.controller;

import com.school.Little.School.exception.ResourceNotFoundException;
import com.school.Little.School.model.Student;
import com.school.Little.School.model.Teacher;
import com.school.Little.School.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    @GetMapping("/student/{id}")
    public ResponseEntity<Student> getTeacherById(@PathVariable long id){
        Student student = studentRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("No teacher with the given Id:" + id));
        return ResponseEntity.ok(student);
    }
    @DeleteMapping("/delete-student/{id}")
    public ResponseEntity<String>deleteTeacherById(@PathVariable long id){
        Student student = studentRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("No student with the given Id:" + id));

        studentRepository.delete(student);
        return ResponseEntity.ok("Student with the id: "+id+" is deleted successfully");
    }
}
