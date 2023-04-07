package com.github.numi.teachers.json;

import com.github.numi.teachers.enums.LessonType;

public class Load {
    public Load(Lesson[] lessons, Type[] types) {
        this.lessons = lessons;
        this.types = types;
    }

    public Lesson[] getLessons() {
        return lessons;
    }

    public void setLessons(Lesson[] lessons) {
        this.lessons = lessons;
    }

    public Type[] getTypes() {
        return types;
    }

    public void setTypes(Type[] types) {
        this.types = types;
    }

    private Lesson[] lessons;
    private Type[] types;
}
