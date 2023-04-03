package com.github.numi.students.json;

public class StudentsQuery {
    private Long[] groups;
    private Long[] faculties;

    public StudentsQuery(Long[] groups, Long[] faculties) {
        this.groups = groups;
        this.faculties = faculties;
    }

    public StudentsQuery() {}

    public Long[] getGroups() {
        return groups;
    }

    public void setGroups(Long[] groups) {
        this.groups = groups;
    }

    public Long[] getFaculties() {
        return faculties;
    }

    public void setFaculties(Long[] faculties) {
        this.faculties = faculties;
    }
}
