package com.github.numi.students.json;

import com.github.numi.students.entities.MarkEntity;
import com.github.numi.students.entities.StudentEntity;
import com.github.numi.teachers.entities.LessonEntity;

public class Mark {
    private Long id;
    private LessonEntity lesson;
    private StudentEntity student;
    private Integer mark;

    public Mark(Long id, LessonEntity lesson, StudentEntity student, Integer mark) {
        this.id = id;
        this.lesson = lesson;
        this.student = student;
        this.mark = mark;
    }

    public Mark(MarkEntity entity) {
        id = entity.getId();
        lesson = entity.getLesson();
        student = entity.getStudent();
        mark = entity.getMark();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LessonEntity getLesson() {
        return lesson;
    }

    public void setLesson(LessonEntity lesson) {
        this.lesson = lesson;
    }

    public StudentEntity getStudent() {
        return student;
    }

    public void setStudent(StudentEntity student) {
        this.student = student;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }
}
