package cs2340.gatech.edu.rat_tracker.model;

import java.util.Date;

/**
 * Created by dayynn on 10/6/17.
 */

public class Sighting {
    private int key;
    private Date dateSeen;
    private String locationType; //maybe make this an enum idk
    private String zip;
    private String address;
    private String city;
    private String borough;
    private double latitude;
    private double longitude;


    public Sighting(int key, Date dateSeen, String locationType, String zip, String address, String city, String borough, double latitude, double longitude) {
        this.key = key;
        this.dateSeen = dateSeen;
        this.latitude = latitude;
        this.locationType = locationType;
        this.zip = zip;
        this.address = address;
        this.city = city;
        this.borough = borough;
        this.longitude = longitude;
    }

    //getters

    public Date getDateSeen() {
        return dateSeen;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getAddress() {
        return address;
    }

    public String getBorough() {
        return borough;
    }

    public String getCity() {
        return city;
    }

    public String getLocationType() {
        return locationType;
    }

    public String getZip() {
        return zip;
    }

    @Override
    public String toString() {
        return address + " " + dateSeen.toString();
    }
}
