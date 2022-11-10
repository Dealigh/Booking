package com.qualitest.booking.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Time {

    private Calendar calendar = new GregorianCalendar();

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    private Date todaysDate = new Date();

    public String dateToString(Date date) {
        return sdf.format(date);
    }

    public void setCalendarTravel() {
        calendar.setTime(todaysDate);
        calendar.add(Calendar.MONTH, +2);
    }

    public String getDateCheckInDate() {
        setCalendarTravel();
        Date date = calendar.getTime();
        return dateToString(date);
    }

    public String getDateCheckOutDate() {
        setCalendarTravel();
        calendar.add(Calendar.DAY_OF_MONTH, +10);
        Date date = calendar.getTime();
        return dateToString(date);
    }

    public boolean getMonthCalendarPage(String month) {
        String search = calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH) + " " + calendar.get(Calendar.YEAR);
        if(search.equals(month)) {
            return true;
        } else return false;
    }
}
