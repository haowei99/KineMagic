package com.example.user.kinematicsolverv2;

import android.content.Intent;
import android.media.Image;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import java.util.stream.*;
import java.text.DecimalFormat;
import android.widget.Toast;
import android.widget.ImageButton;
import android.view.View;
import android.view.View.OnClickListener;
import java.io.InputStreamReader;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import java.lang.Math;
import java.lang.Exception;
import java.lang.Throwable;


public class MainActivity extends AppCompatActivity {
    ImageButton graphbutton;
    Button calc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        graphbutton = (ImageButton) findViewById(R.id.graph_button);

        getSupportActionBar().setTitle("KineMagic");


        /* calc.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) { */
        final EditText[] et1 = new EditText[]{
                (EditText) findViewById(R.id.acc),
                (EditText) findViewById(R.id.distance),
                (EditText) findViewById(R.id.velocity),
                (EditText) findViewById(R.id.velocityinitial),
                (EditText) findViewById(R.id.time), //calling edit text by calling unique id
                (EditText) findViewById(R.id.distanceinitial),
        };

        final double[] grades = new double[]{0.0000001, 0.0000001, 0.0000001, 0.0000001, 0.0000001, 0.0000001, 0.0000001, 0.0000001, 0.0000001, 0.0000001}; //initializing to set as 0

        calc = (Button) findViewById(R.id.calc);

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView unknown = (TextView) findViewById(R.id.unknown);


                for (int i = 0; i < 6; i++) {
                    if (et1[i].getText().toString().isEmpty()) {
                        grades[i] = 0.0000001;

                    } // for loop go over all the text to check if it is empty, if it is empty it is 0
                    else {
                        grades[i] = Double.parseDouble(et1[i].getText().toString()); // or else it is the grade

                    }
                }
                ;

                if ((grades[3] != 0.0000001) && (grades[4] != 0.0000001) && (grades[0] != 0.0000001)) {

                    double a = Calculation.DisplacementA(grades[3], grades[4], grades[0]);
                    double b = Calculation.FinalVelocityT(grades[3], grades[4], grades[0]);
                    unknown.setText(String.format("%.2f", a) + " m," + String.format("%.2f", b) + " m/s");

                } else if ((grades[3] != 0.0000001) && (grades[0] != 0.0000001) && (grades[1] != 0.0000001)) {

                    double a = Calculation.FinalVelocityD(grades[3], grades[0], grades[1]);
                    unknown.setText(String.format("%.2f", a) + "m/s");

                } else if ((grades[3] != 0.0000001) && (grades[2] != 0.0000001) && (grades[4] != 0.0000001)) {

                    double a = Calculation.DisplacementV(grades[3], grades[2], grades[4]);
                    double b = Calculation.AccelerationVf(grades[3], grades[2], grades[4]);
                    unknown.setText(String.format("%.2f", a) + " m," + String.format("%.2f", b) + " m/s^2");

                } else if ((grades[1] != 0.0000001) && (grades[0] != 0.0000001) && (grades[4] != 0.0000001)) {

                    double a = Calculation.InitialVelocityT(grades[1], grades[0], grades[4]);
                    unknown.setText(String.format("%.2f", a) + "m/s");

                } else if ((grades[2] != 0.0000001) && (grades[0] != 0.0000001) && (grades[1] != 0.0000001)) {

                    double a = Calculation.InitialVelocityD(grades[2], grades[0], grades[1]);
                    unknown.setText(String.format("%.2f", a) + "m/s");

                } else if ((grades[3] != 0.0000001) && (grades[1] != 0.0000001) && (grades[0] != 0.0000001)) {

                    double a = Calculation.TimeD(grades[3], grades[1], grades[0]);
                    unknown.setText(String.format("%.2f", a) + "s");

                } else if ((grades[2] != 0.0000001) && (grades[3] != 0.0000001) && (grades[0] != 0.0000001)) {

                    double a = Calculation.TimeA(grades[2], grades[3], grades[0]);
                    unknown.setText(String.format("%.2f", a) + "s");
                } else if ((grades[3] != 0.0000001) && (grades[1] != 0.0000001) && (grades[4] != 0.0000001)) {

                    double a = Calculation.AccelerationT(grades[3], grades[2], grades[0]);
                    unknown.setText(String.format("%.2f", a) + "m/s^2");
                } else {
                    unknown.setText("Not enough variables");

                }

            }
        });

        /* Intent i = new Intent(MainActivity.this, graph.class);
        i.putExtra("acc", grades[0]);
        startActivity(i); */

        graphbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < 6; i++) {
                    if (et1[i].getText().toString().isEmpty()) {
                        grades[i] = 0;

                    } // for loop go over all the text to check if it is empty, if it is empty it is 0
                    else {
                        grades[i] = Double.parseDouble(et1[i].getText().toString()); // or else it is the grade

                    }
                }


                Intent i = new Intent (MainActivity.this, graph.class);
                i.putExtra("acc", grades[0]);
                i.putExtra("initialvelocity", grades[3]);

                startActivity(i);
            }
        });







    }

         //   });
        }  // ;

   // }
