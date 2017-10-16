package cs2340.gatech.edu.rat_tracker.controllers;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import cs2340.gatech.edu.rat_tracker.R;

/**
 * Created by davonprewitt on 10/15/17.
 */

public class ReportSighting extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_sighting_screen);
        final Button submit = (Button) findViewById(R.id.submit);
    }


}
