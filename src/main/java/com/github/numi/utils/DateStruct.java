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
}
