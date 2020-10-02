package com.aec.civilapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DirectSiiInput extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_direct_sii_input);

        final EditText direcisii=(EditText) findViewById(R.id.etdirectsii);
        Button btnDirectSii=(Button)findViewById(R.id.btnDirectSii);

        btnDirectSii.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double y;
                y = Double.parseDouble(direcisii.getText().toString());
                double roundedy = (double)Math.round(y * 100d) / 100d;

                //Store data
                SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0);
                SharedPreferences.Editor editor = pref.edit();

                editor.putString("directSii", ""+roundedy); // Storing string

                editor.apply();

                Intent i = new Intent(getApplicationContext(),ContinueApp.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);

            }
        });
    }

}