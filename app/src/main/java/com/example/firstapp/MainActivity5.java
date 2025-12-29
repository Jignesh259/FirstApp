package com.example.firstapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.View;
import android.widget.*;
import android.content.Intent;

public class MainActivity5 extends AppCompatActivity {

    Button simpleinfind,goback;
    EditText amount,interest,year;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main5);
        amount=findViewById(R.id.etamount);
        interest=findViewById(R.id.etinterest);
        year=findViewById(R.id.etyear);
        simpleinfind=findViewById(R.id.btnsimpleinterestamount);
        goback=findViewById(R.id.goBack);
        simpleinfind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int amounti=Integer.parseInt(amount.getText().toString());
                int interesi=Integer.parseInt(interest.getText().toString());
                int yeari=Integer.parseInt(year.getText().toString());
                int simpleamount=(amounti*interesi*yeari)/100;
                Toast.makeText(getApplicationContext(),"A Simple Interest Amount Is "+simpleamount,Toast.LENGTH_LONG).show();
            }
        });
        goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });
    }
}