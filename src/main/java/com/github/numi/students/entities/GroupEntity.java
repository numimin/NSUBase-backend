package com.github.numi.students.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class GroupEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    private LocalDate date;
    private LocalDate end_;

    @OneToMany(mappedBy = "group")
    private Set<StudentEntity> students;

    @ManyToOne
    @JoinColumn(name="faculty_id", nullable = false)
    private FacultyEntity faculty;

    protected GroupEntity() {}

    public GroupEntity(String name, LocalDate date, FacultyEntity faculty) {
        this.name = name;
        this.date = date;
        this.faculty = faculty;
        this.end_ = date.plusMonths(5);
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getEnd_() {
        return end_;
    }

    public void setEnd_(LocalDate end) {
        this.end_ = end;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
