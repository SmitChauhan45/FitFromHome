package com.example.fitnesssgp;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView btmview;
    home Home = new home();
    plans Plan =new plans();
    calroiestarget calori = new calroiestarget();
    profile Profile = new profile();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btmview=findViewById(R.id.btm);

        getSupportFragmentManager().beginTransaction().replace(R.id.llframe,Home).commit();
        btmview.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.itemhome:
                        getSupportFragmentManager().beginTransaction().replace(R.id.llframe,Home).commit();
                        return true;
                    case R.id.itemplans:
                        getSupportFragmentManager().beginTransaction().replace(R.id.llframe,Plan).commit();
                        return true;
                    case R.id.itemcalories:
                        getSupportFragmentManager().beginTransaction().replace(R.id.llframe,calori).commit();
                        return true;
                    case R.id.itemprofile:
                        getSupportFragmentManager().beginTransaction().replace(R.id.llframe,Profile).commit();
                        return true;
                }
                return false;
            }
        });
    }
}