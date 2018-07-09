package com.example.ajay.androidquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int ans1=0;
    private int ans2=0;
    private int ans3=0;
    private int correctAns = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Evaluating the question 1
        RadioGroup rg1 = (RadioGroup) findViewById(R.id.radiogroup1);
        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i == R.id.q1_radiobutton4){
                    ans1 = 1;
                    Log.i("1","question 1 "+ ans1);
                    Toast.makeText(MainActivity.this,
                            "correct", Toast.LENGTH_LONG).show();
                }else{
                    ans1 = 0;
                    Log.i("1","question 1 "+ ans1);
                }
            }
        });

        //Evaluating the question 2
        RadioGroup rg2 = (RadioGroup) findViewById(R.id.radiogroup2);
        rg2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                RadioButton checkedRadioButton = (RadioButton)radioGroup.findViewById(i);
                if(checkedRadioButton.getId() == R.id.q2_radiobutton1){
                    ans2 = 1;
                    Log.i("2","question 2 "+ ans2);
                    Toast.makeText(MainActivity.this,
                            "correct", Toast.LENGTH_LONG).show();
                }else{
                    ans2 = 0;
                    Log.i("2","question 2 "+ ans2);
                }
            }
        });

        RadioGroup rg3 = (RadioGroup) findViewById(R.id.radiogroup3);
        rg3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton checkedRadioButton = (RadioButton)radioGroup.findViewById(i);
                if(checkedRadioButton.getId() == R.id.q3_radiobutton3){
                    ans3 = 1;
                    Log.i("3","question 3 "+ ans3);
                    Toast.makeText(MainActivity.this,
                            "correct", Toast.LENGTH_LONG).show();
                }else{
                    ans3 = 0;
                    Log.i("3","question 3 "+ ans3);
                }
            }
        });

    }

    public void question_1(View view){

    }
}
