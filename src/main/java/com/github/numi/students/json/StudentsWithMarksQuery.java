package com.github.numi.students.json;

public class StudentsWithMarksQuery {
    private Long[] groupIds;

    public StudentsWithMarksQuery(Long[] groupIds) {
        this.groupIds = groupIds;
    }

    public StudentsWithMarksQuery() {}

    public Long[] getGroupIds() {
        return groupIds;
    }

    public void setGroupIds(Long[] groupIds) {
        this.groupIds = groupIds;
    }
}
