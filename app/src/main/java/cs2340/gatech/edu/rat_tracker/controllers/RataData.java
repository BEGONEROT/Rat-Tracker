package cs2340.gatech.edu.rat_tracker.controllers;

import android.support.v7.app.AppCompatActivity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.content.Intent;

import java.io.IOException;
import java.util.HashMap;

import cs2340.gatech.edu.rat_tracker.R;
import cs2340.gatech.edu.rat_tracker.model.Model;
import  cs2340.gatech.edu.rat_tracker.model.RatData;

public class RataData extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rata_data);
        ListView ratdataview = (ListView) findViewById(R.id.RataData);
        try {
            Model.getInstance().readRatData();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        HashMap<Integer, RatData> sightings = (HashMap<Integer, RatData>) Model.getInstance().getAllRatData();
        ratdataview.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sightings));
    }

    @Override
    public void onListItemClick(ListView item, View v, int position, long id)  {
        Intent intent = new Intent(getBaseContext(), RatDetails.class);
        intent.putExtra("SIGHTING", ratSighting);
        startActivity(intent);
    }

    /*
     * This method refreshes the information in the ListView
     *
     * @param v the view
     */
    public void onRefreshPressed(View v) {
        ListView ratdataview = (ListView) findViewById(R.id.RataData);
        try {
            Model.getInstance().readRatData();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        HashMap<Integer, RatData> sightings = (HashMap<Integer, RatData>) Model.getInstance().getAllRatData();
        ratdataview.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sightings));
    }
    
}
