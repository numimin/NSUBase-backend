package com.github.numi.teachers.json;

import com.github.numi.students.entities.StudentEntity;
import com.github.numi.students.json.Student;
import com.github.numi.teachers.entities.GraduateWorkEntity;

public class StudentGraduateWork {
    private Student student;
    private String graduateWorkTheme;
    private Long id;
    private Long teacherId;
    private Long studentId;

    public StudentGraduateWork(StudentEntity student, GraduateWorkEntity graduateWork, Long id) {
        this.student = new Student(student);
        this.graduateWorkTheme = graduateWork.getTheme();
        this.id = id;
        this.studentId = graduateWork.getStudent().getId();
        this.teacherId = graduateWork.getTeacher().getId();
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getGraduateWorkTheme() {
        return graduateWorkTheme;
    }

    public void setGraduateWorkTheme(String graduateWorkTheme) {
        this.graduateWorkTheme = graduateWorkTheme;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }
}
