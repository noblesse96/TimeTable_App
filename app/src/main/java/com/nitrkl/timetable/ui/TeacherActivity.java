/**
 * Copyright 2016 GwynnieBee Inc.
 */

package com.nitrkl.timetable.ui;

import android.graphics.RectF;
import android.util.Log;

import com.alamkanak.weekview.WeekViewEvent;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.nitrkl.timetable.objects.Period;
import com.nitrkl.timetable.utils.DataProvider;
import com.nitrkl.timetable.utils.PeriodUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
//            Log.d(TAG, new Gson().toJson(PeriodUtils.getAllPeriodEvents(period, newYear, newMonth)));
            List<WeekViewEvent> tempEvents = PeriodUtils.getAllPeriodEvents(period, newYear, newMonth);
            for (WeekViewEvent weekViewEvent : tempEvents) {
                events.add(weekViewEvent);
            }
        }

        return events;
    }

    @Override
    public void onEventLongPress(WeekViewEvent event, RectF eventRect) {
        Log.i("tooch", event.getId() + "");
        if (event.getId() == 1233333) {
            classUpdate(event);
        }
    }

    /**
     * update the class.
     */
    private void classUpdate(WeekViewEvent event) {
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(getApplication());
        String url = "https://fcm.googleapis.com/fcm/send";
        // Request a string response from the provided URL.
        JsonObjectRequest stringRequest = new JsonObjectRequest(Request.Method.POST, url, getJSON(event),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // Display the first 500 characters of the response string.
                        Log.i("RESPONSE", response.toString());
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("RESPONSE", error.toString());
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String>  params = new HashMap<>();
                params.put("Authorization", "key=AIzaSyCpbOfpCW32O6tmVrVpwC9ZR7JylxfVcnQ");
                return params;
            }
        };
        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }

    /**
     * Generate the json object.
     *
     * @return {{@link JSONObject}}.
     */
    private JSONObject getJSON(WeekViewEvent event) {
        JSONObject obj = new JSONObject();
        JSONObject ob2 = new JSONObject();
        JSONObject ob3 = new JSONObject();
        Calendar start = event.getStartTime();
        Calendar end = event.getEndTime();
        Log.i("Bhooyah", start.getTime().toString());

        try {
            obj.put("to", "/topics/c_03_004");
            obj.put("priority", "high");
            ob2.put("title", "Class cancelled");
            ob2.put("action", "cancelled");
            ob3.put("name", "GSM");
            ob3.put("dayOfWeek", start.get(Calendar.DAY_OF_MONTH));
            ob3.put("startTime", start.get(Calendar.HOUR_OF_DAY) + ":" + start.get(Calendar.MINUTE));
            ob3.put("endTime", end.get(Calendar.HOUR_OF_DAY) + ":" + end.get(Calendar.MINUTE));
            ob3.put("color", event.getColor());
            ob3.put("courseId", "c_03_004");
            ob2.put("period", ob3);
            ob2.put("start", start.getTime().toString());
            obj.put("data", ob2);
        } catch (JSONException ex) {}
        return obj;
    }
}
