package cs2340.gatech.edu.rat_tracker.model;

/**
 * Enum for location type
 * Default values for the report spinner
 *
 * Created by Dallas on 10/17/2017.
 */

public enum LocationType {
    /*
    1-2 Family Dwelling
    3+ Family Apt. Building
    3+ Family Mixed Use Building
    Catch Basin/Sewer
    Commercial Building
    Construction Site
    Day Care/Nursery
    Government Building
    Hospital
    Office Building
    Parking Lot/Garage
    Public Garden
    Public Stairs
    School/Pre-School
    Single Room Occupancy (SRO)
    Summer Camp
    Vacant Building
    Vacant Lot
    Other
    */

    FAMDWELLING     ("1-2 Family Dwelling"),
    FAMAPTBLDG      ("3+ Family Apt. Building"),
    FAMMXDUSEBLDG   ("3+ Family Mixed Use Building"),
    SEWER           ("Catch Basin/Sewer"),
    COMMBLDG        ("Commercial Building"),
    CONSTRUCTSITE   ("Construction Site"),
    DAYCARE         ("Day Care/Nursery"),
    GOVBLDG         ("Government Building"),
    HOSPITAL        ("Hospital"),
    OFFICEBLDG      ("Office Building"),
    PARKINGLOT      ("Parking Lot/Garage"),
    GARDEN          ("Public Garden"),
    STAIRS          ("Public Stairs"),
    SCHOOL          ("School/Pre-School"),
    SRO             ("Single Room Occupancy (SRO)"),
    SUMMERCAMP      ("Summer Camp"),
    VACANTBLDG      ("Vacant Building"),
    VACANTLOT       ("Vacant Lot"),
    OTHER           ("Other");

    private final String description;
    LocationType (String description) {
        this.description = description;
    }

    public String description() {
        return description;
    }
}
