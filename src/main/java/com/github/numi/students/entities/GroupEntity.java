package com.github.numi.students.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class GroupEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "group")
    private Set<StudentEntity> students;

    @ManyToOne
    @JoinColumn(name="faculty_id", nullable = false)
    private FacultyEntity faculty;

    protected GroupEntity() {}

    public GroupEntity(String name, FacultyEntity faculty) {
        this.name = name;
        this.faculty = faculty;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FacultyEntity getFaculty() {
        return faculty;
    }

    public void setFaculty(FacultyEntity faculty) {
        this.faculty = faculty;
    }
}
