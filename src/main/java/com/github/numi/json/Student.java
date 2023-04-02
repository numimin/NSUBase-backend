package com.github.numi.json;

import com.github.numi.entities.StudentEntity;
import com.github.numi.enums.Gender;

import java.time.LocalDate;

public class Student {
    private String firstname;
    private String lastname;
    private String patronymic;
    private LocalDate dateOfBirth;
    private Gender gender;
    private Boolean hasChildren;
    private Integer scholarship;

    public Student(String firstname, String lastname, String patronymic, LocalDate dateOfBirth, Gender gender, Boolean hasChildren, Integer scholarship) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.patronymic = patronymic;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.hasChildren = hasChildren;
        this.scholarship = scholarship;
    }

    public Student(StudentEntity entity) {
        this.firstname = entity.getFirstname();
        this.lastname = entity.getLastname();
        this.patronymic = entity.getPatronymic();
        this.dateOfBirth = entity.getDateOfBirth();
        this.gender = entity.getGender();
        this.hasChildren = entity.getHasChildren();
        this.scholarship = entity.getScholarship();
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
}
