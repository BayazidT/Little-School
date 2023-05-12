package com.school.Little.School.controller;

import com.school.Little.School.exception.ResourceNotFoundException;
import com.school.Little.School.model.Teacher;
import com.school.Little.School.repository.TeacherRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class TeacherController {
    private final TeacherRepository teacherRepository;
    public TeacherController(TeacherRepository teacherRepository){
        this.teacherRepository = teacherRepository;
    }

    @GetMapping("/teacher-list")
    public List<Teacher> getAllTeacher(){
        return teacherRepository.findAll();
    }

    @PostMapping("/insert-teacher")
    public Teacher insertTeacher(@RequestBody Teacher teacher){
        return teacherRepository.save(teacher);
    }

    @GetMapping("teacher/{id}")
    public ResponseEntity<Teacher> getTeacherById(@PathVariable long id){
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("No teacher with the given Id:" + id));
        return ResponseEntity.ok(teacher);
    }

}
