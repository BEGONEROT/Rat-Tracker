package cs2340.gatech.edu.rat_tracker.controllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

import cs2340.gatech.edu.rat_tracker.R;

/**
 * Created by Aadarsh on 11/6/2017.
 */

public class SettingsScreen extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_screen);
        mAuth = FirebaseAuth.getInstance();

        String currentEmail = mAuth.getCurrentUser().getEmail();

        TextView email = (TextView) findViewById(R.id.email);
        email.setText(currentEmail);
    }

    /**
     * Changes the activity
     * @param v Current view
     */
    public void onChangeEmailPressed(View v) {
        Intent logOutPage = new Intent(SettingsScreen.this, updateEmailScreen.class);
        startActivity(logOutPage);
        System.out.println("DEBUG");
        String currentEmail = mAuth.getCurrentUser().getEmail();
        TextView email = (TextView) findViewById(R.id.email);
        email.setText(currentEmail);
    }

    /**
     * Changes the activity
     * @param v Current view
     */
    public void onChangePasswordPressed(View v) {
        Intent logOutPage = new Intent(SettingsScreen.this, UpdatePasswordScreen.class);
        startActivity(logOutPage);
    }

    /**
     * Changes the activity
     * @param v Current view
     */
    public void onDeleteAccountPressed(View v) {
        mAuth.getCurrentUser().delete();
        Intent logOutPage = new Intent(SettingsScreen.this, StartScreen.class);
        startActivity(logOutPage);
    }
}
