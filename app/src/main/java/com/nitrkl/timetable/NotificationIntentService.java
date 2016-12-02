package com.nitrkl.timetable;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;

import com.google.gson.Gson;
import com.nitrkl.timetable.objects.Period;
import com.nitrkl.timetable.ui.SplashActivity;
import com.nitrkl.timetable.utils.Preference;

import java.util.Calendar;

/**
 * Created by no-games on 09-10-2016.
 */
public class NotificationIntentService extends IntentService {
    private static final int NOTIFICATION_ID = 1;
    private static final String ACTION_START = "ACTION_START";
    private static final String ACTION_DELETE = "ACTION_DELETE";

    public NotificationIntentService() {
        super(NotificationIntentService.class.getSimpleName());
    }

    public static Intent createIntentStartNotificationService(Context context, Intent inpInt) {
        Intent intent = new Intent(context, NotificationIntentService.class);
        intent.setAction(ACTION_START);
        if (inpInt != null && inpInt.getStringExtra("period") != null) {
            intent.putExtra("period", inpInt.getStringExtra("period"));
        }
        return intent;
    }

    public static Intent createIntentDeleteNotification(Context context) {
        Intent intent = new Intent(context, NotificationIntentService.class);
        intent.setAction(ACTION_DELETE);
        return intent;
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d(getClass().getSimpleName(), "onHandleIntent, started handling a notification event");
        try {
            String action = intent.getAction();
            String perStr = intent.getStringExtra("period");
            Period period = null;
            if (perStr != null) {
                period = new Gson().fromJson(perStr, Period.class);
            }
            if (ACTION_START.equals(action)) {
                processStartNotification(period);
            }
            if (ACTION_DELETE.equals(action)) {
                processDeleteNotification(intent);
            }
        } finally {
            WakefulBroadcastReceiver.completeWakefulIntent(intent);
        }
    }

    private void processDeleteNotification(Intent intent) {
        // Log something?
    }

    private void processStartNotification(Period period) {
        String title = " Class About to Start.";
        String text = "The class is about to start";
        String start;
        if (period != null) {
            try {
                title = period.getPeriodName() + title;
                start = period.getStartTime();
                text = " Class starts at " + start;
            } catch (Exception e) {
                Log.e("Alarm", "unable to decode the period object sent.");
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
        builder.setDefaults(Notification.DEFAULT_SOUND | Notification.FLAG_SHOW_LIGHTS | Notification.DEFAULT_VIBRATE);

        final NotificationManager manager = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(notificationId, builder.build());
    }
}
