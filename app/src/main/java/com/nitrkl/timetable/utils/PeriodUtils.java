/**
 * Copyright 2016 GwynnieBee Inc.
 */

package com.nitrkl.timetable.utils;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.util.Log;

import com.alamkanak.weekview.WeekViewEvent;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.gson.Gson;
import com.nitrkl.timetable.objects.Period;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Utility class for the period related change.
 *
 * @author eswar
 * @version 1.00
 * @since 15/11/2016
 */
public class PeriodUtils {

    private static final String TAG = "PeriodUtils";

    @SuppressLint("SimpleDateFormat")
    public static List<WeekViewEvent> getAllPeriodEvents(Period period, int newYear, int newMonth) {
        List<WeekViewEvent> events = new ArrayList<>();

        // Parse time.
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        Date start = new Date();
        Date end = new Date();
        try {
            start = sdf.parse(period.getStartTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            end = sdf.parse(period.getEndTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Calendar first = Calendar.getInstance();
        first.set(Calendar.MONTH, newMonth - 1);
        first.set(Calendar.YEAR, newYear);
        first.set(Calendar.DAY_OF_MONTH, 1);
        int startDayOfMonth = first.get(Calendar.DAY_OF_WEEK);
        int daysOfMonth = first.getActualMaximum(Calendar.DAY_OF_MONTH);
        int day = period.getDayOfWeek();
        int offset = startDayOfMonth - first.getFirstDayOfWeek() + 1; // Ideal day is sunday.
        Log.i(TAG, "First day of the month is - " + startDayOfMonth + " total days - " + daysOfMonth);

        day -= offset;
        if (day < 1) {
            day += first.getActualMaximum(Calendar.DAY_OF_WEEK);
        }
        while (day < daysOfMonth) {
            // Initialize start and end time.
            Calendar now = Calendar.getInstance();
            Calendar startTime = (Calendar) now.clone();
            startTime.setTimeInMillis(start.getTime());
            startTime.set(Calendar.YEAR, newYear);
            startTime.set(Calendar.MONTH, newMonth - 1);
            startTime.set(Calendar.DAY_OF_MONTH, day);
            Calendar endTime = (Calendar) startTime.clone();
            endTime.setTimeInMillis(end.getTime());
            endTime.set(Calendar.YEAR, newYear);
            endTime.set(Calendar.MONTH, newMonth - 1);
            endTime.set(Calendar.DAY_OF_MONTH, day);

            // Create an week view event.
            WeekViewEvent weekViewEvent = new WeekViewEvent();
            if ("c_03_004".equals(period.getCourseId())) {
                weekViewEvent.setId(1233333);
            }
            weekViewEvent.setName(period.getPeriodName());
            weekViewEvent.setStartTime(startTime);
            weekViewEvent.setEndTime(endTime);
            weekViewEvent.setColor(Color.parseColor(period.getColor()));

            day += first.getActualMaximum(Calendar.DAY_OF_WEEK);
            events.add(weekViewEvent);
            Log.d(TAG, "Added event - " + new Gson().toJson(weekViewEvent));
        }

        return events;
    }

    public static void subscribeToEvents(@NonNull Period period) {
        if (period.getCourseId() == null) {
            return;
        }
        FirebaseMessaging.getInstance().subscribeToTopic(period.getCourseId());
    }

}
