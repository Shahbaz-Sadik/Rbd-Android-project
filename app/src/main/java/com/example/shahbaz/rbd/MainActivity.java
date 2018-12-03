package com.example.shahbaz.rbd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

        public void goToActivity2 (View view){
            Intent intent = new Intent(MainActivity.this, login.class);
            startActivity(intent);
        }

    public void goToActivity3 (View view){
        Intent intent = new Intent(MainActivity.this, signup.class);
        startActivity(intent);
    }
}


