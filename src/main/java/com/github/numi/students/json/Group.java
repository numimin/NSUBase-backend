package com.github.numi.students.json;

import com.github.numi.students.entities.GroupEntity;
import com.github.numi.utils.DateStruct;

public class Group {
    private Long id;
    private String name;
    private Long facultyId;

    private DateStruct date;

    public Group(Long id, String name, Long facultyId, DateStruct date) {
        this.id = id;
        this.name = name;
        this.facultyId = facultyId;
        this.date = date;
    }

    public Group(GroupEntity entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.facultyId = entity.getFaculty().getId();
        this.date = new DateStruct(entity.getDate());
    }

    public Group() {}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getFacultyId() {
        return facultyId;
    }

    public DateStruct getDate() {
        return date;
    }

    public void setDate(DateStruct date) {
        this.date = date;
    }
}
