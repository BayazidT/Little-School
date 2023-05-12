package com.school.Little.School.auth;

import com.school.Little.School.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.school.Little.School.config.JwtService;
import com.school.Little.School.repository.TeacherRepository;
import org.springframework.security.crypto.password.PasswordEncoder;


@Service
@RequiredArgsConstructor
public class TeacherAuthenticationService {
    private final TeacherRepository teacherRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        var teacher = teacherRepository.findByEmail(request.getEmail())
                .orElseThrow();

        if (passwordEncoder.matches(request.getPassword(), teacher.getPassword())) {
            var jwtToken = jwtService.generateToken(teacher);
            return AuthenticationResponse.builder().token(jwtToken).build();
        } else {
            throw new ResourceNotFoundException("Bad Credentials");
        }

    }
}

