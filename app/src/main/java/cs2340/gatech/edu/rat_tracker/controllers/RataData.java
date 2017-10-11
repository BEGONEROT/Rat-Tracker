package cs2340.gatech.edu.rat_tracker.controllers;

import android.support.v7.app.AppCompatActivity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.content.Intent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import cs2340.gatech.edu.rat_tracker.R;
import cs2340.gatech.edu.rat_tracker.model.Model;
import  cs2340.gatech.edu.rat_tracker.model.RatSighting;

public class RataData extends ListActivity {

    private ArrayList<RatSighting> sightings;

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
        sightings = new ArrayList<>(Model.getInstance().getAllRatData().values());
        ratdataview.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sightings));
    }

    @Override
    public void onListItemClick(ListView item, View v, int position, long id)  {
        Intent intent = new Intent(getBaseContext(), RatDetails.class);
        // You need to replace this last part VVVVVVVVVVVVVVVVVVVVVVVVVV with the specific rat clicked on
        //intent.putExtra("SIGHTING", Model.getInstance().getAllRatData());
        // You can also use Model.getInstance().getKeyList() to just get the keys to search the map quicker (i think)
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
        sightings = new ArrayList<>(Model.getInstance().getAllRatData().values());
        ratdataview.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sightings));
    }
    
}
