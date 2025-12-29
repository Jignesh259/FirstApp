package com.example.firstapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity6 extends AppCompatActivity {

    // Radio
    RadioGroup radioGroup;

    // Layouts
    LinearLayout layoutCircle, layoutTriangle, layoutRectangle, layoutCube;

    // Inputs
    EditText etRadius, etBase, etHeight, etLength, etWidth, etSide;

    // Buttons
    Button btnCircle, btnTriangle, btnRectangle, btnCube, btnGoBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main6);

        // ===== Initialize Views =====
        radioGroup = findViewById(R.id.radioGroup);

        layoutCircle = findViewById(R.id.layoutCircle);
        layoutTriangle = findViewById(R.id.layoutTriangle);
        layoutRectangle = findViewById(R.id.layoutRectangle);
        layoutCube = findViewById(R.id.layoutCube);

        etRadius = findViewById(R.id.etRadius);
        etBase = findViewById(R.id.etBase);
        etHeight = findViewById(R.id.etHeight);
        etLength = findViewById(R.id.etLength);
        etWidth = findViewById(R.id.etWidth);
        etSide = findViewById(R.id.etSide);

        btnCircle = findViewById(R.id.btnCircle);
        btnTriangle = findViewById(R.id.btnTriangle);
        btnRectangle = findViewById(R.id.btnRectangle);
        btnCube = findViewById(R.id.btnCube);
        btnGoBack = findViewById(R.id.btnGoBack);

        hideAllLayouts();

        // ===== RadioGroup Logic =====
        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            hideAllLayouts();
            clearInputs();

            if (checkedId == R.id.rbCircle) {
                layoutCircle.setVisibility(View.VISIBLE);
            } else if (checkedId == R.id.rbTriangle) {
                layoutTriangle.setVisibility(View.VISIBLE);
            } else if (checkedId == R.id.rbRectangle) {
                layoutRectangle.setVisibility(View.VISIBLE);
            } else if (checkedId == R.id.rbCube) {
                layoutCube.setVisibility(View.VISIBLE);
            }
        });

        // ===== Circle Area =====
        btnCircle.setOnClickListener(v -> {
            if (isEmpty(etRadius)) return;

            double r = Double.parseDouble(etRadius.getText().toString());
            double area = Math.PI * r * r;

            showToast("Area of Circle = " + area);
        });

        // ===== Triangle Area =====
        btnTriangle.setOnClickListener(v -> {
            if (isEmpty(etBase) || isEmpty(etHeight)) return;

            double b = Double.parseDouble(etBase.getText().toString());
            double h = Double.parseDouble(etHeight.getText().toString());
            double area = 0.5 * b * h;

            showToast("Area of Triangle = " + area);
        });

        // ===== Rectangle Area =====
        btnRectangle.setOnClickListener(v -> {
            if (isEmpty(etLength) || isEmpty(etWidth)) return;

            double l = Double.parseDouble(etLength.getText().toString());
            double w = Double.parseDouble(etWidth.getText().toString());
            double area = l * w;

            showToast("Area of Rectangle = " + area);
        });

        // ===== Cube Volume (as per XML button text) =====
        btnCube.setOnClickListener(v -> {
            if (isEmpty(etSide)) return;

            double s = Double.parseDouble(etSide.getText().toString());
            double volume = s * s * s;

            showToast("Volume of Cube = " + volume);
        });

        // ===== Go Back =====
        btnGoBack.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity6.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }

    // ===== Helper Methods =====

    private void hideAllLayouts() {
        layoutCircle.setVisibility(View.GONE);
        layoutTriangle.setVisibility(View.GONE);
        layoutRectangle.setVisibility(View.GONE);
        layoutCube.setVisibility(View.GONE);
    }

    private void clearInputs() {
        etRadius.setText("");
        etBase.setText("");
        etHeight.setText("");
        etLength.setText("");
        etWidth.setText("");
        etSide.setText("");
    }

    private boolean isEmpty(EditText et) {
        if (et.getText().toString().trim().isEmpty()) {
            et.setError("Required");
            et.requestFocus();
            return true;
        }
        return false;
    }

    private void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
}
