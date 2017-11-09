package cs2340.gatech.edu.rat_tracker.controllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

import android.widget.EditText;
import android.widget.Spinner;

import java.text.DateFormat;
import java.util.Date;
import java.text.SimpleDateFormat;


import cs2340.gatech.edu.rat_tracker.R;

import cs2340.gatech.edu.rat_tracker.model.Borough;
import cs2340.gatech.edu.rat_tracker.model.LocationType;
import cs2340.gatech.edu.rat_tracker.model.Model;



/**
 * Created by davonprewitt on 10/15/17.
 */



public class ReportSightingScreen extends AppCompatActivity {

    private final String TAG = "ReportSightingScreen: ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_sighting_screen);
        final Button submit = (Button) findViewById(R.id.submit);


        EditText city = (EditText) findViewById(R.id.cityText);

        Spinner borough = (Spinner) findViewById(R.id.boroughSpinner);
        ArrayAdapter<String> bAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, Borough.values());
        borough.setAdapter(bAdapter);

        Spinner locationType = (Spinner) findViewById(R.id.residenceSpinner);
        ArrayAdapter<String> lAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, LocationType.values());
        locationType.setAdapter(lAdapter);

        EditText address = (EditText) findViewById(R.id.addressField);
        EditText longitude = (EditText) findViewById(R.id.longitude);
        EditText latitude = (EditText) findViewById(R.id.latitude);
        EditText zip = (EditText) findViewById(R.id.zipCode);



        //RatSighting newRat = new RatSighting();

        submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                DateFormat format = new SimpleDateFormat("M/d/yyyy HH:mm");
                Date date = new Date();
                String dateTime = format.format(date);
                String newCity = city.getText().toString();
                String newBorough = borough.getSelectedItem().toString();
                String newLocation = locationType.getSelectedItem().toString();
                String newAddress = address.getText().toString();
                double newLongitude = Double.parseDouble(longitude.getText().toString());
                double newLatitude = Double.parseDouble(latitude.getText().toString());
                String newZip = zip.getText().toString();

                Model.getInstance().addNewSighting("ADDRESS", newBorough, newCity, dateTime, newAddress, newZip,
                        newLatitude, newLongitude, newLocation);
                Intent intent = new Intent(ReportSightingScreen.this, WelcomeScreen.class);
                startActivity(intent);


                //TESTING
                //updateDatabase("home", "bronx", "ny", "today", "6 blah way", "45701", 41.402, -23.401, "farm");



            }

        });






    }


}
