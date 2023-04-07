package com.github.numi.teachers.entities;

import com.github.numi.students.entities.StudentEntity;

import javax.persistence.*;

@Entity
public class GraduateWorkEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String theme;
    @ManyToOne
    @JoinColumn(name="student_id", nullable = false)
    private StudentEntity student;
    @ManyToOne
    @JoinColumn(name="teacher_id", nullable = false)
    private TeacherEntity teacher;

    public GraduateWorkEntity(String theme, StudentEntity student, TeacherEntity teacher) {
        this.theme = theme;
        this.student = student;
        this.teacher = teacher;
    }

    protected GraduateWorkEntity() {}

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StudentEntity getStudent() {
        return student;
    }

    public void setStudent(StudentEntity student) {
        this.student = student;
    }

    public TeacherEntity getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherEntity teacher) {
        this.teacher = teacher;
    }
}
