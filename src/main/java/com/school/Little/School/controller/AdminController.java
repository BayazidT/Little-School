package com.school.Little.School.controller;

import com.school.Little.School.model.Admin;
import com.school.Little.School.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class AdminController {

//    @Autowired
    private final AdminRepository adminRepository;

    public AdminController(AdminRepository adminRepository){
        this.adminRepository = adminRepository;
    }

    @GetMapping("/admin-list")
    public List<Admin> getAllAdmin(){
        return adminRepository.findAll();
    }
}
