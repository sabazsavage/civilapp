package com.aec.civilapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class irioption extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_irioption);
    }

    public void directIriClicked(View view) {
        startActivity(new Intent(this,DirectIri.class));
    }
    public void indirectIriClicked(View view) {
        startActivity(new Intent(this,IndirectIri.class));
    }
}