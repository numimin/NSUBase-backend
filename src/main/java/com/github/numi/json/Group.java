package com.github.numi.json;

import com.github.numi.entities.GroupEntity;

public class Group {
    private Long id;
    private String name;

    public Group(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Group(GroupEntity entity) {
        this.id = entity.getId();
        this.name = entity.getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
