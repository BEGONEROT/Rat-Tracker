package cs2340.gatech.edu.rat_tracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
    }

    public void onLoginPressed(View v) {
        Intent loginPage = new Intent(WelcomeScreen.this, LoginScreen.class);
        startActivity(loginPage);
    }

}