package cs2340.gatech.edu.rat_tracker.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import cs2340.gatech.edu.rat_tracker.R;

/**
 * Created by Aadarsh on 10/5/2017.
 */

public class WelcomeScreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);
    }

    /**
     * Changes the activity to start screen when logout is pressed
     * @param v Current view
     */
    public void onNewRatPressed(View v) {
        Intent logOutPage = new Intent(WelcomeScreen.this, StartScreen.class);
        startActivity(logOutPage);
    }

    /**
     * Changes the activity to start screen when logout is pressed
     * @param v Current view
     */
    public void onViewRatPressed(View v) {
        Intent logOutPage = new Intent(WelcomeScreen.this, ViewRatsScreen.class);
        startActivity(logOutPage);
    }

    /**
     * Changes the activity to start screen when logout is pressed
     * @param v Current view
     */
    public void onViewStatsPressed(View v) {
        Intent logOutPage = new Intent(WelcomeScreen.this, StartScreen.class);
        startActivity(logOutPage);
    }

    /**
     * Changes the activity to start screen when logout is pressed
     * @param v Current view
     */
    public void onSettingsPressed(View v) {
        Intent logOutPage = new Intent(WelcomeScreen.this, StartScreen.class);
        startActivity(logOutPage);
    }

    /**
     * Changes the activity to start screen when logout is pressed
     * @param v Current view
     */
    public void onLogoutPressed(View v) {
        Intent logOutPage = new Intent(WelcomeScreen.this, StartScreen.class);
        startActivity(logOutPage);
    }
}

