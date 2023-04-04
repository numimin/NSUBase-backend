package com.github.numi.teachers.json;

public class StudentsOfCourseWithMarksQuery {
    private Integer[] marks;
    private Long[] groupIds;

    public StudentsOfCourseWithMarksQuery(Integer[] marks, Long[] groupIds) {
        this.marks = marks;
        this.groupIds = groupIds;
    }

    public StudentsOfCourseWithMarksQuery() {}

    public Integer[] getMarks() {
        return marks;
    }

    public void setMarks(Integer[] marks) {
        this.marks = marks;
    }

    public Long[] getGroupIds() {
        return groupIds;
    }

    public void setGroupIds(Long[] groupIds) {
        this.groupIds = groupIds;
    }
}
