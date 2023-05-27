package com.school.Little.School.model;

import com.school.Little.School.user.Role;
import com.school.Little.School.user.User;
import jakarta.persistence.*;
import jakarta.transaction.UserTransaction;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "teacher")
public class Teacher{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;
    private String phone;
    private String password;
    private String department_name;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Column(name = "is_active", columnDefinition = "BOOLEAN DEFAULT TRUE")
    private boolean isActive;
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

}
