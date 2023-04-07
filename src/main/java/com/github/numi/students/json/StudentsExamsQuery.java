package com.github.numi.students.json;

import com.github.numi.utils.DateStruct;

import java.util.Date;

public class StudentsExamsQuery {
    private Long[] groupIds;
    private Long[] lessonIds;
    private Integer[] terms;
    private DateStruct start;
    private DateStruct end;

    public StudentsExamsQuery() {}

    public Long[] getLessonIds() {
        return lessonIds;
    }

    public void setLessonIds(Long[] lessonIds) {
        this.lessonIds = lessonIds;
    }

    public Integer[] getTerms() {
        return terms;
    }

    public void setTerms(Integer[] terms) {
        this.terms = terms;
    }

    public DateStruct getStart() {
        return start;
    }

    public void setStart(DateStruct start) {
        this.start = start;
    }

    public DateStruct getEnd() {
        return end;
    }

    public void setEnd(DateStruct end) {
        this.end = end;
    }

    public Long[] getGroupIds() {
        return groupIds;
    }

    public void setGroupIds(Long[] groupIds) {
        this.groupIds = groupIds;
    }
}
