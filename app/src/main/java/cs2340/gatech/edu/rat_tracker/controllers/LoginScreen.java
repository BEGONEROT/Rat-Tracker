package cs2340.gatech.edu.rat_tracker.controllers;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import cs2340.gatech.edu.rat_tracker.R;
import cs2340.gatech.edu.rat_tracker.model.Model;
import cs2340.gatech.edu.rat_tracker.model.User;


public class LoginScreen extends AppCompatActivity {

    private static final String TAG = "LoginScreen";
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        final Button login = (Button) findViewById(R.id.login);

        //firebase init
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

        // set up login button action
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView usernameview = (TextView) findViewById(R.id.registerusername);
                String username = usernameview.getText().toString();
                TextView passwordview = (TextView) findViewById(R.id.registerpassword);
                String password = passwordview.getText().toString();

                signIn(username, password);

                /*
                //check if user exists and handle success or failure
                Model model = Model.getInstance();

                if (!model.userExists(new User(username, password, false))) {
                    new AlertDialog.Builder(LoginScreen.this).setTitle(R.string.login_failed_title)
                            .setMessage(R.string.login_failed_message)
                            .setCancelable(false)
                            .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    //maybe keep track of fails here idk
                                }
                            }).show();
                } else {
                    Model.getInstance().setCurrentUser(Model.getInstance().getUser(new User(username, password, false)));
                    Intent loginPage = new Intent(LoginScreen.this, WelcomeScreen.class);
                    startActivity(loginPage);

                }
                */
            }
        });
    }

    public void signIn(String email, String password) {
        //fail condition
        if (email.isEmpty() || password.isEmpty() || email == null || password == null) {
            failedLogin();
            return;
        }
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "signInWithEmail:onComplete:" + task.isSuccessful());

                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Log.w(TAG, "signInWithEmail:failed", task.getException());
                            failedLogin();
                        } else {
                            //go to main screen of app
                            Log.w(TAG, FirebaseAuth.getInstance().getCurrentUser().getEmail());
                            Intent loginPage = new Intent(LoginScreen.this, WelcomeScreen.class);
                            startActivity(loginPage);
                        }

                        // ...
                    }
                });
    }

    public void failedLogin() {
        new AlertDialog.Builder(LoginScreen.this).setTitle("Failed Login")
                .setMessage("Must be valid email and password. Hit OK to try again.")
                .setCancelable(false)
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).show();
    }
}