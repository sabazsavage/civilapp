package com.aec.civilapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
private Button continueapp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0);
        SharedPreferences.Editor editor = pref.edit();
        editor.clear();
        editor.apply();


        continueapp = (Button) findViewById(R.id.continueapp);
        continueapp.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            openContinueapp();
        }
    });
}

    public void openContinueapp() {
        Intent intent = new Intent(this,ContinueApp.class);
        startActivity(intent);
    }

    public void contactsClicked(View view) { startActivity(new Intent(MainActivity.this,ContactDetails.class));
    }

    public void helpDeskClicked(View view) { startActivity(new Intent(MainActivity.this,HelpDesk.class));
    }

    public void overviewClicked(View view) { startActivity(new Intent(MainActivity.this,Overview.class));
    }
}