package cs2340.gatech.edu.rat_tracker.controllers;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.text.DateFormat;
import java.util.Date;
import java.text.SimpleDateFormat;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import cs2340.gatech.edu.rat_tracker.R;
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
