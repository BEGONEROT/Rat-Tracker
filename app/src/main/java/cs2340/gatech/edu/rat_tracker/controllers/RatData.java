package cs2340.gatech.edu.rat_tracker.controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.support.v7.widget.RecyclerView;
import android.content.Intent;


import java.util.ArrayList;

import cs2340.gatech.edu.rat_tracker.R;
import cs2340.gatech.edu.rat_tracker.model.Model;
import  cs2340.gatech.edu.rat_tracker.model.RatSighting;

/**
 * Screen for displaying all recent rat sightings
 */
@SuppressWarnings("ALL")
public class RatData extends AppCompatActivity {

        private RecyclerView ratDataView;
        private SightingListAdapter adapter;
        private RecyclerView.LayoutManager layout;
        private final String TAG = "RatDataList: ";

        /**
         * Shows list as a recycler view. Clicking on a specific sighting pulls up a detail view
         * @param savedInstanceState current instance
         */
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_rata_data);
            Model.getInstance();
            ratDataView = (RecyclerView) findViewById(R.id.my_recycler_view);

            ratDataView.setHasFixedSize(true);

            ArrayList<RatSighting> sightings = Model.getInstance().getAllRatData();
            sightings.sort((rat1, rat2) -> rat2.getDate().compareTo(rat1.getDate()));
            Log.w(TAG, sightings.toString());

            adapter = new SightingListAdapter(this, sightings);
            ratDataView.setAdapter(adapter);
            layout = new LinearLayoutManager(this);
            ratDataView.setLayoutManager(layout);
            ratDataView.addOnItemTouchListener(
                    new RecyclerItemClickListener(this, ratDataView,new RecyclerItemClickListener.OnItemClickListener() {
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

    }
