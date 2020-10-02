package com.aec.civilapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Directbbdoption extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_directbbdoption);
        final EditText directbbd = (EditText) findViewById(R.id.editTextcd);
        Button directbbdbtn = (Button) findViewById(R.id.btnDirectBbd);

        directbbdbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                double z;
                z = Double.parseDouble(directbbd.getText().toString());
                double roundedz = (double)Math.round(z * 100d) / 100d;


                //Store data
                SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0);
                SharedPreferences.Editor editor = pref.edit();

                editor.putString("directBbd", "" + roundedz); // Storing string

                editor.apply();

                Intent i = new Intent(getApplicationContext(), ContinueApp.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);

            }
        });
    }
}