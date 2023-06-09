package com.school.Little.School.controller;

import com.school.Little.School.exception.ResourceNotFoundException;
import com.school.Little.School.model.Student;
import com.school.Little.School.model.Teacher;
import com.school.Little.School.repository.TeacherRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/teacher/{id}")
    public ResponseEntity<Teacher> getTeacherById(@PathVariable long id){
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("No teacher with the given Id:" + id));
        return ResponseEntity.ok(teacher);
    }
    @DeleteMapping("/delete-teacher/{id}")
    public ResponseEntity<String> deleteTeacherById(@PathVariable long id) {
        Optional<Teacher> optionalTeacher = teacherRepository.findById(id);
        if (optionalTeacher.isEmpty()) {
            throw new ResourceNotFoundException("No teacher with the given Id: " + id);
        }

        teacherRepository.delete(optionalTeacher.get());
        return ResponseEntity.ok("Teacher with ID " + id + " has been deleted successfully.");
    }
    @PutMapping("/update-teacher/{id}")
    public ResponseEntity<Teacher> updateStudent(@PathVariable long id, @RequestBody Teacher updatedTeacher) {
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No teacher with the given Id: " + id));

        // Update the student attributes
        teacher.setName(updatedTeacher.getName());
        teacher.setEmail(updatedTeacher.getEmail());
        teacher.setPhone(updatedTeacher.getPhone());
        teacher.setDepartment_name(updatedTeacher.getDepartment_name());
        teacher.setUser(updatedTeacher.getUser());

        Teacher newStudent =   teacherRepository.save(teacher);

        return ResponseEntity.ok(newStudent);
    }



}
