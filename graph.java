package com.example.user.kinematicsolverv2;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.LegendRenderer;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class graph extends AppCompatActivity {

    LineGraphSeries<DataPoint> series;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        Intent intent2 = getIntent();
        if (true) {
            double acc = intent2.getDoubleExtra("acc",0);
            double vi = intent2.getDoubleExtra("initialvelocity", 0);
            //The key argument here must match that used in the other activity


            double d, t;
            t = 0;

            GraphView graph = (GraphView) findViewById(R.id.graph);
            series = new LineGraphSeries<DataPoint>();
            for (int i = 0; i < 500; i++) {
                t = t + 0.1;
                d = vi*t + (0.5 * acc * t * t);

                series.appendData(new DataPoint(t, d), true, 500);
            }
            graph.addSeries(series);
            graph.getLegendRenderer().setVisible(true);
            series.setTitle("Graph f(x) against Time");
            graph.getLegendRenderer().setTextSize(50);
            graph.getLegendRenderer().setTextColor(Color.BLACK);
            graph.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);
        }
    }
}
