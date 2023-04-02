package com.github.numi.json;

public class GroupQuery {
    private Long[] faculties;

    public GroupQuery(Long[] faculties) {
        this.faculties = faculties;
    }

    public GroupQuery() {}

    public void setFaculties(Long[] faculties) {
        this.faculties = faculties;
    }

    public Long[] getFaculties() {
        return faculties;
    }
}
