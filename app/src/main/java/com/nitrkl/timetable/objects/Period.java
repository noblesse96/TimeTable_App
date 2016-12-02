/**
 * Copyright 2016 GwynnieBee Inc.
 */

package com.nitrkl.timetable.objects;

import com.google.gson.annotations.SerializedName;

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

    public void setStartTime(String startTime) {
        mStartTime = startTime;
    }

    public void setEndTime(String endTime) {
        mEndTime = endTime;
    }

    @Override
    public int hashCode() {
        int falka;
        try {
            falka = Integer.parseInt(mCourseId.replaceAll("_", "").replace("c", ""));
        } catch (NumberFormatException e) {
            falka = (int) (Math.random() * 1000);
        }
        return mDayOfWeek*10000+falka;
    }
}
