package com.aec.civilapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class PriorityScoreFinal extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_priority_score_final);

        TextView pci = (TextView)findViewById(R.id.tvPciOutput);

        TextView iri = (TextView)findViewById(R.id.tvIriOutput);

        TextView sii = (TextView) findViewById(R.id.tvSiiOutput);

        TextView bbd = (TextView) findViewById(R.id.tvBbdOutput);

        TextView pscore = (TextView) findViewById(R.id.tvPsOutput);
        


        //preferences
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0);

        //get data
        String failedSection = pref.getString("failedSection",null);
        String totalPci = pref.getString("totalPci",null);
        String indirectbbd = pref.getString("indirectBbd",null);
        String directbbd = pref.getString("directBbd",null);
        String indirectIri = pref.getString("indirectIri",null);
        String directIri = pref.getString("directIri",null);
        String indirectSii = pref.getString("indirectSii",null);
        String directSii = pref.getString("directSii",null);

        double myPCI=0.00;
        double myIRI=0.00;
        double mySII=0.00;
        double myBBD=0.00;

        try {
        //SetText
        if (failedSection == null){
            if (totalPci  == null) { pci.setText(""); }
            else {
                pci.setText("" + totalPci);
                myPCI = Double.parseDouble(totalPci);
            }
        }
        else if (totalPci == null) {
            pci.setText("" + failedSection);
            myPCI= Double.parseDouble(failedSection);
        }
        else {
            pci.setText("Enter either one of the values");
        }


        //SetText
        if (indirectIri == null){
            if( directIri == null) { iri.setText(""); }
            else {
                iri.setText("" + directIri);
                myIRI = Double.parseDouble(directIri);
            }
        }
        else if (directIri == null) {
            iri.setText("" + indirectIri);
            myIRI = Double.parseDouble(indirectIri);
        }
        else {
            iri.setText("Enter either one of the values");
        }


        //SetText
        if (indirectSii == null){
            if (directSii == null) { sii.setText(""); }
            else {
                sii.setText(""+directSii);
                mySII = Double.parseDouble(directSii);
            }
        }
        else if (directSii == null) {
            sii.setText("" + indirectSii);
            mySII = Double.parseDouble(indirectSii);
        }
        else {
            sii.setText("Enter either one of the values");
        }



        //SetText
        if (indirectbbd == null){
            if (directbbd == null) { bbd.setText(""); }
            else{
                bbd.setText(""+directbbd);
                myBBD = Double.parseDouble(directbbd);
            }
        }
        else if (directbbd == null) {
            bbd.setText("" + indirectbbd);
            myBBD = Double.parseDouble(indirectbbd);
        }
        else {
            bbd.setText("Enter either one of the values");
        }


        //Calc

            double result = (0.25*myPCI)+(0.15*myIRI)+(0.15*mySII)+(0.35*myBBD);
            double roundedResult = (double)Math.round(result * 100d) / 100d;

            pscore.setText(""+roundedResult);




        } catch (Exception e) { }

    }
}