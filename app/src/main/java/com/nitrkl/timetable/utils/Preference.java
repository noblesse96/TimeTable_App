/**
 * Copyright 2016 GwynnieBee Inc.
 */

package com.nitrkl.timetable.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.gson.Gson;
import com.nitrkl.timetable.objects.Period;

/**
 * Preference for persisting changes.
 *
 * @author eswar
 * @version 1.0
 * @since 02/12/2016
 */
public class Preference {

    private static final String PREF_KEY = "eswar.PREFERENCE_FILE_KEY";
    private static final String LOGIN_MODE = "LOGIN_MODE";

    private static Preference sPreference = null;

    private Context mContext;
    private SharedPreferences mSharedPreferences;

    private Preference(Context context) {
        mContext = context;
        mSharedPreferences = mContext.getSharedPreferences(PREF_KEY, Context.MODE_PRIVATE);
    }

    public static Preference getInstance(Context context) {
        if (sPreference == null) {
            synchronized (Preference.class) {
                if (sPreference == null) {
                    sPreference = new Preference(context);
                }
            }
        }
        return sPreference;
    }

    public void saveChangedClass(@NonNull String time, @NonNull Period period) {
        Log.i("Pref", "Saving to preference " + time + " period " + new Gson().toJson(period));
        mSharedPreferences.edit()
                .putString(time, new Gson().toJson(period))
                .apply();
    }

    public boolean isClassChanged(long time) {
        Log.i("Pref", "Checking for " + time);
        return !"".equals(mSharedPreferences.getString("" + time, ""));
    }

    public Period getChangedClass(long time, Period period) {
        String per = mSharedPreferences.getString(time + "", "");
        if ("".equals(per)) return null;
        return new Gson().fromJson(per, Period.class);
    }

    public void setTeacherMode() {
        mSharedPreferences.edit()
                .putString(LOGIN_MODE, "teacher")
                .apply();
    }
    public void setStudentMode() {
        mSharedPreferences.edit()
                .putString(LOGIN_MODE, "student")
                .apply();
    }
    public void clearLogin() {
        mSharedPreferences
                .edit()
                .remove(LOGIN_MODE)
                .commit();
    }
    public void clearComplete() {
        mSharedPreferences
                .edit()
                .clear()
                .commit();
    }

    public boolean isTeacherMode() {
        return "teacher".equals(mSharedPreferences.getString(LOGIN_MODE, ""));
    }

    public boolean isStudentMode() {
        return "student".equals(mSharedPreferences.getString(LOGIN_MODE, ""));
    }

}
