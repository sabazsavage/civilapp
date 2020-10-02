package com.aec.civilapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class IndirectIri extends AppCompatActivity {
    private RadioGroup iriRadioGroup1;
    private RadioGroup iriRadioGroup2;
    public RadioButton iriBtn1;
    public RadioButton iriBtn2;
    public RadioButton iriBtn3;
    public RadioButton iriBtn4;
    public RadioButton iriBtn5;
    public RadioButton iriBtn6;
    public RadioButton iriBtn7;
    public RadioButton iriBtn8;
    public RadioButton iriBtn9;
    public RadioButton iriBtn10;
    public Button rqrCalculate;
    public TextView tvAnswer;
    double rcomf;        // RQR COMFORT
    double rspeed; // RQR Speed
    double irifinal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indirect_iri);
        iriRadioGroup1 = findViewById(R.id.iriRadioGroup1);


                iriRadioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        if (checkedId == R.id.iriBtn1) {
                            rcomf = 90.00;
                        } else if (checkedId == R.id.iriBtn2) {
                            rcomf = 70.00;
                        } else if (checkedId == R.id.iriBtn3) {
                            rcomf = 50.00;
                        } else if (checkedId == R.id.iriBtn4) {
                            rcomf = 30.00;
                        } else if (checkedId == R.id.iriBtn5) {
                            rcomf = 10.00;
                        }
                    }


                });
                iriRadioGroup2 = findViewById(R.id.iriRadioGroup2);
                iriRadioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                        if (checkedId == R.id.iriBtn6) {
                            rspeed = 90.00;
                        } else if (checkedId == R.id.iriBtn7) {
                            rspeed = 70.00;
                        } else if (checkedId == R.id.iriBtn8) {
                            rspeed = 50.00;
                        } else if (checkedId == R.id.iriBtn9) {
                            rspeed = 30.00;
                        } else if (checkedId == R.id.iriBtn10) {
                            rspeed= 10.00;
                        }
                    }

                });

        tvAnswer = (TextView) findViewById(R.id.tvAnswer);
        rqrCalculate=(Button)findViewById(R.id.rqrCalculate);
        rqrCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double d;

                d=-1.10409*Math.pow(10,-4);
                irifinal =((35.621)-(0.6607*rcomf)+(0.02628*rspeed)+(0.00322*Math.pow(rcomf,2))+(d*Math.pow(rspeed,2)));
                double roundedirifinal = (double)Math.round(irifinal * 100d) / 100d;
                tvAnswer.setText("IRI value is "+roundedirifinal+" m/km");


                //Store data
                SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0);
                SharedPreferences.Editor editor = pref.edit();

                editor.putString("indirectIri", ""+roundedirifinal); // Storing string

                editor.apply();


            }
        });


    }
}