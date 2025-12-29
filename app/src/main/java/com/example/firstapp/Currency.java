package com.example.firstapp;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.*;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Currency extends AppCompatActivity {

    RadioGroup currencycon;
    EditText currency;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_currency);

        currencycon = findViewById(R.id.radioGroup);
        currency = findViewById(R.id.etCurrency);

        currencycon.setOnCheckedChangeListener((group, checkedId) -> {

            String input = currency.getText().toString().trim();

            if (input.isEmpty()) {
                Toast.makeText(this, "Enter amount in INR", Toast.LENGTH_SHORT).show();
                return;
            }

            double inr = Double.parseDouble(input);
            double converted = 0;

            if (checkedId == R.id.rbUsd) {
                converted = inr * 0.012;     // INR → USD
                Toast.makeText(getApplicationContext(),"USD In"+converted,Toast.LENGTH_LONG).show();

            } else if (checkedId == R.id.rbEuro) {
                converted = inr * 0.011;     // INR → Euro
                Toast.makeText(getApplicationContext(),"Euro In"+converted,Toast.LENGTH_LONG).show();

            } else if (checkedId == R.id.rbDiram) {
                converted = inr * 0.044;     // INR → Dirham
                Toast.makeText(getApplicationContext(),"Diram In"+converted,Toast.LENGTH_LONG).show();

            } else if (checkedId == R.id.rbRuble) {
                converted = inr * 1.10;      // INR → Ruble
                Toast.makeText(getApplicationContext(),"Ruble In"+converted,Toast.LENGTH_LONG).show();
            }
        });
    }
}
