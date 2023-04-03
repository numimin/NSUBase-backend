package com.github.numi.teachers.entities;

import com.github.numi.students.entities.GroupEntity;

import javax.persistence.*;

@Entity
public class LessonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name="teacher_id", nullable = false)
    private TeacherEntity teacher;
    @ManyToOne
    @JoinColumn(name="group_id", nullable = false)
    private GroupEntity group;
    private Integer term;
    private Integer course;

    public LessonEntity(String name,
                        TeacherEntity teacher,
                        GroupEntity group,
                        Integer term,
                        Integer course) {
        this.name = name;
        this.teacher = teacher;
        this.group = group;
        this.term = term;
        this.course = course;
    }

    protected LessonEntity() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TeacherEntity getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherEntity teacher) {
        this.teacher = teacher;
    }

    public GroupEntity getGroup() {
        return group;
    }

    public void setGroup(GroupEntity group) {
        this.group = group;
    }

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }

    public Integer getCourse() {
        return course;
    }

    public void setCourse(Integer course) {
        this.course = course;
    }
}
