package com.dimsen.mytimetable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar seekBar = findViewById(R.id.seekBar);
        ListView listView = findViewById(R.id.listTable);

        int max = 20;
        int start = 10;

        seekBar.setMax(max);
        seekBar.setProgress(start);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int min = 1;
                int timeTableNumber;

                if (i < min) {
                    timeTableNumber = min;
                    seekBar.setProgress(min);
                } else {
                    timeTableNumber = i;
                }
                Log.i("Seekbar", Integer.toString(timeTableNumber));

                ArrayList<String> tableArrayList = new ArrayList<>();

                for (int k = 1; k<=10; k++) {
                    tableArrayList.add(Integer.toString(k * timeTableNumber));
                }

                ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1);
                listView.setAdapter(stringArrayAdapter);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}