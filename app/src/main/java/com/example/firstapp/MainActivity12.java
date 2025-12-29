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
import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;

public class MainActivity12 extends AppCompatActivity {

    Button submit;
    EditText name,classname,roll,per;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main12);
        submit=findViewById(R.id.btnSubmit);
        name=findViewById(R.id.etName);
        classname=findViewById(R.id.etClassname);
        roll=findViewById(R.id.etRollnum);
        per=findViewById(R.id.etPer);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stname=name.getText().toString();
                String stclass=classname.getText().toString();
                int rollint=Integer.parseInt(roll.getText().toString());
                int perint=Integer.parseInt(per.getText().toString());
                if (stname.isEmpty() || stclass.isEmpty())
                {
                    Toast.makeText(getApplicationContext(), "Please Fill Up Detail", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent=new Intent(MainActivity12.this,MainActivity13.class);
                intent.putExtra("UserName",stname);
                intent.putExtra("Class",stclass);
                intent.putExtra("Roll_No",rollint);
                intent.putExtra("PERCENT",perint);
                startActivity(intent);
            }
        });

    }
}