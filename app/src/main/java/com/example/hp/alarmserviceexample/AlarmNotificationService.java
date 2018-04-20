package com.example.hp.alarmserviceexample;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

public class AlarmNotificationService extends IntentService {

    public AlarmNotificationService() {
        super("Notification Service");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        NotificationCompat.Builder nb= new NotificationCompat.Builder(this);
        nb.setContentTitle("Alarm")
                .setContentText("Alarm ringing")
                .setAutoCancel(true);
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(1,nb.build());

    }
}
