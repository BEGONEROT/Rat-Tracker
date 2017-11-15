package cs2340.gatech.edu.rat_tracker;

import org.junit.Assert;
import org.junit.Test;

import cs2340.gatech.edu.rat_tracker.model.Borough;
import cs2340.gatech.edu.rat_tracker.model.Model;

/**
 * Tests the parseBorough method of Model
 *
 * Created by Dallas on 11/14/2017.
 */

public class BoroughTest {

    @Test(timeout = 200)
    public void testCorrectStrings() throws Exception {
        Model instance = Model.getInstance();
        Assert.assertEquals(Borough.BRONX, instance.parseBorough("BRONX"));
        Assert.assertEquals(Borough.BROOKLYN, instance.parseBorough("BROOKLYN"));
        Assert.assertEquals(Borough.MANHATTAN, instance.parseBorough("MANHATTAN"));
        Assert.assertEquals(Borough.QUEENS, instance.parseBorough("QUEENS"));
        Assert.assertEquals(Borough.STATENISLAND, instance.parseBorough("STATEN ISLAND"));
    }

    @Test(timeout = 200)
    public void testIncorrectStrings() throws Exception {
        Model instance = Model.getInstance();
        Assert.assertNull(instance.parseBorough("Not correct string"));
        Assert.assertNull(instance.parseBorough("bronx"));
        Assert.assertNull(instance.parseBorough("brooklyn"));
        Assert.assertNull(instance.parseBorough("manhattan"));
        Assert.assertNull(instance.parseBorough("queens"));
        Assert.assertNull(instance.parseBorough("statenisland"));
    }

    @Test(timeout = 200)
    public void testGenericBoroughs() throws Exception {
        Model instance = Model.getInstance();
        Borough[] boroughs = Borough.values();
        for (Borough b : boroughs) {
            Assert.assertEquals("Not all boroughs parsed correctly", b, instance.parseBorough(b.toString()));
        }
    }

    @Test(timeout = 200)
    public void testLowercaseGenericBoroughs() throws Exception {
        Model instance = Model.getInstance();
        Borough[] boroughs = Borough.values();
        for (Borough b : boroughs) {
            Assert.assertNull("Allowed lowercase values", instance.parseBorough(b.toString().toLowerCase()));
        }
    }

    @Test(timeout = 200)
    public void testNullString() throws Exception {
        Model instance = Model.getInstance();
        Assert.assertNull(instance.parseBorough(null));
    }
}
