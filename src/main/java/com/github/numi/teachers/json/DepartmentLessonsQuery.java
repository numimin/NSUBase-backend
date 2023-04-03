package com.github.numi.teachers.json;

import com.github.numi.utils.DateStruct;

public class DepartmentLessonsQuery {
    private DateStruct start;
    private DateStruct end;

    public DepartmentLessonsQuery(DateStruct start, DateStruct end) {
        this.start = start;
        this.end = end;
    }

    public DepartmentLessonsQuery() {}

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
}
