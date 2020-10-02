package com.aec.civilapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Benkel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_benkel);
    }

    public void bbddirectClicked(View view) {
        startActivity(new Intent(this, Directbbdoption.class));
    }

    public void indBbdClicked(View view) {
        startActivity(new Intent(this,IndirectBbd.class));
    }
}