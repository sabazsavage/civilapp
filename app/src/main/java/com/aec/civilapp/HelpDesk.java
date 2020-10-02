package com.aec.civilapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HelpDesk extends AppCompatActivity {

    Button study1;
    Button study2;
    Button study3;
    Button studyfinal;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_desk);
        study1 = (Button) findViewById(R.id.study1);
        study1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HelpDesk.this,Study1Activity.class);
                startActivity(intent);

            }
        });

        study2 = (Button) findViewById(R.id.study2);
        study2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HelpDesk.this,Study2Activity.class);
                startActivity(intent);

            }
        });


        study3 = (Button) findViewById(R.id.study3);
        study3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HelpDesk.this,Study3Activity.class);
                startActivity(intent);

            }
        });

        studyfinal = (Button) findViewById(R.id.studyfinal);
        studyfinal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HelpDesk.this,SiiTable.class);
                startActivity(intent);

            }
        });
    }
}