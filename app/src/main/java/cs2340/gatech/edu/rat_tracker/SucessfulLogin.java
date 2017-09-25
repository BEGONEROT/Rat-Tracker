package cs2340.gatech.edu.rat_tracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SucessfulLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sucessful_login);
    }

    public void onLogoutPressed(View v) {
        Intent loginOutPage = new Intent(SucessfulLogin.this, WelcomeScreen.class);
        startActivity(loginOutPage);
    }
}
