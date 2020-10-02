package com.aec.civilapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SiiOptions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sii_options);



    }

    public void directSiiClicked(View view) { startActivity(new Intent(SiiOptions.this,DirectSiiInput.class));
    }

    public void indirectIriClicked(View view) { startActivity(new Intent(SiiOptions.this,socialcalc.class));
    }
}