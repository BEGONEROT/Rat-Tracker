package cs2340.gatech.edu.rat_tracker.controllers;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import cs2340.gatech.edu.rat_tracker.R;
import cs2340.gatech.edu.rat_tracker.model.RatSighting;

/**
 * Screen for viewing details about a specific sighting
 * Data shown: Unique key, date, location type, address, city, zip, borough, and latitude/longitude
 *
 * Created by Dallas on 10/10/2017.
 */

public class RatDetails extends AppCompatActivity {

    /**
     * Creates page with RatSighting passed in with the intent
     * @param savedInstanceState current instance
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rat_details);
        final RatSighting currentRat = (RatSighting) this.getIntent().getSerializableExtra("SIGHTING");
        System.out.println(currentRat.getStringDate());
        loadData(currentRat);
    }

    /**
     * Updates the text fields in the display with the data from a RatSighting
     *
     * @param rat RatSighting to get data from
     */
    private void loadData(RatSighting rat) {
        TextView key = (TextView) findViewById(R.id.data_key_title);
        key.setText("#" + rat.getKey());
        TextView date = (TextView) findViewById(R.id.date);
        date.setText(rat.getStringDate());
        TextView lType = (TextView) findViewById(R.id.location_type);
        lType.setText(rat.getLocationType().toString());
        TextView address = (TextView) findViewById(R.id.address);
        address.setText(rat.getIncidentAddress());
        TextView city = (TextView) findViewById(R.id.city);
        city.setText(rat.getCity());
        TextView zip = (TextView) findViewById(R.id.zip_code);
        zip.setText(rat.getIncidentZip());
        TextView borough = (TextView) findViewById(R.id.borough);
        borough.setText(rat.getBorough().toString());
        TextView coordinates = (TextView) findViewById(R.id.coordinates);
        coordinates.setText("X:" + rat.getLatitude() + ", Y:" + rat.getLongitude());
    }

}
