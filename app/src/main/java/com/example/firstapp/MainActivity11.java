package com.example.firstapp;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity11 extends AppCompatActivity {

    LinearLayout step1, step2, step3;
    Button btnNext1, btnNext2, btnSubmit;

    EditText etName, etUsername, etEmail, etPhone, etPassword, etConfirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main11);

        // Steps
        step1 = findViewById(R.id.step1);
        step2 = findViewById(R.id.step2);
        step3 = findViewById(R.id.step3);

        // Inputs
        etName = findViewById(R.id.etName);
        etUsername = findViewById(R.id.etUsername);
        etEmail = findViewById(R.id.etEmail);
        etPhone = findViewById(R.id.etPhone);
        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);

        // Buttons
        btnNext1 = findViewById(R.id.btnNext1);
        btnNext2 = findViewById(R.id.btnNext2);
        btnSubmit = findViewById(R.id.btnSubmit);

        // STEP 1 → STEP 2
        btnNext1.setOnClickListener(v -> {
            if (etName.getText().toString().isEmpty()) {
                etName.setError("Required");
                return;
            }
            if (etUsername.getText().toString().isEmpty()) {
                etUsername.setError("Required");
                return;
            }
            step1.setVisibility(View.GONE);
            step2.setVisibility(View.VISIBLE);
        });

        // STEP 2 → STEP 3
        btnNext2.setOnClickListener(v -> {
            if (etEmail.getText().toString().isEmpty()) {
                etEmail.setError("Required");
                return;
            }
            if (etPhone.getText().toString().isEmpty()) {
                etPhone.setError("Required");
                return;
            }
            step2.setVisibility(View.GONE);
            step3.setVisibility(View.VISIBLE);
        });

        // SUBMIT
        btnSubmit.setOnClickListener(v -> {
            String p1 = etPassword.getText().toString();
            String p2 = etConfirmPassword.getText().toString();

            if (p1.isEmpty()) {
                etPassword.setError("Required");
                return;
            }
            if (!p1.equals(p2)) {
                etConfirmPassword.setError("Password mismatch");
                return;
            }

            Toast.makeText(this,
                    "Registration Successful",
                    Toast.LENGTH_LONG).show();
        });
    }
}
