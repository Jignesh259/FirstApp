package com.example.firstapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity8 extends AppCompatActivity {

    EditText etUserId, etPassword;
    Button btnLogin;

    // Hardcoded credentials (for practical/demo)
    final String VALID_USER = "JigneshJagatiya";
    final String VALID_PASS = "Jignesh@2509";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main8);

        // Initialize views
        etUserId = findViewById(R.id.etUserId);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);

        // Login button click
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String uid = etUserId.getText().toString().trim();
                String pass = etPassword.getText().toString().trim();

                if (uid.isEmpty()) {
                    etUserId.setError("User ID required");
                    return;
                }

                if (pass.isEmpty()) {
                    etPassword.setError("Password required");
                    return;
                }

                if (uid.equals(VALID_USER) && pass.equals(VALID_PASS)) {
                    Toast.makeText(MainActivity8.this,
                            "Login Successful",
                            Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity8.this,
                            "Invalid User ID or Password",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
