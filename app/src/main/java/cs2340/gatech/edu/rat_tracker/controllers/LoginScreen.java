package cs2340.gatech.edu.rat_tracker.controllers;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        final Button login = (Button) findViewById(R.id.login);
        // set up login button action
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView usernameview = (TextView) findViewById(R.id.registerusername);
                String username = usernameview.getText().toString();
                TextView passwordview = (TextView) findViewById(R.id.registerpassword);
                String password = passwordview.getText().toString();
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
            }
        });
    }
}