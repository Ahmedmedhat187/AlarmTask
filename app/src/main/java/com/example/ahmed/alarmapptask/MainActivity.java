package com.example.ahmed.alarmapptask;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.sql.Time;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    public static int time;
    Calendar c;
    TimePicker tp;
    Button start;
    ProgressBar pm,ps;
    TextView tv1 , tv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        c = Calendar.getInstance();
        tp = (TimePicker) findViewById(R.id.timePicker);
        tp.setCurrentHour(c.get(Calendar.HOUR_OF_DAY));
        tp.setCurrentMinute(c.get(Calendar.MINUTE));
        start = (Button) findViewById(R.id.btn_start);
        pm = (ProgressBar) findViewById(R.id.progressBar1);
        ps = (ProgressBar) findViewById(R.id.progressBar2);
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);

    }

    public void alarm (View view)
    {
        Long l = System.currentTimeMillis();
        int h = tp.getCurrentHour();
        int m = tp.getCurrentMinute();
        int hnew = h - c.get(Calendar.HOUR_OF_DAY) ;
        int mnew = m - c.get(Calendar.MINUTE) ;
        time = (hnew*60*60)+(mnew*60);
        Toast.makeText(getBaseContext() , "Alarm set in "+hnew +"H:"+mnew +"M =" +time+"ses" , Toast.LENGTH_LONG).show();
        new MyAsyncTask().execute();
        Intent i = new Intent(getApplicationContext() , MyReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(),123456,i,0);
        AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP , l+(time*1000) , pendingIntent);



    }

    public class MyAsyncTask extends AsyncTask <Void, Integer, Integer>
    {

        @Override
        protected void onPreExecute() {
            pm.setMax(time); ps.setMax(time);
        }
        @Override
        protected Integer doInBackground(Void... params) {
            for (int i=0; i<= time;i++)
            {
                publishProgress(time-i);
                try {Thread.sleep(1000);}
                catch (Exception e){Toast.makeText(getBaseContext() , "error" , Toast.LENGTH_SHORT).show();}
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            Integer m = (int)(values[0]/60);
            Integer s = (int) (values[0] -m*60);
            pm.setProgress(m);
            tv1.setText(m.toString());
            ps.setProgress(s);
            tv2.setText(s.toString());
        }

        @Override
        protected void onPostExecute(Integer integer) {
        }
    }
}
