package cs2340.gatech.edu.rat_tracker.model;

import java.io.Serializable;

/**
 * Created by dwarr on 10/17/2017.
 */

public enum Borough implements Serializable {

    MANHATTAN("MANHATTAN"),
    QUEENS("QUEENS"),
    BRONX("BRONX"),
    STATENISLAND("STATEN ISLAND"),
    BROOKLYN("BROOKLYN");

    private String place;

    Borough(String place) {
        this.place = place;
    }

    public String toString() {
        return place;
    }

}
