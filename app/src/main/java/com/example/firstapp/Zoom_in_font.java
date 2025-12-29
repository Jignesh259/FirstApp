package com.example.firstapp;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Zoom_in_font extends AppCompatActivity {

    Spinner spinner;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_zoom_in_font);

        spinner = findViewById(R.id.Spinner);
        result = findViewById(R.id.tvResult);

        ArrayAdapter<CharSequence> adapter =
                ArrayAdapter.createFromResource(
                        this,
                        R.array.font_sizes,
                        android.R.layout.simple_spinner_item
                );

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        // ✅ CORRECT LISTENER FOR SPINNER
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String select = parent.getItemAtPosition(position).toString();

                switch (select) {
                    case "Small":
                        result.setTextSize(14);
                        break;

                    case "Medium":
                        result.setTextSize(18);
                        break;

                    case "Large":
                        result.setTextSize(24);
                        break;

                    case "Extra Large":
                        result.setTextSize(30);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // No action needed
            }
        });
    }
}
