/**
 * Copyright 2016 GwynnieBee Inc.
 */

package com.nitrkl.timetable.ui;

import android.util.Log;

import com.alamkanak.weekview.WeekViewEvent;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.nitrkl.timetable.objects.Period;
import com.nitrkl.timetable.utils.DataProvider;
import com.nitrkl.timetable.utils.PeriodUtils;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * This is the activity for configuring the Teacher Time Table.
 *
 * @author eswar
 * @version 1.00
 * @since 15/11/2016
 */
public class TeacherActivity extends BaseActivity {

    private static final String TAG = "TeacherActivity ";

    @Override
    public List<? extends WeekViewEvent> onMonthChange(int newYear, int newMonth) {
        Log.i(TAG, "The onMonthChange method has been called.");
        List<WeekViewEvent> events = new ArrayList<>();

        Type listType = new TypeToken<ArrayList<Period>>(){}.getType();
        List<com.nitrkl.timetable.objects.Period> periodList = new Gson().fromJson(DataProvider.TEACHER_TIME_TABLE, listType);
        for (Period period : periodList) {
            Log.d(TAG, new Gson().toJson(PeriodUtils.getAllPeriodEvents(period, newYear, newMonth)));
            List<WeekViewEvent> tempEvents = PeriodUtils.getAllPeriodEvents(period, newYear, newMonth);
            for (WeekViewEvent weekViewEvent : tempEvents) {
                events.add(weekViewEvent);
            }
        }

        return events;
    }
}
