package com.aec.civilapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class DataForPci extends AppCompatActivity {
    public Button failedsectioncalculation;
    public EditText crackingsize;
    public EditText crackingarea;
    public EditText rutDepth;
    public EditText rutDeptharea;
    public EditText ravellingarea;
    public EditText potholevol;
    public EditText potholenos;
    public EditText affected;
    public EditText edgebreakarea;
    public EditText differenceinheight;
    public EditText shoulder;
    public EditText shoulderlength;
    public RadioButton lossofMaterial;
    public RadioButton surfacetextureappearsasopen;
    public RadioButton wideopen;
    public RadioButton severestripping;
    public Button calculateDistress;
    public TextView answerDs2;
    public TextView answerPci;
    private Activity dialog;
    private RadioGroup radioGroup;
    double vif = 0.00;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_for_pci);
        crackingsize = (EditText) findViewById(R.id.crackingsize);
        crackingarea = (EditText) findViewById(R.id.crackingarea);
        rutDepth = (EditText) findViewById(R.id.rutDepth);
        rutDeptharea = (EditText) findViewById(R.id.rutDeptharea);
        potholevol = (EditText) findViewById(R.id.potholevol);
        potholenos = (EditText) findViewById(R.id.potholenos);
        affected = (EditText) findViewById(R.id.affected);
        edgebreakarea = (EditText) findViewById(R.id.edgebreakarea);
        shoulder = (EditText) findViewById(R.id.shoulder);
        shoulderlength = (EditText) findViewById(R.id.shoulderlength);
        ravellingarea = (EditText)findViewById(R.id.ravellingarea);

        //Radio Group
        radioGroup = findViewById(R.id.radioGroup1);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.lossofMaterial) { vif = 25.0; }
                else if (checkedId == R.id.wideopen) { vif = 75.0; }
                else if (checkedId == R.id.surfacetextureappearsasopen) { vif = 50.0; }
                else if (checkedId == R.id.severestripping) { vif = 100.0; }
            }

        });

        calculateDistress = (Button) findViewById(R.id.calculateDistress);
        answerDs2 = (TextView) findViewById(R.id.answerDs2);
        answerPci = (TextView) findViewById(R.id.answerPci);
        calculateDistress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double cracking1, rutting1, ravelling1, pothole1, edgebreak1, shoulderdrop1;
                cracking1 = 0.20;
                rutting1 = 0.20;
                ravelling1 = 0.20;
                pothole1 = 0.20;
                edgebreak1 = 0.10;
                shoulderdrop1 = 0.10;
                double cw, rd, vo, ade, dh, cwf, rdf, vof, adef, dhf;
                cw = Double.parseDouble(crackingsize.getText().toString());
                rd = Double.parseDouble(rutDepth.getText().toString());
                vo = Double.parseDouble(potholevol.getText().toString());
                ade = Double.parseDouble(affected.getText().toString());
                dh = Double.parseDouble(shoulder.getText().toString());

                // FOR CRACKING WIDTH
                if (cw == 0) {  cwf = 0;}
                else if (cw > 0 && cw <= 6) { cwf = 25; }
                else if (cw > 6 && cw <= 12) { cwf = 50; }
                else if (cw > 12 && cw <= 19) { cwf = 75; }
                else { cwf = 100; }


                if (rd == 0) { rdf = 0; }
                else if (rd > 0 && rd <= 6) { rdf = 25; }
                else if (rd > 6 && rd <= 12) { rdf = 50; }
                else if (rd > 12 && rd <= 25) { rdf = 75; }
                else { rdf = 100; }



                if (vo == 0) { vof = 0; }
                else if (vo > 0 && vo <= 130) { vof = 25; }
                else if (vo > 130 && vo<= 500) { vof = 50; }
                else if (vo > 500 && vo <= 1000) { vof = 75; }
                else { vof = 100; }





                if (ade == 0) { adef = 0; }
                else if (ade > 0 && ade <= 50) { adef = 25; }
                else if (ade > 50 && ade <= 100) { adef = 50; }
                else if (ade > 100 && ade <= 200) { adef = 75; }
                else { adef = 100; }


                if (dh == 0) { dhf = 0; }
                else if (dh > 0 && dh <= 10) { dhf = 25; }
                else if (dh > 10 && dh <= 50) { dhf = 50; }
                else if (dh > 50 && dh <= 100) { dhf = 75; }
                else { dhf = 100; }


                double pcd,prd,pvi,pvo,pade,psl,pcdf,prdf,pvif,pvof,padef,pslf,t1,t2,t3,t4,t5,t6,total,totalpci;
                pcd = Double.parseDouble(crackingarea.getText().toString());
                prd = Double.parseDouble(rutDeptharea.getText().toString());
                pvi = Double.parseDouble(ravellingarea.getText().toString());
                pvo = Double.parseDouble(potholenos.getText().toString());
                pade = Double.parseDouble(edgebreakarea.getText().toString());
                psl = Double.parseDouble(shoulderlength.getText().toString());

                if(pcd == 0) { pcdf=0; }
                else if(pcd>0 && pcd<=25) { pcdf=0.25; }
                else if(pcd>25 && pcd<=50) { pcdf=0.50; }
                else if(pcd>50 && pcd<=75) { pcdf=0.75; }
                else { pcdf=1; }



                if(prd == 0) { prdf=0; }
                else if(prd>0 && prd<=25) { prdf=0.25; }
                else if(prd>25 && prd<=50) { prdf=0.50; }
                else if(prd>50 && prd<=75) { prdf=0.75; }
                else { prdf=1; }


                if(pvi == 0) { pvif=0; }
                else if(pvi>0 && pvi<=25) { pvif=0.25; }
                else if(pvi>25 && pvi<=50) { pvif=0.50; }
                else if(pvi>50 && pvi<=75) { pvif=0.75; }
                else { pvif=1; }


                if(pvo == 0) { pvof=0; }
                else if(pvo>0 && pvo<=5) { pvof=0.25; }
                else if(pvo>5 && pvo<=10) { pvof=0.50; }
                else if(pvo>10 && pvo<=25) { pvof=0.75; }
                else { pvof=1; }



                if(pade == 0) { padef=0; }
                else if(pade>0 && pade<=25) { padef=0.25; }
                else if(pade>25 && pade<=50) { padef=0.50; }
                else if(pade>50 && pade<=75) { padef=0.75; }
                else { padef=1; }

                if(psl == 0) { pslf=0; }
                else if(psl>0 && psl<=25) { pslf=0.25; }
                else if(psl>25 && psl<=50) { pslf=0.50; }
                else if(psl>50 && psl<=75) { pslf=0.75; }
                else { pslf=1; }

                t1=cracking1*cwf*pcdf;
                t2=rutting1*rdf*prdf;
                t3=ravelling1*vif*pvif;
                t4=pothole1*vof*pvof;
                t5=edgebreak1*adef*padef;
                t6=shoulderdrop1*dhf*pslf;

                total=t1+t2+t3+t4+t5+t6;
                answerDs2.setText("Distress Score is "+total);
                totalpci=100-total;
                double roundedtotalpci = (double)Math.round(totalpci * 100d) / 100d;
                answerPci.setText("PCI is "+roundedtotalpci);

                //Store data
                SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0);
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("totalPci", ""+roundedtotalpci); // change this line
                editor.apply();

            }
            });
            }

    public void failedSectionClicked(View view) {
        startActivity(new Intent(this, FailedSection.class));
    }
}