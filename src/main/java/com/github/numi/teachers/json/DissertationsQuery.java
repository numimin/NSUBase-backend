package com.github.numi.teachers.json;

public class DissertationsQuery {
    private Long[] faculties;
    private Long[] departments;

    public DissertationsQuery(Long[] faculties, Long[] departments) {
        this.faculties = faculties;
        this.departments = departments;
    }

    public DissertationsQuery() {}

    public Long[] getFaculties() {
        return faculties;
    }

    public void setFaculties(Long[] faculties) {
        this.faculties = faculties;
    }

    public Long[] getDepartments() {
        return departments;
    }

    public void setDepartments(Long[] departments) {
        this.departments = departments;
    }
}
