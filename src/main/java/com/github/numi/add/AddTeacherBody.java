package com.github.numi.add;

import com.github.numi.students.enums.Gender;
import com.github.numi.teachers.entities.DepartmentEntity;
import com.github.numi.teachers.enums.Category;
import com.github.numi.utils.DateStruct;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

public class AddTeacherBody {
    private String firstname;
    private String lastname;
    private String patronymic;
    private Category category;
    private Gender gender;
    private Boolean hasChildren;
    private Integer salary;
    private Boolean graduateStudent;
    private DateStruct phdThesisDate;
    private Long departmentId;

    private String phdDissertation;
    private String doctoralDissertation;

    public AddTeacherBody(String firstname,
                         String lastname,
                         String patronymic,
                         Category category,
                         Gender gender,
                         Boolean hasChildren,
                         Integer salary,
                         Boolean graduateStudent,
                         DateStruct phdThesisDate,
                         Long departmentId,
                         String phdDissertation,
                         String doctoralDissertation) {
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
        this.phdDissertation = phdDissertation;
        this.doctoralDissertation = doctoralDissertation;
    }

    protected AddTeacherBody() {}

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

    public DateStruct getPhdThesisDate() {
        return phdThesisDate;
    }

    public void setPhdThesisDate(DateStruct phdThesisDate) {
        this.phdThesisDate = phdThesisDate;
    }

    public String getPhdDissertation() {
        return phdDissertation;
    }

    public void setPhdDissertation(String phdDissertation) {
        this.phdDissertation = phdDissertation;
    }

    public String getDoctoralDissertation() {
        return doctoralDissertation;
    }

    public void setDoctoralDissertation(String doctoralDissertation) {
        this.doctoralDissertation = doctoralDissertation;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }
}
