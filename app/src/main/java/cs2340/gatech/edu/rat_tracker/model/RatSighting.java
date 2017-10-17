package cs2340.gatech.edu.rat_tracker.model;

import android.os.Parcelable;
import android.os.Parcel;

import java.io.Serializable;

/**
 * Created by Dallas on 10/10/2017.
 */

public class RatSighting implements Serializable {

    private String[] data;
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

    public RatSighting(String[] data) {
        this.data = data;
    }

    public Integer getKey() {
        return Integer.parseInt(data[0]);
    }

    public String getDate() {
        return data[1];
    }

    public String getLocationType() {
        return data[7];
    }

    public String getIncidentZip() {
        return data[8];
    }

    public String getIncidentAddress() {
        return data[9];
    }

    public String getCity() {
        return data[16];
    }

    public String getBorough() {
        return data[17];
    }

    public Double getLatitude() {
        return Double.parseDouble(data[data.length - 3]);
    }

    public Double getLongitude() {
        return Double.parseDouble(data[data.length - 2]);
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
