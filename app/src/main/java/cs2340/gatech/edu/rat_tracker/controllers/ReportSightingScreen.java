package cs2340.gatech.edu.rat_tracker.controllers;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.text.DateFormat;
import java.util.Date;
import java.text.SimpleDateFormat;

import cs2340.gatech.edu.rat_tracker.R;
import cs2340.gatech.edu.rat_tracker.model.RatSighting;

/**
 * Created by davonprewitt on 10/15/17.
 */

public class ReportSightingScreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_sighting_screen);
        final Button submit = (Button) findViewById(R.id.submit);

        EditText city = (EditText) findViewById(R.id.cityText);
        String newCity = city.getText().toString();
        Spinner borough = (Spinner) findViewById(R.id.boroughSpinner);
        String newBorough = borough.getDr
        Spinner locationType = (Spinner) findViewById(R.id.residenceSpinner);
        EditText address = (EditText) findViewById(R.id.addressField);
        String newAddress = address.getText().toString();
        EditText longitude = (EditText) findViewById(R.id.longitude);
        String newLongitude = longitude.getText().toString();
        EditText latitude = (EditText) findViewById(R.id.latitide);
        String newLatitide = latitude.getText().toString();
        EditText zip = (EditText) findViewById(R.id.zip);
        String newZip = zip.getText().toString();


        RatSighting newRat = new RatSighting();

        submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                DateFormat format = new SimpleDateFormat("M/d/yyyy HH:mm");
                Date date = new Date();
                String dateTime = format.format(date);

            }

        });
    }


}
