package com.example.bmicalculator;

import android.content.DialogInterface;
import android.preference.DialogPreference;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public abstract class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mHeightEditText, mWeightEditText;
    private Button mCalculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHeightEditText = (EditText) findViewById(R.id.height_edit_text);
        mWeightEditText = (EditText) findViewById(R.id.weight_edit_text);
        mCalculateButton = (Button) findViewById(R.id.calculate_button);

        mCalculateButton.setOnClickListener(this);

        mCalculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String heightText = mHeightEditText.getText().toString();
                Double height = Double.valueOf(heightText);

                Double weight = Double.valueOf(mWeightEditText.getText().toString());

                Double bmi = weight / (height / 100) * (height / 100);

                String bmiText = getBmiText(bmi);


                String result = String.format("ค่า BMI ที่นี้คือ %.1f\n\nอยู่ในเกณฑ์ : %s" ,bmi,bmiText);
                result += "\n\n อยู่ในเกณฑ์ : " + bmiText;

                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("BMI Result");
                dialog.setMessage(result);
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mHeightEditText.setText("");
                        mWeightEditText.setText("");
                    }
                });
                dialog.show();
            }
        });

    }//ปิด Method Oncreate

    private String getBmiText(double bmi) {
        String bmiText = "";

        if (bmi < 18.5) {
            bmiText = "นํ้าหนักน้อยกว่าปกติ";
        } else if (bmi < 25) {
            bmiText = "นํ้าหนักปกติ";
        } else if (bmi < 30){
            bmiText = " นํ้าหนักมากกว่าปกติ (ท้วม)";
        } else {
            bmiText = "นํ้าหนักมากกว่าปกติ (อ้วน)";
        }
        return bmiText;
    }
}//ปิด Main











        /*
        MyListener listener = new MyListener();

        mCalculateButton.setOnClickListener(listener);
        */


    /*
    public void onClick(View v){

    }
    */
/*
    private class MyListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Toast t = Toast.makeText(MainActivity.this,"Hello",Toast.LENGTH_SHORT);
            t.show();
        }
*/


