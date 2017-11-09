package cs2340.gatech.edu.rat_tracker.controllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import cs2340.gatech.edu.rat_tracker.R;

/**
 * Placeholder for the map
 * Created by Aadarsh on 10/5/2017.
 */
@SuppressWarnings("ALL")
public class ViewRatsScreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_rats_screen);
    }

    /**
     * Changes the activity to start screen when logout is pressed
     * @param v Current view
     */
    public void onViewListPressed(View v) {
        Intent logOutPage = new Intent(ViewRatsScreen.this, RataData.class);
        startActivity(logOutPage);
    }


}
