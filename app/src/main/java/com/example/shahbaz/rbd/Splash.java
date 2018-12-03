package com.example.shahbaz.rbd;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.os.Handler;

import static com.example.shahbaz.rbd.R.layout.activity_splash;

public class Splash extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_splash);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
               startActivity( new Intent(Splash.this,MainActivity.class));
                finish();
            }
        },2000);
    }
}