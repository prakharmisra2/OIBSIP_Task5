package com.example.stopwatch;

import static com.example.stopwatch.R.anim.logo_animation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashScreen extends AppCompatActivity {
    Animation logoAnim;
     ImageView logoView;
     final int TimeToHold = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        logoAnim = AnimationUtils.loadAnimation(this,logo_animation);
        logoView = findViewById(R.id.logoView);
        logoView.setAnimation(logoAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent main = new Intent(SplashScreen.this,MainActivity.class);
                startActivity(main);
                finish();
            }
        },TimeToHold);


    }

}