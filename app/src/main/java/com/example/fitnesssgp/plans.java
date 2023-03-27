package com.example.fitnesssgp;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class plans extends Fragment {
    CardView vmbtnfl,vmbtnmb,vmbtnyg;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_plans, container, false);
        vmbtnfl=v.findViewById(R.id.flwviewmore);
        vmbtnmb=v.findViewById(R.id.mwviewmore);
        vmbtnyg=v.findViewById(R.id.yogaviewmore);

        vmbtnfl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),fatlossplans.class));
            }
        });

        return v;
    }
}