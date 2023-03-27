package com.example.fitnesssgp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.fitnesssgp.R;

public class fatlossplans extends AppCompatActivity {
    LinearLayout d1,d2,d3,d5,d6,d7,d9,d10,d11;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fatlossplans);
            d1=findViewById(R.id.day1);
            d1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(getBaseContext(),day1.class));
                }
            });
        d2=findViewById(R.id.day2);
        d2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(),day2.class));
            }
        });
        d3=findViewById(R.id.day3);
        d3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(),day3.class));
            }
        });
        d5=findViewById(R.id.day5);
        d5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(),day5.class));
            }
        });
        d6=findViewById(R.id.day6);
        d6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(),day6.class));
            }
        });
        d7=findViewById(R.id.day7);
        d7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(),day7.class));
            }
        });
    }
}