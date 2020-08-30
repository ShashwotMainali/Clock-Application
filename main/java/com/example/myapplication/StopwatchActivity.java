package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

public class StopwatchActivity extends AppCompatActivity {
    Chronometer chronometer;
    Button startBtn, pauseBtn, resetBtn;
    long stopTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);

        chronometer = (Chronometer)findViewById(R.id.chronometer);
        startBtn = (Button)findViewById(R.id.startBtn);
        pauseBtn = (Button)findViewById(R.id.pauseBtn);
        resetBtn = (Button)findViewById(R.id.resetBtn);


        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chronometer.setBase(SystemClock.elapsedRealtime() + stopTime);
                chronometer.start();
                startBtn.setVisibility(View.GONE);
                pauseBtn.setVisibility(View.VISIBLE);
            }
        });

        pauseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopTime = chronometer.getBase() - SystemClock.elapsedRealtime();
                chronometer.stop();
                startBtn.setVisibility(View.VISIBLE);
                pauseBtn.setVisibility(View.GONE);
            }
        });

        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chronometer.setBase(SystemClock.elapsedRealtime());
                stopTime = 0;
                chronometer.stop();
                startBtn.setVisibility(View.VISIBLE);
                pauseBtn.setVisibility(View.GONE);
            }
        });

    }

}