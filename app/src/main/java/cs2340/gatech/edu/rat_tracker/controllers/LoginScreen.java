package cs2340.gatech.edu.rat_tracker.controllers;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView usernameview = (TextView) findViewById(R.id.registerusername);
                String username = usernameview.getText().toString();
                TextView passwordview = (TextView) findViewById(R.id.registerpassword);
                String password = passwordview.getText().toString();
                Model model = Model.getInstance();
                if (!model.userExists(new User(username, password, false))) {
                    new AlertDialog.Builder(LoginScreen.this).setTitle("Login Error")
                            .setMessage("Unable to login, please try again.")
                            .setCancelable(false)
                            .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    //maybe keep track of fails here idk
                                }
                            }).show();

                } else {
                    Model.getInstance().setCurrentUser(Model.getInstance().getUser(new User(username, password, false)));
                    Intent loginPage = new Intent(LoginScreen.this, SucessfulLogin.class);
                    startActivity(loginPage);

                }
            }
        });
    }
}