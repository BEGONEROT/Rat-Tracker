package cs2340.gatech.edu.rat_tracker.controllers;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import cs2340.gatech.edu.rat_tracker.R;
import cs2340.gatech.edu.rat_tracker.model.RatSighting;

/**
 * Created by Dallas on 10/10/2017.
 */

public class RatDetails extends Activity {

    private RatSighting currentRat;
    /*
	Unique Key          0
	Date                1
	Location Type       7
	Incident Zip        8
	Incident Address    9
	City                16
	Borough             17
	Latitude            len - 3
	Longitude           len - 2
	*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rat_details);
        //currentRat = getIntent().getComponent();
    }

    private void loadData(RatSighting rat) {
        TextView key = (TextView) (R.id.data_key_title);
        key.setText("#" + rat.getKey());
        TextView date = (TextView) (R.id.date);
        date.setText(rat.getDate());
        TextView lType = (TextView) (R.id.location_type);
        lType.setText(rat.getLocationType());
        TextView address = (TextView) (R.id.address);
        address.setText(rat.getIncidentAddress());
        TextView city = (TextView) (R.id.city);
        city.setText(rat.getCity());
        TextView zip = (TextView) (R.id.zip_code);
        zip.setText(rat.getIncidentZip());
        TextView borough = (TextView) (R.id.borough);
        borough.setText(rat.getBorough());
        TextView coordinates = (TextView) (R.id.cordinates);
        coordinates.setText("X:" + rat.getLatitude() + ", Y:" + rat.getLongitude());
    }

}
