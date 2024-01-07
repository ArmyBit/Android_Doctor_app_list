package com.isga.isgaexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Medecin_welcome extends AppCompatActivity {
  Button a,b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medecin_welcome);
        a=findViewById(R.id.btn);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b= new Intent(getApplicationContext(),MainActivity.class);
                startActivity(b);
                finish();

            }
        });
        b=findViewById(R.id.btn2);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b= new Intent(getApplicationContext(), medecin_controller.class);
                startActivity(b);
                finish();

            }
        });


    }
}