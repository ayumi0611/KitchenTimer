package com.ayumitani.kitchentimer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class Timer extends AppCompatActivity {

    private TextView timerText;

    private SimpleDateFormat dateFormat = new SimpleDateFormat("mm:ss", Locale.US);

    @Override
    protected void onCreate(Bundle savedInstanceStore) {
        super.onCreate(savedInstanceStore);
        setContentView(R.layout.fragment_home);

        Button startButton = findViewById(R.id.button_start);
        Button stopButton = findViewById(R.id.button_stop);

    }

}
