package com.github.numi.students.entities;

import com.github.numi.teachers.entities.DepartmentEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class FacultyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "faculty")
    private Set<GroupEntity> groups;

    @OneToMany(mappedBy = "faculty")
    private Set<DepartmentEntity> departments;

    protected FacultyEntity() {}

    public FacultyEntity(String name) {
        this.name = name;
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

    public void setGroups(Set<GroupEntity> groups) {
        this.groups = groups;
    }

    public Set<DepartmentEntity> getDepartments() {
        return departments;
    }

    public void setDepartments(Set<DepartmentEntity> departments) {
        this.departments = departments;
    }

    public Set<GroupEntity> getGroups() {
        return groups;
    }
}
