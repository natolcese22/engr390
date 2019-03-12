package com.example.y_barham.breathleaf;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import java.util.Timer;
import java.util.TimerTask;

public class MeditationActivity extends AppCompatActivity {
    String duration;
    int d;
    Timer timer;
    TimerTask timertask;
    final Handler handler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meditation);
        final Bundle bundle = getIntent().getExtras();
        duration = bundle.getString("duration");
        d = Integer.parseInt(duration);
        d= d*60000;

    }

    @Override
    protected void onResume() {
        super.onResume();

        //onResume we start our timer so it can start when the app comes from the background
        startTimer();
    }

    public void startTimer() {
        //set a new Timer
        timer = new Timer();

        //initialize the TimerTask's job
        initializeTimerTask();

        timer.schedule(timertask,d);

    }

    public void initializeTimerTask() {

        timertask = new TimerTask() {
            public void run() {

                //use a handler to run a toast that shows the current timestamp
                handler.post(new Runnable() {
                    public void run() {
                        GotoHome();
                    }
                });
            }
        };
    }

    private void GotoHome() {



        Intent intent = new Intent(this, BeginSession.class);

        startActivity(intent);

    }
}

