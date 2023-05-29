package com.github.numi;

import com.github.numi.utils.DateStruct;

public class MarkString {
    private Long id;
    private Integer mark;
    private String lesson;
    private String student;
    private Long lessonId;
    private Long studentId;
    private DateStruct date;

    protected MarkString() {}

    public MarkString(Long id, Integer mark, String lesson, String student, Long lessonId, Long studentId, DateStruct date) {
        this.id = id;
        this.mark = mark;
        this.lesson = lesson;
        this.student = student;
        this.lessonId = lessonId;
        this.studentId = studentId;
        this.date = date;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public String getLesson() {
        return lesson;
    }

    public void setLesson(String lesson) {
        this.lesson = lesson;
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLessonId() {
        return lessonId;
    }

    public void setLessonId(Long lessonId) {
        this.lessonId = lessonId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }
}
