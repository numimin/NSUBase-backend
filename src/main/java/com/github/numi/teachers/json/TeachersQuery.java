package com.github.numi.teachers.json;

import com.github.numi.utils.DateStruct;

public class TeachersQuery {
    private Long[] faculties;
    private Long[] departments;
    private DateStruct phdThesisStartDate;
    private DateStruct phdThesisEndDate;

    public TeachersQuery() {}

    public void setDepartments(Long[] departments) {
        this.departments = departments;
    }

    public void setFaculties(Long[] faculties) {
        this.faculties = faculties;
    }

    public void setPhdThesisEndDate(DateStruct phdThesisEndDate) {
        this.phdThesisEndDate = phdThesisEndDate;
    }

    public void setPhdThesisStartDate(DateStruct phdThesisStartDate) {
        this.phdThesisStartDate = phdThesisStartDate;
    }

    public Long[] getFaculties() {
        return faculties;
    }

    public DateStruct getPhdThesisEndDate() {
        return phdThesisEndDate;
    }

    public DateStruct getPhdThesisStartDate() {
        return phdThesisStartDate;
    }

    public Long[] getDepartments() {
        return departments;
    }
}
