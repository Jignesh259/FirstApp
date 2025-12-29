package com.example.firstapp;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity10 extends AppCompatActivity {

    LinearLayout layoutLogin, layoutRegister;
    Button btnShowLogin, btnShowRegister, btnLogin, btnRegister;

    EditText etLoginUser, etLoginPass;
    EditText etRegUser, etRegEmail, etRegPass, etRegConfirm;

    String savedUser = "JigneshJagatiya";
    String savedPass = "Jignesh@2509";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main10);

        layoutLogin = findViewById(R.id.layoutLogin);
        layoutRegister = findViewById(R.id.layoutRegister);

        btnShowLogin = findViewById(R.id.btnShowLogin);
        btnShowRegister = findViewById(R.id.btnShowRegister);

        etLoginUser = findViewById(R.id.etLoginUser);
        etLoginPass = findViewById(R.id.etLoginPass);
        btnLogin = findViewById(R.id.btnLogin);

        etRegUser = findViewById(R.id.etRegUser);
        etRegEmail = findViewById(R.id.etRegEmail);
        etRegPass = findViewById(R.id.etRegPass);
        etRegConfirm = findViewById(R.id.etRegConfirm);
        btnRegister = findViewById(R.id.btnRegister);

        btnShowLogin.setOnClickListener(v -> {
            layoutLogin.setVisibility(View.VISIBLE);
            layoutRegister.setVisibility(View.GONE);
        });

        btnShowRegister.setOnClickListener(v -> {
            layoutRegister.setVisibility(View.VISIBLE);
            layoutLogin.setVisibility(View.GONE);
        });

        btnLogin.setOnClickListener(v -> {
            String u = etLoginUser.getText().toString().trim();
            String p = etLoginPass.getText().toString().trim();

            if (u.equals(savedUser) && p.equals(savedPass)) {
                Toast.makeText(this, "Login Successful", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Invalid Login", Toast.LENGTH_LONG).show();
            }
        });

        btnRegister.setOnClickListener(v -> {
            String u = etRegUser.getText().toString().trim();
            String p = etRegPass.getText().toString().trim();
            String cp = etRegConfirm.getText().toString().trim();

            if (!p.equals(cp)) {
                etRegConfirm.setError("Password mismatch");
                return;
            }

            savedUser = u;
            savedPass = p;

            Toast.makeText(this, "Registration Successful", Toast.LENGTH_LONG).show();
            layoutLogin.setVisibility(View.VISIBLE);
            layoutRegister.setVisibility(View.GONE);
        });
    }
}
