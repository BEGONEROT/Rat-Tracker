package cs2340.gatech.edu.rat_tracker.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

import com.google.firebase.auth.FirebaseAuth;

import cs2340.gatech.edu.rat_tracker.R;
import cs2340.gatech.edu.rat_tracker.model.Model;

/**
 * Default screen after login
 * User can view rat reports, view the map, logout, change settings, create a new rat sighting,
 * and view general stats
 *
 * Created by Aadarsh on 10/5/2017.
 */

public class WelcomeScreen extends AppCompatActivity{
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Model.getInstance().readRatData();
        setContentView(R.layout.activity_welcome_screen);


        webView = (WebView) findViewById(R.id.webView);
        webView.loadUrl("file:///android_asset/ratgif.html");

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

    WebView webView;

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
        Intent logOutPage = new Intent(WelcomeScreen.this, RataData.class);
        startActivity(logOutPage);
    }

    /**
     * Changes the activity to start screen when logout is pressed
     * @param v Current view
     */
    public void onViewStatsPressed(View v) {
        Intent logOutPage = new Intent(WelcomeScreen.this, StatsScreen.class);
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
        Intent logOutPage = new Intent(WelcomeScreen.this, SettingsScreen.class);
        startActivity(logOutPage);
    }

    /**
     * Changes the activity to start screen when logout is pressed
     * @param v Current view
     */
    public void onLogoutPressed(View v) {
        mAuth.getInstance().signOut();
        Intent logOutPage = new Intent(WelcomeScreen.this, StartScreen.class);
        startActivity(logOutPage);
    }

}

