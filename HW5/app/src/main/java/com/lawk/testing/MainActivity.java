package com.lawk.testing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    double[] gasOctanes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClick(View view) {
        TextView octane = (TextView) findViewById(R.id.questionText);
        Spinner listOctane = (Spinner) findViewById(R.id.gasSpinner);
        TextView mpgQuestion = (TextView) findViewById(R.id.enterMPG);
        EditText mpgAnswered = (EditText) findViewById(R.id.mpgReply);
        TextView milesQuestion = (TextView) findViewById(R.id.enterMiles);
        EditText milesEntered = (EditText) findViewById(R.id.milesEntered);
        TextView output = (TextView) findViewById(R.id.Calculated);

        String milesEnt = milesEntered.getText().toString();
        String octaneSelected = String.valueOf(listOctane.getSelectedItem());
        String mpgAns = mpgAnswered.getText().toString();
        if (!mpgAns.isEmpty() && !milesEnt.isEmpty()) {
            int mpg = Integer.parseInt(mpgAns);
            int miles = Integer.parseInt(milesEnt);
            MPG mpgCalc = new MPG(miles, mpg);


            Double costs = mpgCalc.calculateCost(octaneSelected);

            output.setText(String.format("$%.02f", costs));

        } else {
            Toast.makeText(this, "Miles Per Gallon and/or miles must be a whole number", Toast.LENGTH_SHORT).show();
        }

    }
}
