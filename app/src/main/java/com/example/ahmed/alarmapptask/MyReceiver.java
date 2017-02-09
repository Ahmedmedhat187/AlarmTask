package com.example.ahmed.alarmapptask;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Vibrator;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context , "Time Up" , Toast.LENGTH_SHORT).show();

        Intent i2 = new Intent(context , Wakeup.class);
        i2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i2);

    }
}
