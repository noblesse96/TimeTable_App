/**
 * Copyright 2016 GwynnieBee Inc.
 */

package com.nitrkl.timetable.ui;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.graphics.RectF;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

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
import com.nitrkl.timetable.R;
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
    private int mEditStart = -1;
    private int mEditEnd = -1;

    enum Actions {
        CANCEL,
        RESCHEDULE
    }

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
    public void onEventLongPress(final WeekViewEvent event, RectF eventRect) {
        if (event.getId() == 1233333) {
            mEditStart = -1;
            mEditEnd = -1;
            final Dialog dialog = new Dialog(TeacherActivity.this);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setCancelable(true);
            dialog.setContentView(R.layout.teacher_edit);
            dialog.findViewById(R.id.btn_cancel).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    classUpdate(event, Actions.CANCEL, dialog);
                    dialog.findViewById(R.id.btn_cancel).setClickable(false);
                    dialog.findViewById(R.id.btn_reschedule).setClickable(false);
                }
            });

            final TextView start = (TextView) dialog.findViewById(R.id.start_time);
            final TextView end = (TextView) dialog.findViewById(R.id.end_time);
            start.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Calendar mcurrentTime = Calendar.getInstance();
                    int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                    int minute = mcurrentTime.get(Calendar.MINUTE);
                    TimePickerDialog mTimePicker;
                    mTimePicker = new TimePickerDialog(TeacherActivity.this, new TimePickerDialog.OnTimeSetListener() {
                        @Override
                        public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                            mEditStart = selectedHour * 100 + selectedMinute;
                            if (mEditEnd != -1 && mEditEnd < mEditStart) {
                                Toast.makeText(getApplicationContext(), "Class cannot start after it has ended!!", Toast.LENGTH_SHORT).show();
                            } else {
                                start.setText(selectedHour + " : " + selectedMinute);
                            }
                        }
                    }, hour, minute, true);
                    mTimePicker.setTitle("Start Class At");
                    mTimePicker.show();
                }
            });

            end.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Calendar mcurrentTime = Calendar.getInstance();
                    int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                    int minute = mcurrentTime.get(Calendar.MINUTE);
                    TimePickerDialog mTimePicker;
                    mTimePicker = new TimePickerDialog(TeacherActivity.this, new TimePickerDialog.OnTimeSetListener() {
                        @Override
                        public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                            mEditEnd = selectedHour * 100 + selectedMinute;
                            if (mEditStart != -1 && mEditEnd < mEditStart) {
                                Toast.makeText(getApplicationContext(), "Class cannot end before it even started!!", Toast.LENGTH_SHORT).show();
                            } else {
                                end.setText(selectedHour + " : " + selectedMinute);
                            }
                        }
                    }, hour, minute, true);
                    mTimePicker.setTitle("End Class At");
                    mTimePicker.show();
                }
            });

            dialog.findViewById(R.id.btn_reschedule).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Calendar now = Calendar.getInstance();
                    int cur = now.get(Calendar.HOUR_OF_DAY) * 100 + now.get(Calendar.MINUTE);
                    if (mEditEnd == -1 || mEditStart == -1 || mEditEnd < mEditStart) {
                        Toast.makeText(getApplicationContext(), "Please Select proper class timings!!", Toast.LENGTH_SHORT).show();
                    } else if (mEditStart < cur) {
                        Toast.makeText(getApplicationContext(), "Class should have already started!!", Toast.LENGTH_SHORT).show();
                    } else {
                        classUpdate(event, Actions.RESCHEDULE, dialog);
                        dialog.findViewById(R.id.btn_cancel).setClickable(false);
                        dialog.findViewById(R.id.btn_reschedule).setClickable(false);
                    }
                }
            });
            dialog.show();
        }
    }

    /**
     * update the class.
     */
    private void classUpdate(WeekViewEvent event, Actions action, final Dialog dialog) {
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(getApplication());
        String url = "https://fcm.googleapis.com/fcm/send";
        // Request a string response from the provided URL.
        JsonObjectRequest stringRequest = new JsonObjectRequest(Request.Method.POST, url, getJSON(event, action),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // Display the first 500 characters of the response string.
                        Log.i("RESPONSE", response.toString());
                        dialog.findViewById(R.id.btn_cancel).setOnClickListener(null);
                        dialog.findViewById(R.id.btn_reschedule).setOnClickListener(null);
                        dialog.dismiss();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("RESPONSE", error.toString());
                Toast.makeText(getApplicationContext(), "OOPS something has gone wrong!! Try Again....", Toast.LENGTH_SHORT).show();
                dialog.findViewById(R.id.btn_cancel).setClickable(true);
                dialog.findViewById(R.id.btn_reschedule).setClickable(true);
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
    private JSONObject getJSON(WeekViewEvent event, Actions action) {
        JSONObject obj = new JSONObject();
        JSONObject ob2 = new JSONObject();
        JSONObject ob3 = new JSONObject();
        Calendar start = event.getStartTime();
        Calendar end = event.getEndTime();
        Log.i("Db", new Gson().toJson(event.toString()));

        try {
            obj.put("to", "/topics/c_03_004");
            obj.put("priority", "high");
            if (action == Actions.CANCEL) {
                ob2.put("title", "Class cancelled");
                ob2.put("action", "cancelled");
            } else {
                ob2.put("title", "Class re-scheduled");
                ob2.put("action", "re-scheduled");
                ob2.put("re_start", mEditStart);
                ob2.put("re_end", mEditEnd);
            }
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
