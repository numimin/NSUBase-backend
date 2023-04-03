package com.github.numi.teachers.json;

import com.github.numi.teachers.entities.DepartmentEntity;

public class Department {
    private Long id;
    private String name;
    private Long facultyId;

    public Department(Long id, String name, Long facultyId) {
        this.id = id;
        this.name = name;
        this.facultyId = facultyId;
    }

    public Department(DepartmentEntity entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.facultyId = entity.getFaculty().getId();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getFacultyId() {
        return facultyId;
    }
}
