package com.example.firstapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.*;
import java.util.Calendar;
import android.app.*;

public class Timepicer extends AppCompatActivity {

    Button btnTime,btndate;
    TextView showtime,showdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_timepicer);
        btnTime=findViewById(R.id.btnPickTime);
        showtime=findViewById(R.id.tvResult);
        btndate=findViewById(R.id.btnPickDate);
        showdate=findViewById(R.id.tvResultDate);
        btnTime.setOnClickListener(v->showTimePicer());
        btndate.setOnClickListener(k->{
            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(
                    this,
                    (view, y, m, d) ->
                            showdate.setText("Date: " + d + "/" + (m + 1) + "/" + y),
                    year, month, day
            );

            datePickerDialog.show();
        });
    }
    private void showTimePicer(){
        Calendar calendar=Calendar.getInstance();
        int hour=calendar.get(Calendar.HOUR_OF_DAY);
        int minute=calendar.get(Calendar.MINUTE);
        TimePickerDialog timePickerDialog = new TimePickerDialog(
                this,
                (TimePicker view, int selectedHour, int selectedMinute) ->
                        showtime.setText("Time: " + selectedHour + ":" + selectedMinute),
                hour,
                minute,
                true
        );
        timePickerDialog.show();
    }
}