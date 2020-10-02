package com.aec.civilapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class ContactDetails extends AppCompatActivity {


    PDFView contact1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_details2);

        contact1=(PDFView) findViewById(R.id.pdfView4);
        contact1.fromAsset("contact1.pdf").load();



    }
}