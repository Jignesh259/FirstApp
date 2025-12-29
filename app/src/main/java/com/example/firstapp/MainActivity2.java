package com.example.firstapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.EditText;
import android.content.Intent;

public class MainActivity2 extends AppCompatActivity {
    Button mergeName,goback;
    EditText name,surname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        mergeName=findViewById(R.id.btnSubmit);
        mergeName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               name=findViewById(R.id.etName);
               surname=findViewById(R.id.etSurname);
               String namestr=name.getText().toString().trim();
               String srname=surname.getText().toString().trim();
               Toast.makeText(getApplicationContext(),"Welcome "+ namestr +" "+ srname,Toast.LENGTH_LONG).show();
            }
        });
        goback=findViewById(R.id.goBack);
        goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });
    }
}