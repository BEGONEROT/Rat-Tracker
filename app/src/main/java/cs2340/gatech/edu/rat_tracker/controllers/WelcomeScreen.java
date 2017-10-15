package cs2340.gatech.edu.rat_tracker.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.sql.DriverManager;

import cs2340.gatech.edu.rat_tracker.R;
import cs2340.gatech.edu.rat_tracker.model.DatabaseConnection;

/**
 * Created by Aadarsh on 10/5/2017.
 */

public class WelcomeScreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);
        /*try {
            DriverManager.getConnection("jdbc:mariadb://localhost:3306/test");
        } catch (Exception e) {
            Log.d("PLEASE: ", "not working");
        }*/
        //DatabaseConnection connection = DatabaseConnection.getInstance();
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

