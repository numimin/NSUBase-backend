package com.github.numi.teachers.json;

import com.github.numi.teachers.entities.LessonEntity;
import com.github.numi.teachers.enums.LessonType;

import java.util.Objects;

public class Lesson {
    private Long id;
    private String name;
    private Long teacherId;
    private Long groupId;
    private Integer term;
    private Integer course;
    private LessonType type;
    private Long hours;

    public Lesson(Long id, String name, Long teacherId, Long groupId, Integer term, Integer course, LessonType type, Long hours) {
        this.id = id;
        this.name = name;
        this.teacherId = teacherId;
        this.groupId = groupId;
        this.term = term;
        this.course = course;
        this.type = type;
        this.hours = hours;
    }

    public Lesson(LessonEntity entity) {
        id = entity.getId();
        name = entity.getName();
        teacherId = entity.getTeacher().getId();
        groupId = entity.getGroup().getId();
        term = entity.getTerm();
        course = entity.getCourse();
        type = entity.getType();
        hours = entity.getHours();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lesson lesson = (Lesson) o;
        return Objects.equals(id, lesson.id) && Objects.equals(name, lesson.name) && Objects.equals(teacherId, lesson.teacherId) && Objects.equals(groupId, lesson.groupId) && Objects.equals(term, lesson.term) && Objects.equals(course, lesson.course);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, teacherId, groupId, term, course);
    }

    public LessonType getType() {
        return type;
    }

    public void setType(LessonType type) {
        this.type = type;
    }

    public Long getHours() {
        return hours;
    }

    public void setHours(Long hours) {
        this.hours = hours;
    }
}
