package cs2340.gatech.edu.rat_tracker.controllers;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import cs2340.gatech.edu.rat_tracker.R;
import cs2340.gatech.edu.rat_tracker.model.Borough;
import cs2340.gatech.edu.rat_tracker.model.RatSighting;

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
        ArrayAdapter<String> lAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item);
        locationType.setAdapter(lAdapter);

        EditText address = (EditText) findViewById(R.id.addressField);
        EditText longitude = (EditText) findViewById(R.id.longitude);
        EditText latitude = (EditText) findViewById(R.id.latitude);
        EditText zip = (EditText) findViewById(R.id.zipcode);



        //RatSighting newRat = new RatSighting();

        submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                DateFormat format = new SimpleDateFormat("M/d/yyyy HH:mm");
                Date date = new Date();
                String dateTime = format.format(date);

                String newCity = city.getText().toString();
                String newBorough = borough.getSelectedItem().toString();
                String newAddress = address.getText().toString();
                double newLongitude = Double.parseDouble(longitude.getText().toString());
                double newLatitide = Double.parseDouble(latitude.getText().toString());
                String newZip = zip.getText().toString();

                updateDatabase("ADDRESS", newBorough, newCity, dateTime, newAddress, newZip,
                        newLatitide, newLongitude, );


                //TESTING
                //updateDatabase("home", "bronx", "ny", "today", "6 blah way", "45701", 41.402, -23.401, "farm");


            }

        });
    }

    private void updateDatabase(String addressType, String borough, String city, String created_date, String address, String zip, double latitude, double longitude, String location_type) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("RatSightingsTemp").push();
        //use this to set data of each value where 'hello' is the key and 'world' is the value
        //myRef.child("hello").setValue("world");
        myRef.child("Address Type").setValue(addressType);
        myRef.child("Borough").setValue(borough);
        myRef.child("City").setValue(city);
        myRef.child("Created Date").setValue(created_date);
        myRef.child("Incident Address").setValue(address);
        myRef.child("Incident Zip").setValue(zip);
        myRef.child("Latitude").setValue(latitude);
        myRef.child("Longitude").setValue(longitude);
        myRef.child("Location Type").setValue(location_type);


        //log the key
        Log.w(TAG, "key: " + myRef.getKey());
    }


}
