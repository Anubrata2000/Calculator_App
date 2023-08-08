package com.example.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText ed1;
    TextView tvResult;
    String op="+";
    String oldValue="",newValue="";
    boolean isFirst=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1=findViewById(R.id.editText);
        tvResult = findViewById(R.id.tvResult);
    }

    public void numberEvent(@NonNull View view) {

        String num=ed1.getText().toString();
        switch (view.getId()){
            case R.id.bu1:
                num+="1";
                break;
            case R.id.bu2:
                num+="2";
                break;
            case R.id.bu3:
                num+="3";
                break;
            case R.id.bu4:
                num+="4";
                break;
            case R.id.bu5:
                num+="5";
                break;
            case R.id.bu6:
                num+="6";
                break;
            case R.id.bu7:
                num+="7";
                break;
            case R.id.bu8:
                num+="8";
                break;
            case R.id.bu9:
                num+="9";
                break;
            case R.id.bu0:
                num+="0";
                break;

        }
        ed1.setText(num);
    }

    public void operatorEvent(View view) {
        oldValue=ed1.getText().toString();
        ed1.setText("");
        switch (view.getId())
        {
            case R.id.buplus:
                op="+";
                break;
            case R.id.buminus:
                op="-";
                break;
            case R.id.bumultiply:
                op="*";
                break;
            case R.id.budivide:
                op="/";
                break;
            case R.id.budot:
                op=".";
                break;
            case R.id.bumodulus:
                op="%";
                break;
        }
    }


    public void clearScreenEvent(View view) {
        ed1.setText(""); tvResult.setText(""); // Clear the text in the EditText
    }


    public void equalEvent(View view) {
        newValue = ed1.getText().toString();
        double result = 0.0;
        switch (op) {
            case "%":
                result = Double.parseDouble(String.valueOf(Integer.parseInt(oldValue)%Integer.parseInt(newValue)));
                break;
            case "+":
                result = Double.parseDouble(oldValue) + Double.parseDouble(newValue);
                break;
            case "-":
                result = Double.parseDouble(oldValue) - Double.parseDouble(newValue);
                break;
            case "*":
                result = Double.parseDouble(oldValue) * Double.parseDouble(newValue);
                break;
            case "/":
                result = Double.parseDouble(oldValue) / Double.parseDouble(newValue);
                break;
            case ".":
                result = Double.parseDouble(oldValue) + Double.parseDouble(newValue) / Math.pow(10, newValue.length());
                break;
        }
        tvResult.setText(String.valueOf(result));
    }

}