package com.github.numi.utils;

import java.time.LocalDate;
import java.util.Date;

public class DateStruct {
    public int year;
    public int month;
    public int day;

    public DateStruct(LocalDate date) {
        year = date.getYear();
        month = date.getMonthValue();
        day = date.getDayOfMonth();
    }

    public DateStruct() {}

    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "DateStruct{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }
}
