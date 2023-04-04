package com.github.numi.teachers.json;

public class LessonsQuery {
    private Long[] groupIds;

    public LessonsQuery(Long[] groupIds) {
        this.groupIds = groupIds;
    }

    public LessonsQuery() {}

    public Long[] getGroupIds() {
        return groupIds;
    }

    public void setGroupIds(Long[] groupIds) {
        this.groupIds = groupIds;
    }
}
