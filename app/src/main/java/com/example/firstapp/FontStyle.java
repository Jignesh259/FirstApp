package com.example.firstapp;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class FontStyle extends AppCompatActivity {

    TextView tvSample;
    EditText etSample;
    Button btnSmall, btnMedium, btnLarge;
    Button btnBold, btnItalic, btnNormal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_font_style);

        tvSample = findViewById(R.id.tvSample);
        etSample = findViewById(R.id.etSample);

        btnSmall = findViewById(R.id.btnSmall);
        btnMedium = findViewById(R.id.btnMedium);
        btnLarge = findViewById(R.id.btnLarge);

        btnBold = findViewById(R.id.btnBold);
        btnItalic = findViewById(R.id.btnItalic);
        btnNormal = findViewById(R.id.btnNormal);

        // Font Size
        btnSmall.setOnClickListener(v -> setSize(14));
        btnMedium.setOnClickListener(v -> setSize(18));
        btnLarge.setOnClickListener(v -> setSize(24));

        // Font Style
        btnBold.setOnClickListener(v -> setStyle(Typeface.BOLD));
        btnItalic.setOnClickListener(v -> setStyle(Typeface.ITALIC));
        btnNormal.setOnClickListener(v -> setStyle(Typeface.NORMAL));
    }

    private void setSize(float size) {
        tvSample.setTextSize(size);
        etSample.setTextSize(size);
    }

    private void setStyle(int style) {
        tvSample.setTypeface(null, style);
        etSample.setTypeface(null, style);
    }
}
