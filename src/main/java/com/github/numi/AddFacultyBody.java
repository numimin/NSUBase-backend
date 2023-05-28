package com.github.numi;

public class AddFacultyBody {
    private String name;
    public AddFacultyBody(String name) {
        this.name = name;
    }

    protected AddFacultyBody() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
