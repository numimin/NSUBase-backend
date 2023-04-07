package com.github.numi.teachers.json;

public class TeachersExamsQuery {
    private Long[] groupIds;
    private Long[] lessonIds;

    public TeachersExamsQuery() {}

    public Long[] getGroupIds() {
        return groupIds;
    }

    public void setGroupIds(Long[] groupIds) {
        this.groupIds = groupIds;
    }

    public Long[] getLessonIds() {
        return lessonIds;
    }

    public void setLessonIds(Long[] lessonIds) {
        this.lessonIds = lessonIds;
    }
}
