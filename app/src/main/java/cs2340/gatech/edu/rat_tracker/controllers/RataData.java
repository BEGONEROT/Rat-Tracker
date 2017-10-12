package cs2340.gatech.edu.rat_tracker.controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.support.v7.widget.RecyclerView;
import android.content.Intent;

import java.io.IOException;
import java.util.HashMap;
import java.util.ArrayList;

import cs2340.gatech.edu.rat_tracker.R;
import cs2340.gatech.edu.rat_tracker.model.Model;
import  cs2340.gatech.edu.rat_tracker.model.RatData;

public class RataData extends AppCompatActivity {

    private RecyclerView ratdataview;
    private CustomAdapter adapter;
    private RecyclerView.LayoutManager layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rata_data);
        ratdataview = (RecyclerView) findViewById(R.id.my_recycler_view);
        ratdataview.setHasFixedSize(true);
        layout = new LinearLayoutManager(this);
        ratdataview.setLayoutManager(layout);

        try {
            Model.getInstance().readRatData();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        HashMap<Integer, RatData> sightings = (HashMap<Integer, RatData>) Model.getInstance().getAllRatData();
        adapter = new CustomAdapter(sightings.values());
        ratdataview.setAdapter(adapter);
    }


    /*
     * This method refreshes the information in the ListView
     *
     * @param v the view
     */
    public void onRefreshPressed(View v) {
        try {
            Model.getInstance().readRatData();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        HashMap<Integer, RatData> sightings = (HashMap<Integer, RatData>) Model.getInstance().getAllRatData();
        adapter = new CustomAdapter(sightings.values());
        ratdataview.setAdapter(adapter);
    }
    
}
