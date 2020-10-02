package com.aec.civilapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class socialcalc extends AppCompatActivity {
    public EditText etAadt;
    public EditText etLpSchool;
    public EditText etHighSchool;
    public EditText etColleges;
    public EditText etSubCentre;
    public EditText etHospitals;
    public EditText etDailyMarkets;
    public EditText etWeeklyMarket;
    public RadioButton rbPlain;
    public RadioButton rbRolling;
    public RadioButton rbMountainous;
    public RadioButton rbSteep;
    public RadioButton rbInd0;
    public RadioButton rbInd1;
    public RadioButton rbInd2;
    public RadioButton rbInd3;
    public RadioButton rbInd4;
    public RadioButton rbInd5;
    public RadioButton rbTour0;
    public RadioButton rbTour1;
    public RadioButton rbTour2;
    public RadioButton rbTour3;
    public RadioButton rbTour4;
    public RadioButton rbTour5;
    public RadioButton rbMdr;
    public RadioButton rbSh;
    public Button btnSiiCalculate;
    public TextView tvPsSiiAnswer;
    public TextView tvSiiAnswer;
    public TextView tvConfused;
    public RadioGroup rgTerrain;
    public RadioGroup rgIndustries;
    public RadioGroup rgTourist;
    public RadioGroup rgRoadClassification;
    double terr;
    double ind;
    double tour;
    double rc;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_socialcalc);

        etAadt = (EditText) findViewById(R.id.etAadt);
        etLpSchool = (EditText) findViewById(R.id.etLpSchool);
        etHighSchool = (EditText) findViewById(R.id.etHighSchool);
        etColleges = (EditText) findViewById(R.id.etColleges);
        etSubCentre = (EditText) findViewById(R.id.etSubCentre);
        etHospitals = (EditText) findViewById(R.id.etHospitals);
        etDailyMarkets = (EditText) findViewById(R.id.etDailyMarkets);
        etWeeklyMarket = (EditText) findViewById(R.id.etWeeklyMarket);

        rgTerrain = findViewById(R.id.rgTerrain);
        rgTerrain.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rbPlain) { terr = 0.5; }
                else if (checkedId == R.id.rbRolling) { terr = 2; }
                else if (checkedId == R.id.rbMountainous) { terr = 3.5; }
                else if (checkedId == R.id.rbSteep) { terr = 5; }
            }

        });

        rgIndustries = findViewById(R.id.rgIndustries);
        rgIndustries.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rbInd0) { ind = 0; }
                else if (checkedId == R.id.rbInd1) { ind = 1; }
                else if (checkedId == R.id.rbInd2) { ind = 2; }
                else if (checkedId == R.id.rbInd3) { ind = 3; }
                else if (checkedId == R.id.rbInd4) { ind = 4; }
                else if (checkedId == R.id.rbInd5) { ind = 5; }
            }

        });




        rgTourist = findViewById(R.id.rgTourist);
        rgTourist.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rbTour0) { tour = 0; }
                else if (checkedId == R.id.rbTour1) { tour = 1; }
                else if (checkedId == R.id.rbTour2) { tour = 2; }
                else if (checkedId == R.id.rbTour3) { tour = 3; }
                else if (checkedId == R.id.rbTour4) { tour = 4; }
                else if (checkedId == R.id.rbTour5) { tour = 5; }
            }

        });

        rgRoadClassification = findViewById(R.id.rgRoadClassification);
        rgRoadClassification.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rbMdr) { rc = 2; }
                else if (checkedId == R.id.rbSh) { rc = 5; }
            }

        });

        btnSiiCalculate = (Button) findViewById(R.id.btnSiiCalculate);
        tvSiiAnswer = (TextView) findViewById(R.id.tvSiiAnswer);
        tvPsSiiAnswer = (TextView) findViewById(R.id.tvPsSiiAnswer);
        tvConfused = (TextView) findViewById(R.id.tvConfused);
        btnSiiCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                double pcu,lp,hs,col,sc,hos,dm,wm,pcuf=0.00,ef=0.00,mf=0.00,mkf=0.00,siitotal,pssiitotal;
                pcu = Double.parseDouble(etAadt.getText().toString());
                lp = Double.parseDouble(etLpSchool.getText().toString());
                hs = Double.parseDouble(etHighSchool.getText().toString());
                col = Double.parseDouble(etColleges.getText().toString());
                sc = Double.parseDouble(etSubCentre.getText().toString());
                hos = Double.parseDouble(etHospitals.getText().toString());
                dm = Double.parseDouble(etDailyMarkets.getText().toString());
                wm = Double.parseDouble(etWeeklyMarket.getText().toString());

                // FOR PCU

                if (pcu < 1000) {  pcuf = 0;}
                else if (pcu >= 1000 && pcu < 4000) { pcuf = 1; }
                else if (pcu >= 4000 && pcu < 6000) { pcuf = 2; }
                else if (pcu >= 6000 && pcu < 8000) { pcuf = 3; }
                else if (pcu >= 8000 && pcu <= 10000) { pcuf = 4; }
                else if (pcu>10000){ pcuf = 5; }

                // FOR EDUCATIONAL FACILITY

               /* if (lp==0 && hs==0 && col==0) {  ef = 0;}
                else if ((lp>0 && lp<3) || (hs<=1 && col==1)) { ef = 1; }
                else if ((lp>0 && lp<3) && (hs==1) || (col==1)) { ef = 2; }
                else if ((lp>0 && lp<3) || (hs==1) && (col==1)) { ef = 3; }
                else if ((lp>=3) || (hs>1) || (col==1)) { ef = 4; }
                else if ((lp>=3) && (hs>1) || (col>1)) { ef = 5; }//

                else if((lp>0 && lp<3)&&(hs==1)&&(col==1)) { ef =1; }*/




