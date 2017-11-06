package cs2340.gatech.edu.rat_tracker.controllers;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;

import cs2340.gatech.edu.rat_tracker.R;
import cs2340.gatech.edu.rat_tracker.model.Model;
import cs2340.gatech.edu.rat_tracker.model.RatSighting;

/**
 * Created by Aadarsh on 10/26/2017.
 */

public class StatsScreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats_screen);
        ArrayList<RatSighting> rats = Model.getInstance().getAllRatData();
        rats.sort(new Comparator<RatSighting>() {
            @Override
            public int compare(RatSighting rat1, RatSighting rat2) {
                return rat1.getDate().compareTo(rat2.getDate());
            }
        });
        System.out.println(rats.size());
        int dateRange = rats.get(rats.size() - 1).calculateDateInt()
                - rats.get(0).calculateDateInt();
        int offset = rats.get(0).calculateDateInt();
        int[] sightsPerMonth = new int[dateRange + 1];
        for (int i = 0; i < rats.size(); i++) {
            int index = rats.get(i).calculateDateInt() - offset;
            sightsPerMonth[index] += 1;
        }

        GraphView graph = (GraphView) findViewById(R.id.graph);
        DataPoint[] dataPoints = new DataPoint[sightsPerMonth.length];
        for (int i = 0; i < sightsPerMonth.length; i++) {
            dataPoints[i] = new DataPoint(i + 1, sightsPerMonth[i]);
        }
        BarGraphSeries<DataPoint> series = new BarGraphSeries<>(dataPoints);
//                new DataPoint[] {
//                new DataPoint(0, 1),
//                new DataPoint(1, 2),
//                new DataPoint(2, 3),
//                new DataPoint(3, 4)
//        });
        graph.addSeries(series);
        series.setSpacing(50);
        graph.getViewport().setMinX(-1);
        graph.getViewport().setMaxX(27);
        graph.getViewport().setScalableY(true);
        graph.getGridLabelRenderer().setHorizontalAxisTitle("Date");
        graph.getGridLabelRenderer().setVerticalAxisTitle("Number of Sightings");
    }



}
