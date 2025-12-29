package com.example.firstapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Bmi extends AppCompatActivity {

    EditText etWeight, etHeight;
    Button btnCalculate;
    TextView tvResult, tvMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bmi);

        etWeight = findViewById(R.id.etWeight);
        etHeight = findViewById(R.id.etHeight);
        btnCalculate = findViewById(R.id.btnCalculate);
        tvResult = findViewById(R.id.tvResult);
        tvMessage = findViewById(R.id.tvMessage);

        btnCalculate.setOnClickListener(v -> calculateBMI());
    }

    private void calculateBMI() {
        String w = etWeight.getText().toString().trim();
        String h = etHeight.getText().toString().trim();

        if (w.isEmpty() || h.isEmpty()) {
            Toast.makeText(this, "Enter weight and height", Toast.LENGTH_SHORT).show();
            return;
        }

        double weight = Double.parseDouble(w);      // kg
        double heightCm = Double.parseDouble(h);    // cm
        double heightM = heightCm / 100.0;

        double bmi = weight / (heightM * heightM);
        bmi = Math.round(bmi * 10) / 10.0; // 1 decimal

        tvResult.setText("BMI: " + bmi);

        if (bmi < 18.5) {
            tvMessage.setText("Underweight");
        } else if (bmi < 24.9) {
            tvMessage.setText("Normal weight");
        } else if (bmi < 29.9) {
            tvMessage.setText("Overweight");
        } else {
            tvMessage.setText("Obese");
        }
    }
}
