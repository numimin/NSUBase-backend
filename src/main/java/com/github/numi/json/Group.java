package com.github.numi.json;

import com.github.numi.entities.GroupEntity;

public class Group {
    private Long id;
    private String name;
    private Long facultyId;

    public Group(Long id, String name, Long facultyId) {
        this.id = id;
        this.name = name;
        this.facultyId = facultyId;
    }

    public Group(GroupEntity entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.facultyId = entity.getFaculty().getId();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getFacultyId() {
        return facultyId;
    }
}
