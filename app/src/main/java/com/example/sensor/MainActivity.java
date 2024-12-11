 package com.example.sensor;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity implements SensorEventListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView=findViewById(R.id.value);
        SensorManager sensorManager= (SensorManager) getSystemService(SENSOR_SERVICE);
        if(sensorManager!=null)
        {
            Sensor accelerosensor =sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            if(accelerosensor!=null)
            {
                sensorManager.registerListener(this,accelerosensor,SensorManager.SENSOR_DELAY_NORMAL);
            }
        }
        else
        {
            Toast.makeText(this, "Sensor service not detected", Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType()==Sensor.TYPE_ACCELEROMETER)
        {
            ((TextView)findViewById(R.id.value)).setText("X: "+event.values[0]+"Y: "+event.values[1]+"Z: "+event.values[2]);
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}