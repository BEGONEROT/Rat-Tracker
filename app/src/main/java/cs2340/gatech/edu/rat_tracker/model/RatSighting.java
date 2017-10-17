package cs2340.gatech.edu.rat_tracker.model;

import java.io.Serializable;

/**
 * Class for storing data about a rat sighting
 *
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

}
