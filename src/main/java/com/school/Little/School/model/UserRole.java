package com.school.Little.School.model;

import com.school.Little.School.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_role")
public class UserRole {

    @Id
    private long id;
    @OneToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
