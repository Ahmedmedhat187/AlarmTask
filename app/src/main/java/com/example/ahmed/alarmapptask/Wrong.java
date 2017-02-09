package com.example.ahmed.alarmapptask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Wrong extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wrong);

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finish();
    }
}
