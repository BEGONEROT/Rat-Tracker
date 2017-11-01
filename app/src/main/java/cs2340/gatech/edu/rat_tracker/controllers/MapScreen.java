package cs2340.gatech.edu.rat_tracker.controllers;

/**
 * Created by davonprewitt on 10/22/17.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import cs2340.gatech.edu.rat_tracker.R;
import cs2340.gatech.edu.rat_tracker.model.Model;
import cs2340.gatech.edu.rat_tracker.model.RatSighting;


/**
 * Created by davonprewitt on 10/22/17.
 */


import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.MapStyleOptions;

import java.util.ArrayList;

/**
 * An activity that displays a Google map with a marker (pin) to indicate a particular location.
 */
public class MapScreen extends AppCompatActivity
        implements OnMapReadyCallback,
        GoogleMap.OnInfoWindowClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Retrieve the content view that renders the map.
        setContentView(R.layout.activity_map_screen);
        Model.getInstance();
        ArrayList<RatSighting> sightings = Model.getInstance().getAllRatData();
        // Get the SupportMapFragment and request notification
        // when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map when it's available.
     * The API invokes this callback when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user receives a prompt to install
     * Play services inside the SupportMapFragment. The API invokes this method after the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        // Add a marker in Sydney, Australia,
        // and move the map's camera to the same location.
        Model.getInstance();
        googleMap.setOnInfoWindowClickListener(this);
        UiSettings uiSettings = googleMap.getUiSettings();
        uiSettings.setZoomControlsEnabled(true);

        boolean success = googleMap.setMapStyle(
                MapStyleOptions.loadRawResourceStyle(
                        this, R.raw.style_json));
        //LatLng sydney = new LatLng(-33.852, 151.211);
        ArrayList<RatSighting> sightings = Model.getInstance().getAllRatData();

        RatSighting sighting = sightings.get(4);
        LatLng point = new LatLng(sighting.getLatitude(), sighting.getLongitude());

        //googleMap.addMarker(new MarkerOptions().position(point)
               // .title(sighting));
        // System.out.println(sighting);

        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(point, 10.0f));
        System.out.println(sightings.toString());
        for (int i = 0; i < sightings.size(); i++) {
            try {
                sighting = sightings.get(i);
                point = new LatLng(sighting.getLatitude(), sighting.getLongitude());
                MarkerOptions markeroptions = new MarkerOptions().position(point)
                        .title(sighting.getDate())
                        .snippet(sighting.getKey());
                Marker marker = googleMap.addMarker(markeroptions);
                marker.setTag(sighting);

            } catch (Exception e) {
                System.out.println("Oops");
            }
        }

    }

    /**
     * Uses the data in the marker's tag to intent over to the detail view for that sighting
     * @param marker Marker that was clicked
     */
    @Override
    public void onInfoWindowClick(Marker marker) {
        RatSighting sighting = (RatSighting) marker.getTag();
        Intent detailPage = new Intent(MapScreen.this, RatDetails.class);
        detailPage.putExtra("SIGHTING", sighting);
        startActivity(detailPage);
    }
}