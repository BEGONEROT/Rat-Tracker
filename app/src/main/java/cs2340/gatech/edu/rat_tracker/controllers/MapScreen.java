package cs2340.gatech.edu.rat_tracker.controllers;

import android.content.Intent;

import cs2340.gatech.edu.rat_tracker.R;
import cs2340.gatech.edu.rat_tracker.model.Model;
import cs2340.gatech.edu.rat_tracker.model.RatSighting;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.SeekBar;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.yahoo.mobile.client.android.util.rangeseekbar.RangeSeekBar;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

/**
 * An activity that displays a Google map with a marker (pin) to indicate a particular location.
 */
public class MapScreen extends AppCompatActivity
        implements OnMapReadyCallback,
        GoogleMap.OnInfoWindowClickListener {

    private int currMin = 0;
    private int currMax = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Retrieve the content view that renders the map.
        setContentView(R.layout.activity_map_screen);
        Model.getInstance();
        ArrayList<RatSighting> sightings = Model.getInstance().getAllRatData();
        sightings.sort((rat1, rat2) -> rat1.getDate().compareTo(rat2.getDate()));


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
        /*UiSettings uiSettings = googleMap.getUiSettings();
        uiSettings.setZoomControlsEnabled(true);
        */
        boolean success = googleMap.setMapStyle(
                MapStyleOptions.loadRawResourceStyle(
                        this, R.raw.style_json));
        //LatLng sydney = new LatLng(-33.852, 151.211);
        ArrayList<RatSighting> sightings = Model.getInstance().getAllRatData();
        HashMap<RatSighting,Marker> hashMapMarker = new HashMap<>();

        RatSighting sighting = sightings.get(4);
        LatLng point = new LatLng(sighting.getLatitude(), sighting.getLongitude());

        //googleMap.addMarker(new MarkerOptions().position(point)

               // .title(sighting));
                //.title("Marker in Sydney"));
        // System.out.println(sighting);
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(point, 10.0f));
        SeekBar simpleSeekBar=(SeekBar) findViewById(R.id.bar);
        LatLng finalPoint = point;
        simpleSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(    SeekBar seekBar,    int progress,    boolean fromUser){
                if (fromUser) {
                    googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(finalPoint, progress));
                }
            }
            public void onStartTrackingTouch(    SeekBar seekBar){
            }
            public void onStopTrackingTouch(    SeekBar seekBar){
//                googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(finalPoint, progress);
            }});
        //googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(point, 10.0f));
        System.out.println(sightings.toString());
        for (int i = 0; i < sightings.size(); i++) {
            try {
                sighting = sightings.get(i);
                point = new LatLng(sighting.getLatitude(), sighting.getLongitude());
                MarkerOptions markeroptions = new MarkerOptions().position(point)
                        .title(sighting.getStringDate())
                        .snippet(sighting.getKey());
                Marker marker = googleMap.addMarker(markeroptions);
                marker.setTag(sighting);
                hashMapMarker.put(sighting,marker);

            } catch (Exception e) {
                System.out.println("Oops");
            }
        }

        RangeSeekBar<Integer> seekBar = new RangeSeekBar<>(this);
        seekBar.setRangeValues(0, sightings.size());


        LinearLayout layout = (LinearLayout) findViewById(R.id.seekbar_placeholder);
        layout.addView(seekBar);

        currMax = sightings.size();


        seekBar.setOnRangeSeekBarChangeListener(new RangeSeekBar.OnRangeSeekBarChangeListener<Integer>() {
            @Override
            public void onRangeSeekBarValuesChanged(RangeSeekBar<?> bar, Integer minValue, Integer maxValue) {
                if (currMin > minValue) {
                    //deleteMap(0, sightings.size());
                    addMap(minValue, currMin);

                    System.out.println(currMin + "" + minValue);
                } else if (currMax < maxValue) {
                    //deleteMap(0, sightings.size());
                    addMap(currMax, maxValue);
                    System.out.println(currMax + "" + maxValue);
                } else if (currMin < minValue) {
                    deleteMap(currMin, minValue);
                    //addMap(currMin, minValue); //
                } else if (currMax > maxValue) {
                    deleteMap(maxValue, currMax);
                    //addMap(maxValue, currMax);
                }
                currMin = minValue;
                currMax = maxValue;
                //Now you have the minValue and maxValue of your RangeSeekbar
                //Toast.makeText(getApplicationContext(), minValue + "-" + maxValue, Toast.LENGTH_LONG).show();
                //Intent i = new Intent(getBaseContext(), MapScreen.class);

                //i.putExtra("max", maxValue);
                

            }


            public void addMap(int start, int stop) {
                for (int i = start; i < stop; i++) {
                    try {
                        RatSighting sighting = sightings.get(i);
                        LatLng point = new LatLng(sighting.getLatitude(), sighting.getLongitude());
                        Marker marker = googleMap.addMarker(new MarkerOptions().position(point)
                                .title(sighting.getStringDate()));
                        hashMapMarker.put(sighting,marker);


                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
            }

            public void deleteMap(int start, int stop) {
                for (int i = start; i < stop; i++) {
                    try {
                        RatSighting sighting = sightings.get(i);
                        Marker marker = hashMapMarker.get(sighting);
                        marker.remove();
                        hashMapMarker.remove(sighting);
                    } catch (Exception e) {
                        System.out.println("Oops");
                    }
                }
            }
        });

// Get noticed while dragging
        seekBar.setNotifyWhileDragging(true);

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