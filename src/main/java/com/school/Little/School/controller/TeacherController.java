package com.school.Little.School.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class TeacherController {

    @GetMapping("/teacher")
    private ResponseEntity<String> getExample() {

        return ResponseEntity.ok("This is a teacher endpoint");
    }
}
