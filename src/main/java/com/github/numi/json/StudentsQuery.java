package com.github.numi.json;

public class StudentsQuery {
    private Long[] groups;

    public StudentsQuery(Long[] groups) {
        this.groups = groups;
    }

    public StudentsQuery() {}

    public Long[] getGroups() {
        return groups;
    }

    public void setGroups(Long[] groups) {
        this.groups = groups;
    }
}
