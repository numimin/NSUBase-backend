package com.github.numi.teachers.entities;

import com.github.numi.students.enums.Gender;
import com.github.numi.teachers.enums.Category;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class TeacherEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    @ManyToOne
    @JoinColumn(name="department_id", nullable = false)
    private DepartmentEntity department;

    public TeacherEntity(String firstname,
                         String lastname,
                         String patronymic,
                         Category category,
                         Gender gender,
                         Boolean hasChildren,
                         Integer salary,
                         Boolean graduateStudent,
                         LocalDate phdThesisDate,
                         DepartmentEntity department) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.patronymic = patronymic;
        this.category = category;
        this.gender = gender;
        this.hasChildren = hasChildren;
        this.salary = salary;
        this.graduateStudent = graduateStudent;
        this.phdThesisDate = phdThesisDate;
        this.department = department;
    }

    protected TeacherEntity() {}

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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Boolean getGraduateStudent() {
        return graduateStudent;
    }

    public void setGraduateStudent(Boolean graduateStudent) {
        this.graduateStudent = graduateStudent;
    }

    public LocalDate getPhdThesisDate() {
        return phdThesisDate;
    }

    public void setPhdThesisDate(LocalDate phdThesisDate) {
        this.phdThesisDate = phdThesisDate;
    }

    public DepartmentEntity getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentEntity department) {
        this.department = department;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
