package cs2340.gatech.edu.rat_tracker.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import cs2340.gatech.edu.rat_tracker.R;
import cs2340.gatech.edu.rat_tracker.model.Model;

public class SucessfulLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sucessful_login);
        TextView adminField = (TextView) findViewById(R.id.adminCheck);
        Model model = Model.getInstance();
        if (model.getCurrentUser().isAdmin) {
            adminField.setText("You are an admin");
        } else {
            adminField.setText("You are not an admin");
        }
    }

    /**
     * Changes the activity to Welcome screen when logout is pressed
     * @param v Current view
     */
    public void onLogoutPressed(View v) {
        Intent loginOutPage = new Intent(SucessfulLogin.this, StartScreen.class);
        startActivity(loginOutPage);
    }
}
