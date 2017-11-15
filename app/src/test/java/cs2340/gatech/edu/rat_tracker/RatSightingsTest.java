package cs2340.gatech.edu.rat_tracker;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



import cs2340.gatech.edu.rat_tracker.model.*;

public class RatSightingsTest {

    private RatSighting rat;
    private String key;
    private String date;
    private LocationType locationType;
    private String zip;
    private String address;
    private String city;
    private Borough borough;
    private double latitude;
    private double longitude;

    @Before
    public void setUp() {
        this.key = "abc123";
        this.date = "8/9/2017 0:00";
        this.locationType = LocationType.FAMDWELLING;
        this.zip = "11222";
        this.address = "15 DIAMOND STREET";
        this.city = "New York City";
        this.borough = Borough.QUEENS;
        this.latitude = 42.0420420420;
        this.longitude = 69.6969696969;
        this.rat = new RatSighting(key, date, locationType, zip, address, city, borough, latitude, longitude);
    }

    @Test (timeout = 200)
    public void testCorrectParamsConstructor() {
        setUp();
        Assert.assertEquals(rat.getKey(), key);
        Assert.assertEquals(rat.getStringDate(), date);
        Assert.assertEquals(rat.getLocationType(), locationType);
        Assert.assertEquals(rat.getIncidentZip(), zip);
        Assert.assertEquals(rat.getIncidentAddress(), address);
        Assert.assertEquals(rat.getCity(), city);
        Assert.assertEquals(rat.getBorough(), borough);
        Assert.assertEquals(rat.getLatitude(), new Double(latitude));
        Assert.assertEquals(rat.getLongitude(), new Double(longitude));
    }

    @Test (timeout = 200)
    public void testImpossibleLongitudeLatitude() {
        double wrongLat = 91.0;
        double wrongLong = -181.0;
        RatSighting wrongRat = new RatSighting(key, date, locationType, zip, address, city, borough, wrongLat, wrongLong);
        Assert.assertFalse("Must check for valid longitude", wrongRat.getLongitude() == -181);
        Assert.assertFalse("Must check for valid latitude", wrongRat.getLatitude() == 91);
    }

    @Test (timeout = 200)
    public void testInvalidDate() {
        String wrongDate = "13/32/-2000 30:91";
        RatSighting wrongRat = new RatSighting(key, wrongDate, locationType, zip, address, city, borough, latitude, longitude);
        Assert.assertNotEquals("Must check for valid date", wrongRat.getStringDate(), wrongDate);

        wrongDate = "";
        wrongRat = new RatSighting(key, wrongDate, locationType, zip, address, city, borough, latitude, longitude);
        Assert.assertNotEquals("Must check for valid date", wrongRat.getStringDate(), wrongDate);

        wrongDate = "abc/efg/hijk lm:no";
        wrongRat = new RatSighting(key, wrongDate, locationType, zip, address, city, borough, latitude, longitude);
        Assert.assertNotEquals("Must check for valid date", wrongRat.getStringDate(), wrongDate);

        wrongDate = "10-27-1997 21;20";
        wrongRat = new RatSighting(key, wrongDate, locationType, zip, address, city, borough, latitude, longitude);
        Assert.assertNotEquals("Must check for valid date", wrongRat.getStringDate(), wrongDate);
    }

    @Test (timeout = 200)
    public void testInvalidZip() {
        String wrongZip = "1010111";
        RatSighting wrongRat = new RatSighting(key, date, locationType, wrongZip, address, city, borough, latitude, longitude);
        Assert.assertEquals("Invalid Zip, must have 6 numbers" ,wrongRat.getIncidentAddress().length(), 6);
    }


}