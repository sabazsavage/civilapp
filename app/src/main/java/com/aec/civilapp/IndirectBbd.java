package com.aec.civilapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class IndirectBbd extends AppCompatActivity {

    public EditText bbdIndSc;
    public EditText bbdIndBc;
    public EditText bbdIndSb;
    public EditText bbdIndSg;
    public EditText bbdIndCbr;
    public TextView tvansCd;
    public Button btnIndBbd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indirect_bbd);

        bbdIndSc=(EditText)findViewById(R.id.bbdIndSurfaceCourse);
        bbdIndBc=(EditText)findViewById(R.id.bbdIndBaseCourse);
        bbdIndSb=(EditText)findViewById(R.id.bbdIndSubBase);
        bbdIndSg=(EditText)findViewById(R.id.bbdIndSubgrade);
        bbdIndCbr=(EditText)findViewById(R.id.bbdIndCbr);
        btnIndBbd=(Button)findViewById(R.id.btnIndBbd);
        tvansCd=(TextView)findViewById(R.id.tvAnsCd);


        btnIndBbd.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                double sc,bc,sb,sg,cbr,D1,SN,CD;
                sc = Double.parseDouble(bbdIndSc.getText().toString());
                bc = Double.parseDouble(bbdIndBc.getText().toString());
                sb = Double.parseDouble(bbdIndSb.getText().toString());
                cbr = Double.parseDouble(bbdIndCbr.getText().toString());
                sg = Double.parseDouble(bbdIndCbr.getText().toString());
                D1=sc+bc;
                SN=(0.44*D1)+(0.14*sb)+(0.11*sg);
                CD= ((4.52656)+((-0.00845)*SN)+((-0.3972)*cbr)+((-9.40488)*Math.pow(10,-5)*Math.pow(SN,2))+((0.01931)*Math.pow(cbr,2)));

                double roundedCD = (double)Math.round(CD * 100d) / 100d;
                tvansCd.setText("Characteristic Deflection is "+roundedCD+ " mm");




                //Store data
                SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0);
                SharedPreferences.Editor editor = pref.edit();

                editor.putString("indirectBbd", ""+roundedCD); // Storing string

                editor.apply();









            }
        }));


    }
}