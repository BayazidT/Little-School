package com.school.Little.School.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int cb;
    private String cd;
    private int ub;
    private String ud;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
}
