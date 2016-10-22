package com.nitrkl.timetable;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by no-games on 10-10-2016.
 */
public class Period {
    String mPeriodName;
    Calendar mTimeFrame;
    int mPicture;

    // calendar instance
    // period name;
    // lecturer name;
    // notes;

    public Period(String periodName, String day, TimeSlot timePeriod){

        //"11-10-2016"
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-mm-yyyy");
        Date dt;

        try {
            dt =simpleDateFormat.parse(day);
        } catch (ParseException ex) {
            dt = new Date();
        }

        int hour = 0 ;
        int minutes = 0;

//        mPicture = picture;
        mPeriodName = periodName;
        mTimeFrame = Calendar.getInstance();
        mTimeFrame.setTime(dt);

        switch (timePeriod){
            case M_1:
                hour = 8;
                break;
            case M_2:
                hour = 9;
                break;
            case M_3:
                hour = 10;
                break;
            case M_4:
                hour = 11;
                break;
            case A_1:
                hour = 13;
                minutes = 15;
                break;
            case A_2:
                hour = 14;
                minutes = 15;
                break;
            case A_3:
                hour = 15;
                minutes = 15;
                break;
            case A_4:
                hour = 16;
                minutes = 15;
                break;
            case DEBUG:
                hour = 13;
                minutes = 26;
                break;
        };

        mTimeFrame.set(Calendar.HOUR_OF_DAY, hour);
        mTimeFrame.set(Calendar.MINUTE, minutes);
        mTimeFrame.set(Calendar.SECOND, 0);

    }
}
