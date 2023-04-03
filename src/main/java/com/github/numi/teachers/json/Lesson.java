package com.github.numi.teachers.json;

import com.github.numi.teachers.entities.LessonEntity;

public class Lesson {
    private Long id;
    private String name;
    private Long teacherId;
    private Long groupId;
    private Integer term;
    private Integer course;

    public Lesson(Long id, String name, Long teacherId, Long groupId, Integer term, Integer course) {
        this.id = id;
        this.name = name;
        this.teacherId = teacherId;
        this.groupId = groupId;
        this.term = term;
        this.course = course;
    }

    public Lesson(LessonEntity entity) {
        id = entity.getId();
        name = entity.getName();
        teacherId = entity.getTeacher().getId();
        groupId = entity.getGroup().getId();
        term = entity.getTerm();
        course = entity.getCourse();
    }

    public Lesson() {}

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

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
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
