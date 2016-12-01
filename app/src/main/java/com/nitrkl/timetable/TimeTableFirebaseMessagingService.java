package com.nitrkl.timetable;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.google.gson.Gson;
import com.nitrkl.timetable.objects.Period;
import com.nitrkl.timetable.ui.SplashActivity;
import com.nitrkl.timetable.utils.Preference;

import java.util.Calendar;
import java.util.HashMap;

/**
 * Created by no-games on 08-10-2016.
 */
public class TimeTableFirebaseMessagingService extends FirebaseMessagingService {

    private static final String TAG = "Firebase Messages";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        Log.d(TAG, "From: " + remoteMessage.getFrom());
        HashMap<String, String> data = new HashMap<>();

        // Check if message contains a data payload.
        if (remoteMessage.getData().size() > 0) {
            data.putAll(remoteMessage.getData());
            Log.d(TAG, "Message data payload: " + data);
            processStartNotification(data);
        }

        // Check if message contains a notification payload.
        if (remoteMessage.getNotification() != null) {
            Log.d(TAG, "Message Notification Body: " + remoteMessage.getNotification().getBody());
            processStartNotification(data);
        }

        // Also if you intend on generating your own notifications as a result of a received FCM
        // message, here is where that should be initiated. See sendNotification method below.
    }

    private void processStartNotification(HashMap<String, String> message) {
        String title = "Huhuhu";
        String text = "The class is about to start";
        String to = null;
        String till = null;
        String start;
        Calendar dt = Calendar.getInstance();
        Calendar st = Calendar.getInstance();
        if (message != null) {
            if ("cancelled".equals(message.get("action"))) {
                title = " Class Cancelled";
            } else if ("re-scheduled".equals(message.get("action"))) {
                title = " Class Re-Scheduled";
                try {
                    st.setTimeInMillis(Long.parseLong(message.get("re_end")));
                    till = st.get(Calendar.HOUR_OF_DAY) + ":" + st.get(Calendar.MINUTE);
                    st.setTimeInMillis(Long.parseLong(message.get("re_start")));
                    to = st.get(Calendar.HOUR_OF_DAY) + ":" + st.get(Calendar.MINUTE);
                } catch (Exception e) {}
            }
            try {
                Period period = new Gson().fromJson(message.get("period"), Period.class);
                title = period.getPeriodName() + title;
                start = message.get("start");
                if (till != null && to != null) {
                    period.setStartTime(to);
                    period.setEndTime(till);
                    Preference.getInstance(getApplicationContext()).saveChangedClass(start, period);
                } else {
                    Preference.getInstance(getApplicationContext()).saveChangedClass(start, null);
                }
                dt.setTimeInMillis(Long.parseLong(start));
                start = dt.getTime().toString().replaceAll("/\\s+GMT.*/", "");
                if (to != null) {
                    text = "To: " + to + " From: " + start;
                } else {
                    text = period.getPeriodName() + " class on " + start + " has been " + message.get("action");
                }
            } catch (Exception e) {
                Log.e(TAG, "unable to decode the period object sent.");
            }
        }

        final NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setContentTitle(title)
                .setAutoCancel(false)
                .setColor(ContextCompat.getColor(this, R.color.colorPrimary))
                .setContentText(text)
                .setSmallIcon(R.drawable.notification_icon);

        int notificationId = (int) (Math.random() * 10);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,
                notificationId,
                new Intent(this, SplashActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK),
                PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);
        builder.setDeleteIntent(NotificationEventReceiver.getDeleteIntent(this));
        builder.setDefaults(Notification.DEFAULT_SOUND|Notification.FLAG_SHOW_LIGHTS|Notification.DEFAULT_VIBRATE);

        final NotificationManager manager = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(notificationId, builder.build());
    }
}
