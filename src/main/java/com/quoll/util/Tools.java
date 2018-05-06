package com.quoll.util;

import java.util.Calendar;
import java.util.Date;

public class Tools {
    public static Date getCurrentYMD(){
        Date now = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(now);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    public static Date addDays(Date date, int days){
        long time = date.getTime();
        days = days*24*60*60*1000;
        time += days;
        return new Date(time);
    }
}
