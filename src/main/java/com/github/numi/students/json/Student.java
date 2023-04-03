package com.github.numi.students.json;

import com.github.numi.students.entities.StudentEntity;
import com.github.numi.students.enums.Gender;

import java.time.LocalDate;

public class Student {
    private Long id;
    private String firstname;
    private String lastname;
    private String patronymic;
    private LocalDate dateOfBirth;
    private Gender gender;
    private Boolean hasChildren;
    private Integer scholarship;

    private Long groupId;

    public Student(Long id,
                   String firstname,
                   String lastname,
                   String patronymic,
                   LocalDate dateOfBirth,
                   Gender gender,
                   Boolean hasChildren,
                   Integer scholarship,
                   Long groupId) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.patronymic = patronymic;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.hasChildren = hasChildren;
        this.scholarship = scholarship;
        this.groupId = groupId;
    }

    public Student(StudentEntity entity) {
        this.id = entity.getId();
        this.firstname = entity.getFirstname();
        this.lastname = entity.getLastname();
        this.patronymic = entity.getPatronymic();
        this.dateOfBirth = entity.getDateOfBirth();
        this.gender = entity.getGender();
        this.hasChildren = entity.getHasChildren();
        this.scholarship = entity.getScholarship();
        this.groupId = entity.getGroup().getId();
    }

    public Long getId() {
        return id;
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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public Boolean getHasChildren() {
        return hasChildren;
    }

    public Integer getScholarship() {
        return scholarship;
    }

    public Long getGroupId() {
        return groupId;
    }
}