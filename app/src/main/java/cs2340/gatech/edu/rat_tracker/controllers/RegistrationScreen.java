package cs2340.gatech.edu.rat_tracker.controllers;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import cs2340.gatech.edu.rat_tracker.R;
import cs2340.gatech.edu.rat_tracker.model.Model;
import cs2340.gatech.edu.rat_tracker.model.User;

public class RegistrationScreen extends AppCompatActivity {

    private CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_screen);
        final Button register = (Button) findViewById(R.id.register);
        checkBox = (CheckBox) findViewById(R.id.checkBox);
        //set up register button handler
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView usernameField = (TextView) findViewById(R.id.registerusername);
                String username = usernameField.getText().toString();
                TextView passwordField = (TextView) findViewById(R.id.registerpassword);
                String password = passwordField.getText().toString();
                Boolean isAdmin = checkBox.isChecked();
                Model.getInstance().addUser(new User(username, password, isAdmin));
                //Firebase write
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("users/" + username);
                myRef.child("isAdmin").setValue(isAdmin);
                myRef.child("password").setValue(password);
                new AlertDialog.Builder(RegistrationScreen.this).setTitle("Successful Registration")
                        .setMessage("Congratulations on your registration! Hit OK to go to login.")
                        .setCancelable(false)
                        .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //maybe keep track of fails here idk
                                Intent loginPage = new Intent(RegistrationScreen.this, LoginScreen.class);
                                startActivity(loginPage);
                            }
                        }).show();
            }
        });
    }
}
