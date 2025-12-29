package com.example.firstapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {

    Button add, sub, div, multi, po, goback;
    EditText a, b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);

        add = findViewById(R.id.btnAdd);
        sub = findViewById(R.id.btnSub);
        div = findViewById(R.id.btnDiv);
        multi = findViewById(R.id.btnMulti);
        po = findViewById(R.id.btnpo);
        goback = findViewById(R.id.goBack);

        a = findViewById(R.id.etValuea);
        b = findViewById(R.id.etValueb);

        add.setOnClickListener(v -> calculate("add"));
        sub.setOnClickListener(v -> calculate("sub"));
        multi.setOnClickListener(v -> calculate("mul"));
        div.setOnClickListener(v -> calculate("div"));
        po.setOnClickListener(v -> calculate("pow"));

        goback.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity3.this, MainActivity.class);
            startActivity(i);
        });
    }

    private void calculate(String type) {
        if (a.getText().toString().isEmpty() || b.getText().toString().isEmpty()) {
            Toast.makeText(this, "Enter both values", Toast.LENGTH_SHORT).show();
            return;
        }

        int va = Integer.parseInt(a.getText().toString());
        int vb = Integer.parseInt(b.getText().toString());

        int result;

        switch (type) {
            case "add":
                result = va + vb;
                break;
            case "sub":
                result = va - vb;
                break;
            case "mul":
                result = va * vb;
                break;
            case "div":
                if (vb == 0) {
                    Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                    return;
                }
                result = va / vb;
                break;
            default: // power
                result = (int) Math.pow(va, vb);
        }

        Toast.makeText(this, "Result: " + result, Toast.LENGTH_LONG).show();
    }
}
