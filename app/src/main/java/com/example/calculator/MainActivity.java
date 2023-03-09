package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText ed1;
    String op="+";
    String oldValue="",newValue="";
    boolean isFirst=true
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1=findViewById(R.id.editText);
    }

    public void numberEvent(View view) {

                ed1.setText("");

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
        }
    }

    public void equalEvent(View view) {
        newValue=ed1.getText().toString();
        double result=0.0;
        switch (op){
            case "+":
                result=Double.parseDouble(oldValue)+Double.parseDouble(newValue);break;
            case "-":
                result=Double.parseDouble(oldValue)-Double.parseDouble(newValue);break;
            case "*":
                result=Double.parseDouble(oldValue)*Double.parseDouble(newValue);break;
        }
        ed1.setText((result+""));
    }
}