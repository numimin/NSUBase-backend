package com.github.numi.add;

import com.github.numi.students.entities.StudentEntity;
import com.github.numi.students.enums.Gender;
import com.github.numi.utils.DateStruct;

import java.time.LocalDate;

public class AddStudentBody {
    private String firstname;
    private String lastname;
    private String patronymic;
    private DateStruct dateOfBirth;
    private Gender gender;
    private Boolean hasChildren;
    private Integer scholarship;

    private Long groupId;

    public AddStudentBody(String firstname,
                   String lastname,
                   String patronymic,
                   DateStruct dateOfBirth,
                   Gender gender,
                   Boolean hasChildren,
                   Integer scholarship,
                   Long groupId) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.patronymic = patronymic;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.hasChildren = hasChildren;
        this.scholarship = scholarship;
        this.groupId = groupId;
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

    public DateStruct getDateOfBirth() {
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