//
//                if (lp==0 && hs==0 && col==0) {  ef = 0;}
//                else if ((lp>=0 && lp<=3) && (hs<=1) && (col>=0 && col<2)) { ef = 1; }
//                else if ((lp>0 && lp<=3) && (hs<=1) && (col==1)) { ef = 2; }
//                else if ((lp>=3) && (hs<2) && (col<=2)) { ef = 3; }
//                else if ((lp>=3) && (hs>=2) && (col<=3)) { ef = 4; }
//                else if ((lp>3) && (hs>2) && (col>3)) { ef = 5; }



                if(col>1) { ef=5; }


                else if(col==1) {
                    if (lp >= 3 && hs > 1) {
                        ef = 4;
                    } else if (lp >= 3 && hs == 0) {
                        ef = 4;//  ************ check this out whether it should be 4 or 3??
                    } else if (lp < 3 && hs > 1) {
                        ef = 4; //  ************ orcheck this out whether it should be 4 or 3??
                    } else if (lp == 2 && hs == 1) {
                        ef = 3;
                    } else if (lp == 1 && hs <= 1) {
                        ef = 2;
                    } else if (lp == 0 && hs == 0) {
                        ef = 1; //
                    }
                }
                else if (col == 0)
                {
                    if(lp>=3 && hs>1)
                    {
                        ef=4;
                    }
                    else if (lp>=3 && hs==1)
                    {
                        ef=3;
                    }
                    else if( lp>=3 && hs==0)
                    {
                        ef =2;
                    }
                    else if((lp>0 &&lp<3) && hs>1)
                    {
                        ef=3;
                    }
                    else if(lp==0 && hs>1)
                    {
                        ef=2;
                    }
                    else if((lp>0 &&lp<3) && hs<=1)
                    {
                        ef=2;
                    }
                    else if (lp==0 && hs==1)
                    {
                        ef=1;
                    }
                    else if(lp==0 && hs==0)
                    {
                        ef=0;
                    }
                }



                // B I N O D programming

                // MEDICAL FACILITY
//                if (sc == 0 && hos==0) {  mf = 0;}
//                else if ((sc == 0) ||  (hos>0 && hos<2)) { mf = 1; }
//                else if ((sc == 0) && (hos>0 && hos<=2)) {mf = 2; }
//                else if ((sc>0 && sc <=2) && (hos>0 && hos<=2)) { mf = 3; }
//                else if ((sc>0 && sc <=2) && (hos>2)) { mf = 4; }
//                else if (sc>2 && hos>2)  { mf = 5; }
//
                if(hos==0)
                {
                    if(sc==0){ mf=0; }
                    else{
                        Toast.makeText(socialcalc.this, "You should have at least one hospital for a Sub Centre!!! ", Toast.LENGTH_LONG).show();
                    }

                }
                else if(hos==1)
                {
                    if(sc==0){mf=1;}// 1????
                    else if(sc>0 && sc<=3){ mf=2; }
                    else if (sc>3){mf=3;}
                }
                else if(hos==2){
                    if(sc==0){mf=2;}
                    else if (sc>0 && sc<=2){mf=3;}
                    else if(sc>2){mf=4;}
                }
                else if(hos>2) {
                    if(sc==0){mf=3;}
                    else if(sc>0 && sc<=2){mf=4;}
                    else{mf=5;}
                }




//                // Market facility
//                if (dm == 0 && wm==0) {  mkf = 0;}
//                else if ((dm == 0) ||  (wm>0 && wm<2)) { mkf = 1; }
//                else if ((dm == 0) && ( wm==2)) {mkf = 2; }
//                else if ((dm>0 && dm <=2) && (wm>0 && wm<=2)) { mkf = 3; }
//                else if ((dm>0 && dm <=2) && (wm>2)) { mkf = 4; }
//                else if (dm>2 && wm>2)  { mkf = 5; }


                if(wm==0)
                {
                    if(dm==0){ mkf=0; }
                    else if(dm>0 && dm<=2){mkf=1;}
                    else{mkf=2;}


                }
                else if(wm==1)
                {
                    if(dm==0){ mkf=1;}// 1????
                    else if(dm>0 && dm<=3){ mkf=2; }
                    else if (dm>3){ mkf=3;}
                }
                else if(wm==2){
                    if(dm==0){mkf=2;}
                    else if (dm>0 && dm<=2){ mkf=3;}
                    else if(dm>2){ mkf=4;}
                }
                else if(wm>2) {
                    if(dm==0){ mkf=3;}
                    else if(dm>0 && dm<=2){ mkf=4;}
                    else { mkf=5;}
                }




                siitotal=(terr+ind+tour+pcuf+ef+mf+mkf+rc);
                double roundedsiitotal = (double)Math.round(siitotal * 100d) / 100d;

                tvSiiAnswer.setText("SII score is "+roundedsiitotal);

                pssiitotal=(2.5*siitotal);
                double roundedpssiitotal = (double)Math.round(pssiitotal * 100d) / 100d;
                tvPsSiiAnswer.setText("PS For SII is "+roundedpssiitotal);


                //Store data
                SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0);
                SharedPreferences.Editor editor = pref.edit();

                editor.putString("indirectSii", ""+roundedsiitotal); // Storing string

                editor.apply();





            }
        });



    }
}