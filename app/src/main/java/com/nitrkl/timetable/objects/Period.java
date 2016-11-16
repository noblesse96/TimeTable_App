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

    @SerializedName("courseId")
    private String mCourseId;

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

    /**
     * Gets the value of mCourseId of the instance.
     *
     * @return {java.lang.String}
     */
    public String getCourseId() {
        return mCourseId;
    }

}
