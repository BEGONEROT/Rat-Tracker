package cs2340.gatech.edu.rat_tracker.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import cs2340.gatech.edu.rat_tracker.R;

public class StartScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);
    }

    /**
     * When the button "Login" is pressed, user is transferred
     * to the login page.
     * @param v Current View
     */
    public void onLoginPressed(View v) {
        Intent loginPage = new Intent(StartScreen.this, LoginScreen.class);
        startActivity(loginPage);
    }

    /**
     * Transfer user to Registration when register is pressed
     * @param v Current view
     */
    public void onRegisterPressed(View v) {
        Intent registerPage = new Intent(StartScreen.this, RegistrationScreen.class);
        startActivity(registerPage);
    }

}