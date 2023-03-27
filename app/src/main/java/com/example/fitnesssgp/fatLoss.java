package com.example.fitnesssgp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class fatLoss extends AppCompatActivity {
    CardView skip,push,crunch,plank,jump,cs,squat,mc,jumpsquat,dip,heel,bycle,burpe,plankjack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fat_loss);
        plankjack=findViewById(R.id.plankjacksvm);
        plankjack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(),plankjackwork.class));
            }
        });
        burpe=findViewById(R.id.burpeevm);
        burpe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(),burpeework.class));
            }
        });
        bycle=findViewById(R.id.byclevm);
        bycle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(),byclework.class));
            }
        });
        mc=findViewById(R.id.mcvm);
        mc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(),mountainclimber.class));
            }
        });
        dip=findViewById(R.id.dipsvm);
        dip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(),dipswork.class));
            }
        });
        heel=findViewById(R.id.heeltouchvm);
        heel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(),heeltouchwork.class));
            }
        });
        jumpsquat=findViewById(R.id.jumpsquatvm);
        jumpsquat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(),jumpsquatwork.class));
            }
        });
        skip=findViewById(R.id.skippingvm);
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(),skipingwork.class));
            }
        });
        squat=findViewById(R.id.squatvm);
        squat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(),squatsworkout.class));
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