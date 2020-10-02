package com.aec.civilapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class SiiTable extends AppCompatActivity {

    PDFView studyfinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sii_table);

        studyfinal=(PDFView) findViewById(R.id.pdfView5);
        studyfinal.fromAsset("studyfinal.pdf").load();
    }
}