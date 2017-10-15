package cs2340.gatech.edu.rat_tracker.controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import cs2340.gatech.edu.rat_tracker.R;
import cs2340.gatech.edu.rat_tracker.model.Model;
import cs2340.gatech.edu.rat_tracker.model.Sighting;

public class RataData extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rata_data);
        ListView ratdataview = (ListView) findViewById(R.id.RataData);
        ArrayList<Sighting> sightings = (ArrayList<Sighting>) Model.getInstance().getSightings();
        ratdataview.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sightings));
    }
}
