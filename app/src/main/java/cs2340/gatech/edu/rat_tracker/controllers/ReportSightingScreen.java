package cs2340.gatech.edu.rat_tracker.controllers;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import cs2340.gatech.edu.rat_tracker.R;

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

        submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//                TextView addressField = (TextView) findViewById(R.id.address);
//                String address = addressField.getText().toString();

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
