package cs2340.gatech.edu.rat_tracker.controllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

import cs2340.gatech.edu.rat_tracker.R;

/**
 * Created by Aadarsh on 11/6/2017.
 */

public class updateEmailScreen extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_email);
        mAuth = FirebaseAuth.getInstance();

        String oldEmail = mAuth.getCurrentUser().getEmail();

        TextView email = (TextView) findViewById(R.id.oldEmail);
        email.setText(oldEmail);
    }

    /**
     * Changes the activity
     * @param v Current view
     */
    public void onUpdateEmailPressed(View v) {
        mAuth = FirebaseAuth.getInstance();
        EditText usernameField = (EditText) findViewById(R.id.newEmail);
        String username = usernameField.getText().toString();
        mAuth.getCurrentUser().updateEmail(username);


        Intent logOutPage = new Intent(updateEmailScreen.this, SettingsScreen.class);
        startActivity(logOutPage);
    }

}
