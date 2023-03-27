package com.example.fitnesssgp;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class home extends Fragment {
    ImageView step,diet,muscle,yoga,bmii,fat;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_home, container, false);
        bmii = v.findViewById(R.id.llbmi);
        muscle = v.findViewById(R.id.llmuscle);
        fat = v.findViewById(R.id.llfat);
        step=v.findViewById(R.id.stepimg);
        yoga = v.findViewById(R.id.llyoga);
        bmii.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),Bmi_calc.class));
            }
        });
        muscle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),Muscle_Building.class));
            }
        });
        yoga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),Yoga.class));
            }
        });
        fat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), fatLoss.class));
            }
        });
        step.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),stepcounter.class));
            }
        });
        return v;
    }
}