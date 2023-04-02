package com.github.numi.json;

import com.github.numi.entities.FacultyEntity;

public class Faculty {
    private Long id;
    private String name;

    public Faculty(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Faculty(FacultyEntity entity) {
        this.id = entity.getId();
        this.name = entity.getName();
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
