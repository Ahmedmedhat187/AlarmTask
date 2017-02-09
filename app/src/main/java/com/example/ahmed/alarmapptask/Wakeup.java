package com.example.ahmed.alarmapptask;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Wakeup extends AppCompatActivity {

    public static int num;  String[] a = new String [10] ;
    TextView  tv_q1,tv_a1,tv_a2,tv_a3, tv_w;
    EditText et;
    Button btn_submit;
    RadioButton r1,r2,r3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wakeup);

        final MediaPlayer mp = MediaPlayer.create(getBaseContext() , R.raw.wakeup);
        mp.start();
        mp.setLooping(true);
        final Vibrator vibrator = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
        long[] pattern = {0,500,500,500,500};
        vibrator.vibrate(pattern , 2);
        init();
        quesions();

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String answer = et.getText().toString().toLowerCase();

                if (answer.equals(a[num]))
                {
                    mp.stop();
                    vibrator.cancel();
                    finish();
                }
                else {
                    tv_w.setVisibility(View.VISIBLE);
                    Intent i3 = new Intent(Wakeup.this , Wrong.class);
                    startActivity(i3);
                }}});

    }


    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode)
        {
            case KeyEvent.KEYCODE_VOLUME_UP:Toast.makeText(getBaseContext(),"Volume up Not Working", Toast.LENGTH_SHORT).show();break;
            case KeyEvent.KEYCODE_VOLUME_DOWN:Toast.makeText(getBaseContext(),"Volume Down Not Working", Toast.LENGTH_SHORT).show();break;
            case KeyEvent.KEYCODE_MENU:Toast.makeText(getBaseContext(),"Menu Not Working", Toast.LENGTH_SHORT).show();break;
            case KeyEvent.KEYCODE_BACK:Toast.makeText(getBaseContext(),"Back Not Working", Toast.LENGTH_SHORT).show();break;
            case KeyEvent.KEYCODE_HOME:Toast.makeText(getBaseContext(),"Home up Not Working", Toast.LENGTH_SHORT).show();break;

        }
        return true;
    }




    public void init()
    {
        tv_q1 = (TextView)findViewById(R.id.tv_q1);
        tv_a1 = (TextView)findViewById(R.id.tv_a1);
        tv_a2 = (TextView)findViewById(R.id.tv_a2);
        tv_a3 = (TextView)findViewById(R.id.tv_a3);
        tv_w = (TextView)findViewById(R.id.tv_w);
        et = (EditText)findViewById(R.id.et);
        btn_submit = (Button)findViewById(R.id.btn_submit);
        r1 = (RadioButton) findViewById(R.id.r1);
        r2 = (RadioButton) findViewById(R.id.r2);
        r3 = (RadioButton) findViewById(R.id.r3);
        tv_w.setVisibility(View.INVISIBLE);
    }

    public void quesions()
    {
        String[] q = {"15+30-40+60+35"                ,"who invent java"              ,"who invented linux"
                      ,"what is new in java 8"        ,"169%5"                        ,"who invented c"
                      ,"who teach you android "       ,"android component"            ,"190*60"
                      ,"15+30-40+60+35"};

        a = new String[] {"100"                       ,"james"                         ,"linus"
                      ,"lambda"                       ,"4"                             ,"dennis"
                      ,"omar"                         ,"intent"                        ,"11400"
                      ,"100"};

        String[] g = {"101","100","99"                ,"ahmed","james","omar"         ,"helmy","hamdy","linus"
                      ,"lambda","array","class"       ,"3","4","5"                    ,"dennis","abdo","khaled"
                      ,"omar","helmy","abdo"          ,"button","text view","intent"  ,"11401","11400","11399"
                      , "101","100","99"};

        num = (int)(Math.random()*10);

        tv_q1.setText(q[num]);
        tv_a1.setText(g[num*3]);
        tv_a2.setText(g[num*3+1]);
        tv_a3.setText(g[num*3+2]);
    }


}
