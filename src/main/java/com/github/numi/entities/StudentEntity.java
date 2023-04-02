package com.github.numi.entities;

import com.github.numi.enums.Gender;
import com.github.numi.json.Group;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstname;
    private String lastname;
    private String patronymic;
    private LocalDate dateOfBirth;
    private Gender gender;
    private Boolean hasChildren;
    private Integer scholarship;

    @ManyToOne
    @JoinColumn(name="group_id", nullable = false)
    private GroupEntity group;
    protected StudentEntity() {}
    public StudentEntity(String firstname,
                            String lastname,
                            String patronymic,
                            LocalDate dateOfBirth,
                            Gender gender,
                            Boolean hasChildren,
                            Integer scholarship,
                            GroupEntity group) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.patronymic = patronymic;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.hasChildren = hasChildren;
        this.scholarship = scholarship;
        this.group = group;
    }

    public Long getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Boolean getHasChildren() {
        return hasChildren;
    }

    public void setHasChildren(Boolean hasChildren) {
        this.hasChildren = hasChildren;
    }

    public Integer getScholarship() {
        return scholarship;
    }

    public void setScholarship(Integer scholarship) {
        this.scholarship = scholarship;
    }

    public GroupEntity getGroup() {
        return group;
    }

    public void setGroup(GroupEntity group) {
        this.group = group;
    }
}
