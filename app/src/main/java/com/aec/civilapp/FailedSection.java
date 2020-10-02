package com.aec.civilapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FailedSection extends AppCompatActivity {

    public EditText areaoffailedsection;
    public TextView answer;
    public TextView pciscore;
    public Button submitfailedsection;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_failed_section);
        areaoffailedsection = (EditText) findViewById(R.id.areaoffailedsection);
        answer = (TextView) findViewById(R.id.answer);
       pciscore = (TextView) findViewById(R.id.pciscore);
        submitfailedsection = (Button) findViewById(R.id.submitfailedsection);
        submitfailedsection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double a,c;
                double b;
                double d;
                a = Double.parseDouble(areaoffailedsection.getText().toString());
                if(a == 0)
                {
                    b=0;
                }
                else if(a>0 && a<=25)
                {
                    b=0.25;
                }
                else if(a>25 && a<=50) {
                    b=0.50;
                }
                else if(a>50 && a<=75)
                {
                    b=0.75;
                }
                else
                {
                    b=1;
                }
                c=b*100;
                double roundedc = (double)Math.round(c * 100d) / 100d;
                answer.setText("Distress Score is "+roundedc);
                d=100-c;
                double roundedd = (double)Math.round(d * 100d) / 100d;
                pciscore.setText("PCI Score is "+roundedd);


                //Store data
                SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0);
                SharedPreferences.Editor editor = pref.edit();

                editor.putString("failedSection", ""+roundedd); // Storing string

                editor.apply();

            }
        });
    }
}