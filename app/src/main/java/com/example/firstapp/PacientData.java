package com.example.firstapp;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class PacientData extends AppCompatActivity {

    EditText etName;
    Button btnDate, btnTime, btnBook;
    TextView tvResult;

    String selectedDate = "";
    String selectedTime = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pacient_data);

        etName = findViewById(R.id.etName);
        btnDate = findViewById(R.id.btnDate);
        btnTime = findViewById(R.id.btnTime);
        btnBook = findViewById(R.id.btnBook);
        tvResult = findViewById(R.id.tvResult);

        btnDate.setOnClickListener(v -> openDatePicker());
        btnTime.setOnClickListener(v -> openTimePicker());
        btnBook.setOnClickListener(v -> bookAppointment());
    }

    private void openDatePicker() {
        Calendar c = Calendar.getInstance();
        int y = c.get(Calendar.YEAR);
        int m = c.get(Calendar.MONTH);
        int d = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dp = new DatePickerDialog(
                this,
                (view, year, month, day) ->
                        selectedDate = day + "/" + (month + 1) + "/" + year,
                y, m, d
        );
        dp.show();
    }

    private void openTimePicker() {
        Calendar c = Calendar.getInstance();
        int h = c.get(Calendar.HOUR_OF_DAY);
        int min = c.get(Calendar.MINUTE);

        TimePickerDialog tp = new TimePickerDialog(
                this,
                (view, hour, minute) ->
                        selectedTime = hour + ":" + minute,
                h, min, true
        );
        tp.show();
    }

    private void bookAppointment() {
        String name = etName.getText().toString().trim();

        if (name.isEmpty() || selectedDate.isEmpty() || selectedTime.isEmpty()) {
            Toast.makeText(this, "Please enter all details", Toast.LENGTH_SHORT).show();
            return;
        }

        tvResult.setText(
                "Appointment Booked\n\n" +
                        "Patient: " + name +
                        "\nDate: " + selectedDate +
                        "\nTime: " + selectedTime
        );
    }
}
