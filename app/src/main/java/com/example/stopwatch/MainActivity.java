package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Chronometer chronometer;//Chronometer object
    private boolean running;// var for checking if clock is running or not
    private long pausedTime;// to store the time interval for which clock was left paused.
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chronometer = findViewById(R.id.chro);
      //  chronometer.setCountDown(true);

    }
    public void startChoronometer(View v){
        if(!running){//check clock not running
            chronometer.setBase(SystemClock.elapsedRealtime()-pausedTime);//System.... will mention the time zero and this will be set to the start time
            chronometer.start();
            Toast.makeText(this, "Stopwatch Running", Toast.LENGTH_SHORT).show();
            running = true;// change running status
        }
    }
    public void stopChoronometer(View v){
        chronometer.setBase(SystemClock.elapsedRealtime());//set time to zero of clock
        Toast.makeText(this, "Stopwatch is reset", Toast.LENGTH_SHORT).show();
        pausedTime = 0;
    }
    public void holdChoronometer(View v){
        if(running){

            chronometer.stop();
            pausedTime = SystemClock.elapsedRealtime() - chronometer.getBase();//calculating pausedtime.
            Toast.makeText(this, "Clock paused", Toast.LENGTH_SHORT).show();
            running = false;
        }
    }
}