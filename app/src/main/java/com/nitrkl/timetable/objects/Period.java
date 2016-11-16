/**
 * Copyright 2016 GwynnieBee Inc.
 */

package com.nitrkl.timetable.objects;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.util.Log;

import com.alamkanak.weekview.WeekViewEvent;
import com.google.gson.annotations.SerializedName;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Period object as per the requirements.
 *
 * @author eswar
 * @version 1.00
 * @since 15/11/2016
 */
public class Period {

    @SerializedName("name")
    private String mPeriodName;

    @SerializedName("dayOfWeek")
    private int mDayOfWeek;

    @SerializedName("startTime")
    private String mStartTime;

    @SerializedName("endTime")
    private String mEndTime;

    @SerializedName("color")
    private String mColor;

    /**
     * Gets the value of mPeriodName of the instance.
     *
     * @return {java.lang.String}
     */
    public String getPeriodName() {
        return mPeriodName;
    }

    /**
     * Gets the value of mDayOfWeek of the instance.
     *
     * @return {int}
     */
    public int getDayOfWeek() {
        return mDayOfWeek;
    }

    /**
     * Gets the value of mStartTime of the instance.
     *
     * @return {java.lang.String}
     */
    public String getStartTime() {
        return mStartTime;
    }

    /**
     * Gets the value of mEndTime of the instance.
     *
     * @return {java.lang.String}
     */
    public String getEndTime() {
        return mEndTime;
    }

    /**
     * Gets the value of mColor of the instance.
     *
     * @return {java.lang.String}
     */
    public String getColor() {
        return mColor;
    }

    @SuppressLint("SimpleDateFormat")
    public WeekViewEvent toWeekViewEvent(){

        // Parse time.
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        Date start = new Date();
        Date end = new Date();
        try {
            start = sdf.parse(mStartTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            end = sdf.parse(mEndTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Initialize start and end time.
        Calendar now = Calendar.getInstance();
        Calendar startTime = (Calendar) now.clone();
        startTime.setTimeInMillis(start.getTime());
        startTime.set(Calendar.YEAR, now.get(Calendar.YEAR));
        startTime.set(Calendar.MONTH, now.get(Calendar.MONTH));
        startTime.set(Calendar.DAY_OF_WEEK, mDayOfWeek);
        Calendar endTime = (Calendar) startTime.clone();
        endTime.setTimeInMillis(end.getTime());
        endTime.set(Calendar.YEAR, startTime.get(Calendar.YEAR));
        endTime.set(Calendar.MONTH, startTime.get(Calendar.MONTH));
        endTime.set(Calendar.DAY_OF_WEEK, mDayOfWeek);

        // Create an week view event.
        WeekViewEvent weekViewEvent = new WeekViewEvent();
        weekViewEvent.setName(mPeriodName);
        weekViewEvent.setStartTime(startTime);
        weekViewEvent.setEndTime(endTime);
//        weekViewEvent.setColor(Color.parseColor(getColor()));

        return weekViewEvent;
    }

}
