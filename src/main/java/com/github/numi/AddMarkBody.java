package com.github.numi;

import com.github.numi.utils.DateStruct;

public class AddMarkBody {
    private Integer mark;
    private DateStruct date;
    private Long studentId;
    private Long lessonId;

    protected AddMarkBody() {}

    public AddMarkBody(Integer mark, DateStruct date, Long studentId, Long lessonId) {
        this.mark = mark;
        this.date = date;
        this.studentId = studentId;
        this.lessonId = lessonId;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public DateStruct getDate() {
        return date;
    }

    public void setDate(DateStruct date) {
        this.date = date;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getLessonId() {
        return lessonId;
    }

    public void setLessonId(Long lessonId) {
        this.lessonId = lessonId;
    }
}
