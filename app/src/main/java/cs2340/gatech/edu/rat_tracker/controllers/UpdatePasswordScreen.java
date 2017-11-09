package cs2340.gatech.edu.rat_tracker.controllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;

import cs2340.gatech.edu.rat_tracker.R;

/**
 * Created by Aadarsh on 11/6/2017.
 */

@SuppressWarnings("ALL")
public class UpdatePasswordScreen extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        mAuth = FirebaseAuth.getInstance();
    }

    /**
     * Changes the activity
     * @param v Current view
     */
    public void onUpdatePasswordPressed(View v) {
        EditText oldPass = (EditText) findViewById(R.id.oldPassword);
        String oldPassword = oldPass.getText().toString();
        EditText newPass = (EditText) findViewById(R.id.newPass);
        String newPassword = newPass.getText().toString();
        EditText confirmNewPass = (EditText) findViewById(R.id.confirmNewPass);
        String confirmNewPassWord = confirmNewPass.getText().toString();
        mAuth = FirebaseAuth.getInstance();

        //if (!Objects.equals(oldPassword, "") && Objects.equals(oldPassword, newPassword)) {
            //if (newPassword.equals(confirmNewPassWord) && !Objects.equals(newPassword, "")) {
                mAuth.getCurrentUser().updatePassword(newPassword);
            //}
        //}

        Intent logOutPage = new Intent(UpdatePasswordScreen.this, SettingsScreen.class);
        startActivity(logOutPage);
    }

}
