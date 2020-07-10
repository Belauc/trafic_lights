package com.example.traficlights;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class LightsActivity extends AppCompatActivity {
    Timer timer;
    TimerTask mTimerTask;
    ImageView imageView;
    int time;
    public LightsActivity(){};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lights);
    }
    protected void onStart() {
        super.onStart();
        final Bundle arguments = getIntent().getExtras();
        imageView = findViewById(R.id.imageView);
        final Button button = findViewById(R.id.start);
        if (arguments != null) {
           time = Integer.parseInt(arguments.get("time").toString());
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(timer != null){
                    timer.cancel();
                }
                timer = new Timer();
                mTimerTask = new MyTimerTask();
                button.setVisibility(View.GONE);
                timer.schedule(mTimerTask, 1000, time*1000);
            }
        });
    }
    class MyTimerTask extends TimerTask {
        int i = 1;
        @Override
        public void run() {
            int color = getResources().getColor(R.color.colorAccent);
            switch (i){
                case 1:
                    color = getResources().getColor(R.color.red);
                    i = 2;
                    break;
                case 2:
                    color = getResources().getColor(R.color.yellow);
                    i=3;
                    break;
                case 3:
                    color = getResources().getColor(R.color.green);
                    i=1;
                    break;
            }
            final int fcolor = color;
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    imageView.setBackgroundColor(fcolor);
                }
            });
        }
    }
}
