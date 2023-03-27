package com.example.fitnesssgp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        Thread background = new Thread() {

            public void run() {
                try {
                    // Thread will sleep for 5 seconds
                    sleep(4*1000);

                    // After 5 seconds redirect to another intent
                    Intent i=new Intent(getBaseContext(),LoginPage.class);
                    startActivity(i);

                    //Remove activity
                    finish();
                } catch (Exception e) {

                }
            }
        };
        // start thread
        background.start();
    }
}