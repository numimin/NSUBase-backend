package com.github.numi.teachers.json;

public class DepartmentsQuery {
    private Long[] faculties;

    public DepartmentsQuery(Long[] faculties) {
        this.faculties = faculties;
    }

    public DepartmentsQuery() {}

    public void setFaculties(Long[] faculties) {
        this.faculties = faculties;
    }

    public Long[] getFaculties() {
        return faculties;
    }
}
