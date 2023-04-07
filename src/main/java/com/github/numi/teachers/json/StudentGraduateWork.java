package com.github.numi.teachers.json;

import com.github.numi.students.entities.StudentEntity;
import com.github.numi.students.json.Student;
import com.github.numi.teachers.entities.GraduateWorkEntity;

public class StudentGraduateWork {
    private Student student;
    private String graduateWorkTheme;

    public StudentGraduateWork(StudentEntity student, GraduateWorkEntity graduateWork) {
        this.student = new Student(student);
        this.graduateWorkTheme = graduateWork.getTheme();
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
}
