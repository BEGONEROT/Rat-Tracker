package cs2340.gatech.edu.rat_tracker.controllers;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import cs2340.gatech.edu.rat_tracker.R;
import cs2340.gatech.edu.rat_tracker.model.RatSighting;

/**
 * Created by Dallas on 10/10/2017.
 */

public class RatDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rat_details);
        final RatSighting currentRat = (RatSighting) this.getIntent().getSerializableExtra("SIGHTING");
        System.out.println(currentRat.getDate());
        loadData(currentRat);
    }

    /**
     * Updates the text fields in the display with the data from a RatSighting
     *
     * @param rat RatSighting to get data from
     */
    private void loadData(RatSighting rat) {
        TextView key = (TextView) findViewById(R.id.data_key_title);
        key.setText("#" + rat.getKey().toString());
        TextView date = (TextView) findViewById(R.id.date);
        date.setText(rat.getDate());
        TextView lType = (TextView) findViewById(R.id.location_type);
        lType.setText(rat.getLocationType());
        TextView address = (TextView) findViewById(R.id.address);
        address.setText(rat.getIncidentAddress());
        TextView city = (TextView) findViewById(R.id.city);
        city.setText(rat.getCity());
        TextView zip = (TextView) findViewById(R.id.zip_code);
        zip.setText(rat.getIncidentZip());
        TextView borough = (TextView) findViewById(R.id.borough);
        borough.setText(rat.getBorough());
        TextView coordinates = (TextView) findViewById(R.id.coordinates);
        coordinates.setText("X:" + rat.getLatitude() + ", Y:" + rat.getLongitude());
    }

}
