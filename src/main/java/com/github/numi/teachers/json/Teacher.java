package com.github.numi.teachers.json;

import com.github.numi.students.enums.Gender;
import com.github.numi.teachers.entities.TeacherEntity;
import com.github.numi.teachers.enums.Category;

import java.time.LocalDate;

public class Teacher {
    private Long id;
    private String firstname;
    private String lastname;
    private String patronymic;
    private Category category;
    private Gender gender;
    private Boolean hasChildren;
    private Integer salary;
    private Boolean graduateStudent;
    private LocalDate phdThesisDate;
    private Long departmentId;

    public Teacher(Long id,
                   String firstname,
                   String lastname,
                   String patronymic,
                   Category category,
                   Gender gender,
                   Boolean hasChildren,
                   Integer salary,
                   Boolean graduateStudent,
                   LocalDate phdThesisDate,
                   Long departmentId) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.patronymic = patronymic;
        this.category = category;
        this.gender = gender;
        this.hasChildren = hasChildren;
        this.salary = salary;
        this.graduateStudent = graduateStudent;
        this.phdThesisDate = phdThesisDate;
        this.departmentId = departmentId;
    }

    public Teacher(TeacherEntity entity) {
        this.id = entity.getId();
        this.firstname = entity.getFirstname();
        this.lastname = entity.getLastname();
        this.patronymic = entity.getPatronymic();
        this.category = entity.getCategory();
        this.gender = entity.getGender();
        this.hasChildren = entity.getHasChildren();
        this.salary = entity.getSalary();
        this.graduateStudent = entity.getGraduateStudent();
        this.phdThesisDate = entity.getPhdThesisDate();
        this.departmentId = entity.getDepartment().getId();
    }

    public Long getId() {
        return id;
    }

    public Boolean getGraduateStudent() {
        return graduateStudent;
    }

    public Boolean getHasChildren() {
        return hasChildren;
    }

    public Category getCategory() {
        return category;
    }

    public Gender getGender() {
        return gender;
    }

    public Integer getSalary() {
        return salary;
    }

    public LocalDate getPhdThesisDate() {
        return phdThesisDate;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPatronymic() {
        return patronymic;
    }
}

