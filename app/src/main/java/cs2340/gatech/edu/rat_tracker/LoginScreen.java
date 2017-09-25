package cs2340.gatech.edu.rat_tracker;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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
                TextView usernameview = (TextView) findViewById(R.id.username);
                String username = usernameview.getText().toString();
                TextView passwordview = (TextView) findViewById(R.id.password);
                String password = passwordview.getText().toString();
                if (!username.equals("user") || !password.equals("pass")) {
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

                }
            }
        });
    }



}