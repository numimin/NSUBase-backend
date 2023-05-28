package com.github.numi;

public class AddDepartmentBody {
    private String name;
    private Long facultyId;

    protected AddDepartmentBody() {}

    public AddDepartmentBody(String name, Long facultyId) {
        this.name = name;
        this.facultyId = facultyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(Long facultyId) {
        this.facultyId = facultyId;
    }
}
