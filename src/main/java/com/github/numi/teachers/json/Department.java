package com.github.numi.teachers.json;

import com.github.numi.teachers.entities.DepartmentEntity;

import java.util.Objects;

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

    @Override
    public int hashCode() {
        return Objects.hash(id, name, facultyId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(facultyId, that.facultyId);
    }
}
