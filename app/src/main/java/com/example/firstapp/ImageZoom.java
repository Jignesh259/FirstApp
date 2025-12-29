package com.example.firstapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class ImageZoom extends AppCompatActivity {

    ImageView imgView;
    Button btnSelectImage, btnZoomIn, btnZoomOut;

    private static final int IMAGE_PICK_CODE = 100;
    float scale = 1.0f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_image_zoom);

        imgView = findViewById(R.id.imgView);
        btnSelectImage = findViewById(R.id.btnSelectImage);
        btnZoomIn = findViewById(R.id.btnZoomIn);
        btnZoomOut = findViewById(R.id.btnZoomOut);

        // Select image from gallery
        btnSelectImage.setOnClickListener(v -> openGallery());

        // Zoom In
        btnZoomIn.setOnClickListener(v -> {
            scale += 0.2f;
            imgView.setScaleX(scale);
            imgView.setScaleY(scale);
        });

        // Zoom Out
        btnZoomOut.setOnClickListener(v -> {
            if (scale > 0.4f) {
                scale -= 0.2f;
                imgView.setScaleX(scale);
                imgView.setScaleY(scale);
            }
        });
    }

    private void openGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, IMAGE_PICK_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == IMAGE_PICK_CODE && resultCode == RESULT_OK && data != null) {
            Uri imageUri = data.getData();
            imgView.setImageURI(imageUri);
            scale = 1.0f; // reset zoom
            imgView.setScaleX(scale);
            imgView.setScaleY(scale);
        } else {
            Toast.makeText(this, "Image not selected", Toast.LENGTH_SHORT).show();
        }
    }
}
