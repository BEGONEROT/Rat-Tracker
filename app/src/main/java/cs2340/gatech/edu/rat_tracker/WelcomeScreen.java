package cs2340.gatech.edu.rat_tracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class WelcomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);
    }

    /**
     * When the button "Login" is pressed, user is transferred
     * to the login page.
     * @param v View v
     */
    public void onLoginPressed(View v) {
        Intent loginPage = new Intent(WelcomeScreen.this, LoginScreen.class);
        startActivity(loginPage);
    }

    public void onRegisterPressed(View v) {
        Intent registerPage = new Intent(WelcomeScreen.this, RegisterScreen.class);
        startActivity(registerPage);
    }

}