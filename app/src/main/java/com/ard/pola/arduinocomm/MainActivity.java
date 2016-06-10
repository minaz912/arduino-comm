package com.ard.pola.arduinocomm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    BluetoothArduino mBlue;
    TextView message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /*make sure to use the same name of the arduino module.
        And check if it's paired with your device */
        mBlue = BluetoothArduino.getInstance("Paradox");
        message = (TextView) findViewById(R.id.message);
        if (setup()) {
            draw();
        } else {
            message.setText("Failed to connect to Arduino");
        }
    }

    boolean setup(){
        return mBlue.Connect();
    }

    void draw(){
        String msg = mBlue.getLastMessage();
        message.setText(msg);
    }
}
