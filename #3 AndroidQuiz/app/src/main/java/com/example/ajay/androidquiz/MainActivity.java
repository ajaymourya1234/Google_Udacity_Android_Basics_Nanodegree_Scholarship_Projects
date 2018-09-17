package com.example.ajay.androidquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //variables to check whether the answer entered is correct or not
    private int ans1 = 0;
    private int ans2 = 0;
    private int ans3 = 0;
    private int ans4 = 0;
    private int ans5 = 0;
    private int ans6 = 0;
    private int ans7 = 0;
    private int ans8 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Evaluating the question 1
        RadioGroup rg1 = (RadioGroup) findViewById(R.id.radiogroup1);
        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.q1_radiobutton4) {
                    ans1 = 1;
                } else {
                    ans1 = 0;
                }
            }
        });

        //Evaluating the question 2
        RadioGroup rg2 = (RadioGroup) findViewById(R.id.radiogroup2);
        rg2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.q2_radiobutton1) {
                    ans2 = 1;

                } else {
                    ans2 = 0;
                }
            }
        });

        //Evaluating the question 3
        RadioGroup rg3 = (RadioGroup) findViewById(R.id.radiogroup3);
        rg3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.q3_radiobutton3) {
                    ans3 = 1;

                } else {
                    ans3 = 0;
                }
            }
        });

        //Evaluating the question 4
        RadioGroup rg4 = (RadioGroup) findViewById(R.id.radiogroup4);
        rg4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.q4_radiobutton1) {
                    ans4 = 1;

                } else {
                    ans4 = 0;

                }
            }
        });


        RadioGroup rg8 = (RadioGroup) findViewById(R.id.radiogroup8);
        rg8.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.q8_radiobutton2) {
                    ans8 = 1;

                } else {
                    ans8 = 0;

                }
            }
        });
    }

    //Evaluating question 5
    public void checkboxClicked_5(View view) {
        CheckBox checkBox1 = (CheckBox) findViewById(R.id.q5_checkbox1);
        CheckBox checkBox2 = (CheckBox) findViewById(R.id.q5_checkbox2);
        CheckBox checkBox3 = (CheckBox) findViewById(R.id.q5_checkbox3);
        CheckBox checkBox4 = (CheckBox) findViewById(R.id.q5_checkbox4);

        if (checkBox4.isChecked() && checkBox2.isChecked() && !checkBox1.isChecked() && !checkBox3.isChecked()) {
            ans5 = 1;

        } else {
            ans5 = 0;
        }
    }

    //Evaluating question 6
    public void checkboxClicked_6(View view) {
        CheckBox checkBox1 = (CheckBox) findViewById(R.id.q6_checkbox1);
        CheckBox checkBox2 = (CheckBox) findViewById(R.id.q6_checkbox2);
        CheckBox checkBox3 = (CheckBox) findViewById(R.id.q6_checkbox3);
        CheckBox checkBox4 = (CheckBox) findViewById(R.id.q6_checkbox4);

        if (checkBox1.isChecked() && checkBox2.isChecked() && !checkBox3.isChecked() && !checkBox4.isChecked()) {
            ans6 = 1;

        } else {
            ans6 = 0;
        }
    }


    public void submit(View view) {

        EditText text = (EditText) findViewById(R.id.edittext);
        String value = text.getText().toString();
        if (value.equalsIgnoreCase("Android")) {
            ans7 = 1;

        }
        int result = ans1 + ans2 + ans3 + ans4 + ans5 + ans6 + ans7 + ans8;
        Toast.makeText(MainActivity.this, "You have answered " + result + " questions correctly",
                Toast.LENGTH_LONG).show();

    }
}
