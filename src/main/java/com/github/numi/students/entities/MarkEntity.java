package com.github.numi.students.entities;

import com.github.numi.teachers.entities.LessonEntity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class MarkEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name="lesson_id", nullable = false)
    private LessonEntity lesson;
    @ManyToOne
    @JoinColumn(name="student_id", nullable = false)
    private StudentEntity student;
    private Integer mark;
    private LocalDate date;

    public MarkEntity(LessonEntity lesson, StudentEntity student, Integer mark, LocalDate date) {
        this.lesson = lesson;
        this.student = student;
        this.mark = mark;
        this.date = date;
    }

    protected MarkEntity() {}

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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
