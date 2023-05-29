package com.github.numi;

import com.github.numi.teachers.enums.LessonType;

public class AddLessonBody {
    private String name;
    private Long teacherId;
    private Long groupId;
    private Integer term;
    private Integer course;
    private LessonType type;
    private Long hours;

    protected AddLessonBody() {}

    public AddLessonBody(String name, Long teacherId, Long groupId, Integer term, Integer course, LessonType type, Long hours) {
        this.name = name;
        this.teacherId = teacherId;
        this.groupId = groupId;
        this.term = term;
        this.course = course;
        this.type = type;
        this.hours = hours;
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
