package com.school.Little.School.model;

import jakarta.persistence.*;

@Entity
@Table(name="roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
}
