package cs2340.gatech.edu.rat_tracker;

import org.junit.Test;

import cs2340.gatech.edu.rat_tracker.model.LocationType;
import cs2340.gatech.edu.rat_tracker.model.Model;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 *
 *
 * FAMDWELLING     ("1-2 Family Dwelling"),
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
 */
public class ExampleUnitTest {
    @Test(timeout = 200)
    public void testParseLocationTypeValid() throws Exception {
        Model model = Model.getInstance();
        LocationType output = model.parseLocationType("1-2 Family Dwelling");
        assertEquals(output, LocationType.FAMDWELLING);
        output = model.parseLocationType("3+ Family Apt. Building");
        assertEquals(output, LocationType.FAMAPTBLDG);
        output = model.parseLocationType("3+ Family Mixed Use Building");
        assertEquals(output, LocationType.FAMMXDUSEBLDG);
        output = model.parseLocationType("Catch Basin/Sewer");
        assertEquals(output, LocationType.SEWER);
        output = model.parseLocationType("Commercial Building");
        assertEquals(output, LocationType.COMMBLDG);
        output = model.parseLocationType("Construction Site");
        assertEquals(output, LocationType.CONSTRUCTSITE);
        output = model.parseLocationType("Day Care/Nursery");
        assertEquals(output, LocationType.DAYCARE);
        output = model.parseLocationType("Government Building");
        assertEquals(output, LocationType.GOVBLDG);
        output = model.parseLocationType("Hospital");
        assertEquals(output, LocationType.HOSPITAL);
        output = model.parseLocationType("Office Building");
        assertEquals(output, LocationType.OFFICEBLDG);
        output = model.parseLocationType("Parking Lot/Garage");
        assertEquals(output, LocationType.PARKINGLOT);
        output = model.parseLocationType("Public Garden");
        assertEquals(output, LocationType.GARDEN);
        output = model.parseLocationType("Public Stairs");
        assertEquals(output, LocationType.STAIRS);
        output = model.parseLocationType("School/Pre-School");
        assertEquals(output, LocationType.SCHOOL);
        output = model.parseLocationType("Single Room Occupancy (SRO)");
        assertEquals(output, LocationType.SRO);
        output = model.parseLocationType("Summer Camp");
        assertEquals(output, LocationType.SUMMERCAMP);
        output = model.parseLocationType("Vacant Building");
        assertEquals(output, LocationType.VACANTBLDG);
        output = model.parseLocationType("Vacant Lot");
        assertEquals(output, LocationType.VACANTLOT);
        output = model.parseLocationType("Other");
        assertEquals(output, LocationType.OTHER);
    }

    @Test(timeout = 200)
    public void testLocationTypeInvalid() throws Exception {
        Model model = Model.getInstance();
        LocationType output = model.parseLocationType("yeehaw");
        assertNull(output);
    }

    @Test(timeout = 200)
    public void testLocationTypeNull() throws Exception {
        Model model = Model.getInstance();
        LocationType output = model.parseLocationType(null);
        assertNull(output);
    }
}