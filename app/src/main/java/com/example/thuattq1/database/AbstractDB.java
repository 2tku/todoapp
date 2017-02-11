package com.example.thuattq1.database;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by thuattq1 on 2/10/2017.
 */

public abstract class AbstractDB {
    public static final String DBFLOW_DATE_FORMAT = "EEE MMM dd HH:mm:ss ZZZZZ yyyy";
    public static SimpleDateFormat sDateFormat = new SimpleDateFormat(DBFLOW_DATE_FORMAT);

    static {
        sDateFormat.setLenient(true);
    }

    public static Date parseDate(String date) throws ParseException {
        return sDateFormat.parse(date);
    }

    public static String formatDate(Date date) {
        return sDateFormat.format(date);
    }
}
