package com.example.firstapp;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class measurecon extends AppCompatActivity {

    EditText etKm;
    CheckBox cbMeter, cbCentimeter, cbInch;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        // ✅ Correct layout
        setContentView(R.layout.activity_measurecon);

        etKm = findViewById(R.id.etKm);
        cbMeter = findViewById(R.id.cbM);
        cbCentimeter = findViewById(R.id.cbCM);
        cbInch = findViewById(R.id.cbInch);
        tvResult = findViewById(R.id.tvResult);

        cbMeter.setOnCheckedChangeListener((buttonView, isChecked) -> convert());
        cbCentimeter.setOnCheckedChangeListener((buttonView, isChecked) -> convert());
        cbInch.setOnCheckedChangeListener((buttonView, isChecked) -> convert());
    }

    private void convert() {
        String input = etKm.getText().toString().trim();

        if (input.isEmpty()) {
            Toast.makeText(this, "Please enter value in KM", Toast.LENGTH_SHORT).show();
            tvResult.setText("");
            return;
        }

        double km = Double.parseDouble(input);
        StringBuilder result = new StringBuilder();

        if (cbMeter.isChecked()) {
            result.append("Meter : ").append(km * 1000).append("\n");
        }

        if (cbCentimeter.isChecked()) {
            result.append("Centimeter : ").append(km * 100000).append("\n");
        }

        if (cbInch.isChecked()) {
            result.append("Inch : ").append(km * 39370).append("\n");
        }

        if (result.length() == 0) {
            tvResult.setText("Select at least one unit");
        } else {
            tvResult.setText(result.toString());
        }
    }
}
