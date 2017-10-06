package cs2340.gatech.edu.rat_tracker.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.sql.DriverManager;

import cs2340.gatech.edu.rat_tracker.R;
import cs2340.gatech.edu.rat_tracker.model.DatabaseConnection;

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
        DatabaseConnection connection = DatabaseConnection.getInstance();
    }

    /**
     * When the button "Login" is pressed, user is transferred
     * to the login page.
     * @param v Current View
     */
    public void onLoginPressed(View v) {
        Intent loginPage = new Intent(WelcomeScreen.this, LoginScreen.class);
        startActivity(loginPage);
    }

    /**
     * Transfer user to Registration when register is pressed
     * @param v
     */
    public void onRegisterPressed(View v) {
        Intent registerPage = new Intent(WelcomeScreen.this, RegistrationScreen.class);
        startActivity(registerPage);
    }

}