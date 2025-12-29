package com.example.firstapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity9 extends AppCompatActivity {

    EditText etUserId, etEmail, etPassword, etConfirmPassword;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main9);

        // Initialize views
        etUserId = findViewById(R.id.etUserId);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);
        btnRegister = findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(v -> {

            String uid = etUserId.getText().toString().trim();
            String email = etEmail.getText().toString().trim();
            String pass = etPassword.getText().toString().trim();
            String cpass = etConfirmPassword.getText().toString().trim();

            if (uid.isEmpty()) {
                etUserId.setError("User ID required");
                return;
            }

            if (email.isEmpty()) {
                etEmail.setError("Email required");
                return;
            }

            if (pass.isEmpty()) {
                etPassword.setError("Password required");
                return;
            }

            if (!pass.equals(cpass)) {
                etConfirmPassword.setError("Password does not match");
                return;
            }

            Toast.makeText(this,
                    "Registration Successful",
                    Toast.LENGTH_LONG).show();
        });
    }
}
