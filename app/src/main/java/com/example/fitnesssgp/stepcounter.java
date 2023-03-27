package com.example.fitnesssgp;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class stepcounter extends AppCompatActivity implements SensorEventListener {

    private TextView stepCountTextView;
    private Button resetButton;

    private SensorManager sensorManager;
    private Sensor stepSensor;

    private int stepCount = 0;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stepcounter);

        stepCountTextView = findViewById(R.id.stepCountTextView);
        resetButton = findViewById(R.id.resetButton);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        stepSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);


        if (stepSensor == null) {
            // Step sensor not available on this device
            Toast.makeText(this, "Step sensor not available on this device", Toast.LENGTH_LONG).show();
        } else {
            // Step sensor available on this device
            resetButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    stepCount = 0;
                    stepCountTextView.setText("0");
                }
            });
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, stepSensor, SensorManager.SENSOR_DELAY_FASTEST);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];

            float acceleration = (float) Math.sqrt(x * x + y * y + z * z);

            if (acceleration > 12) {
                stepCount++;
                stepCountTextView.setText(String.valueOf(stepCount));
            }
        }
    }


    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // not used
    }
}
