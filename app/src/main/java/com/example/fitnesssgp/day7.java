package com.example.fitnesssgp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class day7 extends AppCompatActivity {
    CardView skip,dip,crunch,plank,push,cs,lung;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day7);
        skip=findViewById(R.id.skippingvm);
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(),skipingwork.class));
            }
        });
        lung=findViewById(R.id.lungsvm);
        lung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(),lungeswork.class));
            }
        });
        dip=findViewById(R.id.dipsvm);
        dip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(),dipswork.class));
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
        push=findViewById(R.id.pushupsvm);
        push.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(),pushupworkout.class));
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