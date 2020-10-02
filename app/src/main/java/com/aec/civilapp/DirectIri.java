package com.aec.civilapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DirectIri extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_direct_iri);

       final EditText directiri=(EditText) findViewById(R.id.directirivalue);
        Button btnirisubmit=(Button)findViewById(R.id.btnsubmit);
        btnirisubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double x;

                x = Double.parseDouble(directiri.getText().toString());
                double roundedx = (double)Math.round(x * 100d) / 100d;



                //Store data
                SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0);
                SharedPreferences.Editor editor = pref.edit();

                editor.putString("directIri", ""+roundedx); // Storing string

                editor.apply();

                Intent i = new Intent(getApplicationContext(),ContinueApp.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);

            }
        });

    }

}