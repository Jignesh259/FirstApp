package com.example.firstapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.net.InetSocketAddress;

public class MainActivity extends AppCompatActivity {

    Button btnShowName,btnMathOperation,btnCuboid,btnsimplein,btnfindarea,btndisplayimage,btnLogin,btnRegi,btnLoginRegi,btnsocial,btnAlert,btncurrency,btnmeasure;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnShowName = findViewById(R.id.btnShowName);
        btnMathOperation = findViewById(R.id.btnMathOperation);
        btnCuboid=findViewById(R.id.btnCuboidArea);
        btnsimplein=findViewById(R.id.btnSimpleInterest);
        btnfindarea=findViewById(R.id.btnAreaInput);
        btndisplayimage=findViewById(R.id.btnDisplayImage);
        btnLogin=findViewById(R.id.btnLogin);
        btnRegi=findViewById(R.id.btnRegister);
        btnLoginRegi=findViewById(R.id.btnLoginRegister);
        btnsocial=findViewById(R.id.btnSocialRegister);
        btnAlert=findViewById(R.id.btnAlertBox);
        btncurrency=findViewById(R.id.btnCurrencyCov);
        btnmeasure=findViewById(R.id.btnMeasure);
        btnShowName.setOnClickListener(a -> {
            Intent intent1 = new Intent(MainActivity.this, MainActivity2.class);
            startActivity(intent1);
        });
        btnMathOperation.setOnClickListener(b -> {
            Intent intent2 = new Intent(MainActivity.this, MainActivity3.class);
            startActivity(intent2);
        });
        btnCuboid.setOnClickListener(c->{
            Intent intent3=new Intent(getApplicationContext(), MainActivity4.class);
            startActivity(intent3);
        });
        btnsimplein.setOnClickListener(d->{
            Intent intent4=new Intent(getApplicationContext(), MainActivity5.class);
            startActivity(intent4);
        });
        btnfindarea.setOnClickListener(e->{
            Intent intent5=new Intent(getApplicationContext(), MainActivity6.class);
            startActivity(intent5);
        });
        btndisplayimage.setOnClickListener(f->{
            Intent intent6=new Intent(getApplicationContext(), MainActivity7.class);
            startActivity(intent6);
        });
        btnLogin.setOnClickListener(g->{
            Intent intent7=new Intent(getApplicationContext(), MainActivity8.class);
            startActivity(intent7);
        });
        btnRegi.setOnClickListener(h->{
            Intent intent8=new Intent(getApplicationContext(), MainActivity9.class);
            startActivity(intent8);
        });
        btnLoginRegi.setOnClickListener(i->{
            Intent intent9=new Intent(getApplicationContext(), MainActivity10.class);
            startActivity(intent9);
        });
        btnsocial.setOnClickListener(j->{
            Intent intent10=new Intent(getApplicationContext(), MainActivity11.class);
            startActivity(intent10);
        });
        btnAlert.setOnClickListener(k->{
            Intent intent11=new Intent(getApplicationContext(),MainActivity12.class);
            startActivity(intent11);
        });
        btncurrency.setOnClickListener(l->{
            Intent intent12=new Intent(getApplicationContext(), Currency.class);
            startActivity(intent12);
        });
        btnmeasure.setOnClickListener(m->{
            Intent intent13=new Intent(getApplicationContext(), measurecon.class);
            startActivity(intent13);
        });
    }
}
