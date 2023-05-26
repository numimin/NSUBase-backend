package com.github.numi.add;

import com.github.numi.utils.DateStruct;

public class AddGroupBody {
    private String name;
    private DateStruct date;
    private Long facultyId;

    protected AddGroupBody() {}

    public AddGroupBody(String name, DateStruct date, Long facultyId) {
        this.name = name;
        this.date = date;
        this.facultyId = facultyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DateStruct getDate() {
        return date;
    }

    public void setDate(DateStruct date) {
        this.date = date;
    }

    public Long getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(Long facultyId) {
        this.facultyId = facultyId;
    }
}
