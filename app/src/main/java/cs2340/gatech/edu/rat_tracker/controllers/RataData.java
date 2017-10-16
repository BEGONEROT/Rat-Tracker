package cs2340.gatech.edu.rat_tracker.controllers;

import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.support.v7.widget.RecyclerView;
import android.content.Intent;

import java.util.ArrayList;
import java.util.HashMap;

import cs2340.gatech.edu.rat_tracker.R;
import cs2340.gatech.edu.rat_tracker.model.Model;
import  cs2340.gatech.edu.rat_tracker.model.RatSighting;

public class RataData extends AppCompatActivity {

    private RecyclerView ratdataview;
    private SightingListAdapter adapter;
    private RecyclerView.LayoutManager layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rata_data);
        ratdataview = (RecyclerView) findViewById(R.id.my_recycler_view);
        ratdataview.setHasFixedSize(true);
        layout = new LinearLayoutManager(this);
        ratdataview.setLayoutManager(layout);
       HashMap<Integer, RatSighting> sightings = (HashMap<Integer, RatSighting>) Model.getInstance().getAllRatData();

        adapter = new SightingListAdapter(sightings.values());
        ratdataview.setAdapter(adapter);
        ratdataview.addOnItemTouchListener(
                new RecyclerItemClickListener(this, ratdataview ,new RecyclerItemClickListener.OnItemClickListener() {
                    private ArrayList<RatSighting> data;
                    @Override public void onItemClick(View view, int position) {
                        data = adapter.getData();
                        Intent intent = new Intent(getBaseContext(), RatDetails.class);
                        intent.putExtra("SIGHTING", data.get(position));
                        startActivity(intent);
                    }

                    @Override public void onLongItemClick(View view, int position) {
                        this.onItemClick(view, position);
                    }
                })
        );
    }

    /*
     * This method refreshes the information in the ListView
     *
     * @param v the view
     */
    public void onRefreshPressed(View v) {
        HashMap<Integer, RatSighting> sightings = (HashMap<Integer, RatSighting>) Model.getInstance().getAllRatData();
        adapter = new SightingListAdapter(sightings.values());
        ratdataview.setAdapter(adapter);
    }
    
}
