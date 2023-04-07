package com.github.numi.teachers.json;

import com.github.numi.teachers.enums.LessonType;

public class Type {
    private LessonType type;
    private Long hours;

    public Type(LessonType type, Long hours) {
        this.type = type;
        this.hours = hours;
    }

    public LessonType getType() {
        return type;
    }

    public void setType(LessonType type) {
        this.type = type;
    }

    public Long getHours() {
        return hours;
    }

    public void setHours(Long hours) {
        this.hours = hours;
    }
}
