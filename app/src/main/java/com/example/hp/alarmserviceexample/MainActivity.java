package com.example.hp.alarmserviceexample;

import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.ToggleButton;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private static MainActivity instance=null;
    EditText time;
    ToggleButton toggleButton;
    TextView tx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         time= findViewById(R.id.editText);
         toggleButton=findViewById(R.id.toggleButton);
         toggleButton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 onToggle();
             }
         });
         instance=this;
        tx=findViewById(R.id.textView);
         }

         public void showTime(View v){
          }
         public void onToggle(){
             AlarmManager alarmManager= (AlarmManager) getSystemService(ALARM_SERVICE);
             PendingIntent pendingIntent=null;
         if(toggleButton.isChecked()){
             final Calendar c=  Calendar.getInstance();
             int mHour=c.get(Calendar.HOUR_OF_DAY);
             int mMin=c.get(Calendar.MINUTE);
             TimePickerDialog tm= new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                 @Override
                 public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                     c.set(Calendar.HOUR_OF_DAY,hourOfDay);
                     c.set(Calendar.MINUTE,minute);
                 }
             },mHour,mMin,true);
             tm.show();
             Intent i= new Intent(this,AlarmReceiver.class);
              pendingIntent= PendingIntent.getBroadcast(this,0,i,0);

             alarmManager.set(AlarmManager.RTC_WAKEUP,c.getTimeInMillis(),pendingIntent);
         }
         else{
              if(pendingIntent!=null){
              alarmManager.cancel(pendingIntent);
              pendingIntent.cancel();
         }}
         }

    public static MainActivity getInstance() {
        return instance;
    }
}
