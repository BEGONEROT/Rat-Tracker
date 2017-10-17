package cs2340.gatech.edu.rat_tracker.controllers;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import cs2340.gatech.edu.rat_tracker.R;
import cs2340.gatech.edu.rat_tracker.model.Model;
import cs2340.gatech.edu.rat_tracker.model.User;

public class RegistrationScreen extends AppCompatActivity {

    private CheckBox checkBox;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private static final String TAG = "RegistrationScreen: ";
    private Boolean isAdmin;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_screen);
        final Button register = (Button) findViewById(R.id.register);
        checkBox = (CheckBox) findViewById(R.id.checkBox);

        //initialize firebase
        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                }
                // ...
            }
        };


        //set up register button handler
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView usernameField = (TextView) findViewById(R.id.registerusername);
                String username = usernameField.getText().toString();
                TextView passwordField = (TextView) findViewById(R.id.registerpassword);
                String password = passwordField.getText().toString();
                isAdmin = checkBox.isChecked();

                createAccount(username, password);


                /*Model.getInstance().addUser(new User(username, password, isAdmin));
                //Firebase write
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("users/" + username);
                myRef.child("isAdmin").setValue(isAdmin);
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
                        }).show();*/
            }
        });
    }

    public void createAccount(String email, String password) {
        //fail condition
        if (email.isEmpty() || password.isEmpty() || email == null || password == null) {
            failedRegister();
            return;
        }
        //attempt to register user
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "createUserWithEmail:onComplete:" + task.isSuccessful());

                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            failedRegister();
                        } else {
                            FirebaseDatabase database = FirebaseDatabase.getInstance();
                            DatabaseReference myRef = database.getReference("users/" + FirebaseAuth.getInstance().getCurrentUser().getUid());
                            myRef.child("isAdmin").setValue(isAdmin);
                            successRegister();
                        }
                    }
                });
    }

    public void failedRegister() {
        new AlertDialog.Builder(RegistrationScreen.this).setTitle("Failed Registration")
                .setMessage("Must be valid email and password. Hit OK to try again.")
                .setCancelable(false)
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).show();
    }

    public void successRegister() {

        new AlertDialog.Builder(RegistrationScreen.this).setTitle("Successful Registration")
                .setMessage("Hit OK to proceed to login.")
                .setCancelable(false)
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent loginPage = new Intent(RegistrationScreen.this,  LoginScreen.class);
                        startActivity(loginPage);
                    }
                }).show();
    }

}
