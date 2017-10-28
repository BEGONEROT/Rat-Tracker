package cs2340.gatech.edu.rat_tracker.model;

import java.io.Serializable;

/**
 * Class for storing data about a rat sighting
 *
 * Created by Dallas on 10/10/2017.
 */

public class RatSighting implements Serializable {

    private String key;
    private String date;
    private LocationType locationType;
    private String zip;
    private String address;
    private String city;
    private Borough borough;
    private double latitude;
    private double longitude;
    //private String[] data;
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

    public RatSighting(String key, String date, LocationType locationType, String zip, String address, String city, Borough borough, double latitude, double longitude) {
        this.key = key;
        this.date = date;
        this.locationType = locationType;
        this.zip = zip;
        this.address = address;
        this.city = city;
        this.borough = borough;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getKey() {
        return key;
    }

    public String getDate() {
        return date;
    }

    public LocationType getLocationType() {
        return locationType;
    }

    public String getIncidentZip() {
        return zip;
    }

    public String getIncidentAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public Borough getBorough() {
        return borough;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }


    public static final String[] resTypes =
            {"3+ Family Mixed Use Building", "Commercial Building", "1-2 Family Dwelling", "Public Stairs","Vacant Lot", "Construction Site", "Hospital","Catch Basin/Sewer"};

//    private static final String[] boroughs =[];


//    @Override
//    public int describeContents() {
//        return 0;
//    }

//    @Override
//    public void writeToParcel(Parcel out, int flags) {
//        out.writeArray(data);
//    }
//
//    public static final Parcelable.Creator<RatSighting> CREATOR = new Parcelable.Creator<RatSighting>() {
//        public RatSighting createFromParcel(Parcel in) {
//            return new RatSighting(in);
//        }
//
//        public RatSighting[] newArray(int size) {
//            return new RatSighting[size];
//        }
//    };
//
//    public RatSighting(Parcel in) {
//        data = in.createStringArray();


}
