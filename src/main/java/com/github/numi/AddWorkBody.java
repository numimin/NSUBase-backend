package com.github.numi;

public class AddWorkBody {
    private String theme;
    private Long studentId;
    private Long teacherId;

    protected AddWorkBody() {}

    public AddWorkBody(String theme, Long studentId, Long teacherId) {
        this.theme = theme;
        this.studentId = studentId;
        this.teacherId = teacherId;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }
}
