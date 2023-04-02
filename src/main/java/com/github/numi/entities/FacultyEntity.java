package com.github.numi.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class FacultyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "faculty")
    private Set<GroupEntity> groups;

    protected FacultyEntity() {}

    public FacultyEntity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setGroups(Set<GroupEntity> groups) {
        this.groups = groups;
    }
}
