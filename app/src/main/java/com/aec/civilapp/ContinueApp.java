package com.aec.civilapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ContinueApp extends AppCompatActivity {
    private Button pci;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_continue_app);

        pci = (Button) findViewById(R.id.pciscore);
       pci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDataforpci();
            }
        });
    }

    public void openDataforpci() {
        Intent intent = new Intent(this,DataForPci.class);
        startActivity(intent);
    }

    public void iriClicked(View view) {
        startActivity(new Intent(this, irioption.class));
    }


    public void bbdClicked(View view) {
        startActivity(new Intent(this, Benkel.class));
    }

    public void priorityFinalClicked(View view) { startActivity(new Intent(this, PriorityScoreFinal.class)); }

    public void siiClicked(View view) { startActivity(new Intent(ContinueApp.this,SiiOptions.class));
    }
}