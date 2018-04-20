package com.example.hp.alarmserviceexample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.provider.Settings;

public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
      MainActivity mainActivity=MainActivity.getInstance();
      mainActivity.tx.setText("Wake Up!");
        MediaPlayer m= MediaPlayer.create(context, Settings.System.DEFAULT_ALARM_ALERT_URI);
        m.setLooping(true);
        m.start();
       Intent i= new Intent(context,AlarmNotificationService.class);
       context.startService(i);
    }
}
