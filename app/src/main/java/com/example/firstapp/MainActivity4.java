package com.example.firstapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.EditText;

public class MainActivity4 extends AppCompatActivity {

    Button showtotal,goback;
    EditText vala,valb,valc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main4);
        goback=findViewById(R.id.goBack);
        showtotal=findViewById(R.id.btnCuboid);
        vala=findViewById(R.id.etValuea);
        valb=findViewById(R.id.etValueb);
        valc=findViewById(R.id.etValuec);

        goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });
        showtotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int va = Integer.parseInt(vala.getText().toString());
                int vb = Integer.parseInt(valb.getText().toString());
                int vc = Integer.parseInt(valc.getText().toString());
                int result=va*vb*vc;
                Toast.makeText(getApplicationContext(), va+"*"+vb+"*"+vc+"="+ result, Toast.LENGTH_LONG).show();
            }
        });
    }
}