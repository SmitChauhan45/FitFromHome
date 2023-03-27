package com.example.fitnesssgp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class day3 extends AppCompatActivity {
    CardView mc,heel,push,crunch,plank,jump,cs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day3);
        mc=findViewById(R.id.mcvm);
        mc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(),mountainclimber.class));
            }
        });
        heel=findViewById(R.id.heeltouchvm);
        heel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(),heeltouchwork.class));
            }
        });
        push=findViewById(R.id.pushupsvm);
        push.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(),pushupworkout.class));
            }
        });
        crunch=findViewById(R.id.crunchvm);
        crunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(),crunchesworkout.class));
            }
        });
        plank=findViewById(R.id.plankvm);
        plank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(),plankworkout.class));
            }
        });
        jump=findViewById(R.id.jumpvm);
        jump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(),jumpackswork.class));
            }
        });
        cs=findViewById(R.id.cobrastretchvm);
        cs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(),cobrastrechwork.class));
            }
        });
    }
}