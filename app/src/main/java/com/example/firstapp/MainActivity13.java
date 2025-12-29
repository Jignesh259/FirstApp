package com.example.firstapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.app.AlertDialog;

public class MainActivity13 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main13);
        String name = getIntent().getStringExtra("UserName");
        String classname = getIntent().getStringExtra("Class");
        int roll = getIntent().getIntExtra("Roll_No", 0);
        int percent = getIntent().getIntExtra("PERCENT", 0);

        new AlertDialog.Builder(this)
                .setTitle("Student Details")
                .setMessage(
                        "Name: " + name +
                                "\nClass: " + classname +
                                "\nRoll No: " + roll +
                                "\nPercentage: " + percent
                )
                .setCancelable(false)
                .setPositiveButton("OK", (dialog, which) -> {
                    dialog.dismiss();
                    finish(); // closes second activity
                })
                .show();
    }
}