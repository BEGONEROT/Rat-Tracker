package cs2340.gatech.edu.rat_tracker.controllers;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import cs2340.gatech.edu.rat_tracker.R;

/**
 * Created by davonprewitt on 10/15/17.
 */

public class ReportSightingScreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_sighting_screen);
        final Button submit = (Button) findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//                TextView addressField = (TextView) findViewById(R.id.address);
//                String address = addressField.getText().toString();

            }

        });
    }


}
