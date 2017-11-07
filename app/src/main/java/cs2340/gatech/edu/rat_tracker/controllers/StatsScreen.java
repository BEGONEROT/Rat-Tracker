package cs2340.gatech.edu.rat_tracker.controllers;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.LinearLayout;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.yahoo.mobile.client.android.util.rangeseekbar.RangeSeekBar;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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
        int numMonths = 0;
        for (int i = 0; i < sightsPerMonth.length; i++) {
            dataPoints[i] = new DataPoint(i + 1, sightsPerMonth[i]);
            Log.d("DATA POINT:", "first: " + (i+1) + " second: " + sightsPerMonth[i] );
            numMonths++;
        }
        //saved data points

        BarGraphSeries<DataPoint> series = new BarGraphSeries<>(dataPoints);
//                new DataPoint[] {
//                new DataPoint(0, 1),
//                new DataPoint(1, 2),
//                new DataPoint(2, 3),
//                new DataPoint(3, 4)
//        });
        graph.addSeries(series);
        LinearLayout layout = (LinearLayout) findViewById(R.id.stat_seekbar_placeholder);
        RangeSeekBar<Integer> rangeSeekBar = new RangeSeekBar<>(this);
        rangeSeekBar.setRangeValues(0, dataPoints.length);
        rangeSeekBar.setNotifyWhileDragging(true);
        layout.addView(rangeSeekBar);

        rangeSeekBar.setOnRangeSeekBarChangeListener(new RangeSeekBar.OnRangeSeekBarChangeListener<Integer>() {
            @Override
            public void onRangeSeekBarValuesChanged(RangeSeekBar<?> bar, Integer minValue, Integer maxValue) {
                int length = maxValue - minValue;
                DataPoint[] tmppoints = new DataPoint[length];
                for (int i = minValue; i < maxValue; i++) {
                    tmppoints[i - minValue] = dataPoints[i];
                }
                BarGraphSeries<DataPoint> newSeries = new BarGraphSeries<>(tmppoints);
                graph.removeAllSeries();
                graph.addSeries(newSeries);
            }
        });
        /*
        series.setSpacing(10);
        graph.getViewport().setMinX(0);
        graph.getViewport().setMaxX(27);
        graph.getViewport().setScalableY(false);
        graph.getGridLabelRenderer().setHorizontalAxisTitle("Date");
        graph.getGridLabelRenderer().setVerticalAxisTitle("Number of Sightings");
        */
    }



}
