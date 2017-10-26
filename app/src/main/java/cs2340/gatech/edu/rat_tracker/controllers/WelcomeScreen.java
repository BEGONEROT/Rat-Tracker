package cs2340.gatech.edu.rat_tracker.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.Map;

import cs2340.gatech.edu.rat_tracker.R;
import cs2340.gatech.edu.rat_tracker.model.Model;
import cs2340.gatech.edu.rat_tracker.model.RatSighting;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.common.api.GoogleApiClient;

import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

/**
 * Default screen after login
 * User can view rat reports, view the map, logout, change settings, create a new rat sighting,
 * and view general stats
 *
 * Created by Aadarsh on 10/5/2017.
 */

public class WelcomeScreen extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);
        Model.getInstance().readRatData();
        /*try {
            DriverManager.getConnection("jdbc:mariadb://localhost:3306/test");
        } catch (Exception e) {
            Log.d("PLEASE: ", "not working");
        }*/
        //DatabaseConnection connection = DatabaseConnection.getInstance();
        /*FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Hello, World!");*/
    }

    /**
     * Changes the activity to start screen when logout is pressed
     * @param v Current view
     */
    public void onNewRatPressed(View v) {
        Intent logOutPage = new Intent(WelcomeScreen.this, ReportSightingScreen.class);
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
    public void onViewMapPressed(View v) {
        Intent logOutPage = new Intent(WelcomeScreen.this, MapScreen.class);
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

