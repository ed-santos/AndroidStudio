package com.example.testdev1;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnClickAdd(View btnView) {

        TextView result =  (TextView) findViewById(R.id.lblView);

        EditText num1 = (EditText) findViewById(R.id.txtFirstNumber);
        EditText num2= (EditText) findViewById(R.id.txtSecondNumber);

        int sum = Integer.parseInt(num1.getText().toString()) + Integer.parseInt(num2.getText().toString());


        result.setText("Addition result = " + Integer.toString(sum));
    }

    public void btnClickMinus(View btnView) {

        TextView result =  (TextView) findViewById(R.id.lblView);

        EditText num1 = (EditText) findViewById(R.id.txtFirstNumber);
        EditText num2= (EditText) findViewById(R.id.txtSecondNumber);

        int sum = Integer.parseInt(num1.getText().toString()) - Integer.parseInt(num2.getText().toString());


        result.setText("Subtract result = " + Integer.toString(sum));
    }

    public void btnClickMul(View btnView) {

        TextView result =  (TextView) findViewById(R.id.lblView);

        EditText num1 = (EditText) findViewById(R.id.txtFirstNumber);
        EditText num2= (EditText) findViewById(R.id.txtSecondNumber);

        int sum = Integer.parseInt(num1.getText().toString()) * Integer.parseInt(num2.getText().toString());


        result.setText("Multiply result = " + Integer.toString(sum));
    }

    public void btnClickDiv(View btnView) {

        TextView result =  (TextView) findViewById(R.id.lblView);

        EditText num1 = (EditText) findViewById(R.id.txtFirstNumber);
        EditText num2= (EditText) findViewById(R.id.txtSecondNumber);

        int sum = Integer.parseInt(num1.getText().toString()) / Integer.parseInt(num2.getText().toString());


        result.setText("Division result = " + Integer.toString(sum));
    }
}
