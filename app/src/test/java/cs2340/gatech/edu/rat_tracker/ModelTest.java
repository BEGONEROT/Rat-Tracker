package cs2340.gatech.edu.rat_tracker;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

import cs2340.gatech.edu.rat_tracker.model.Borough;
import cs2340.gatech.edu.rat_tracker.model.Model;

/**
 * Tests the parseBorough method of Model
 *
 * Created by Dallas on 11/14/2017.
 */

public class ModelTest {

    private Model instance;

    @Before
    public void setUp() {
        instance = Model.getInstance();
    }

    @Test
    public void testCorrectStrings() {
        Assert.assertEquals(Borough.BRONX, instance.returnParseBorough("BRONX"));
        Assert.assertEquals(Borough.BROOKLYN, instance.returnParseBorough("BROOKLYN"));
        Assert.assertEquals(Borough.MANHATTAN, instance.returnParseBorough("MANHATTAN"));
        Assert.assertEquals(Borough.QUEENS, instance.returnParseBorough("QUEENS"));
        Assert.assertEquals(Borough.STATENISLAND, instance.returnParseBorough("STATENISLAND"));
    }

    @Test
    public void testIncorrectStrings() {
        Assert.assertEquals(null, instance.returnParseBorough("Not correct string"));
        Assert.assertEquals(Borough.BRONX, instance.returnParseBorough("bronx"));
        Assert.assertEquals(Borough.BROOKLYN, instance.returnParseBorough("brooklyn"));
        Assert.assertEquals(Borough.MANHATTAN, instance.returnParseBorough("manhattan"));
        Assert.assertEquals(Borough.QUEENS, instance.returnParseBorough("queens"));
        Assert.assertEquals(Borough.STATENISLAND, instance.returnParseBorough("statenisland"));
    }

    @Test
    public void testGenericBoroughs() {
        Borough[] boroughs = Borough.values();
        for (Borough b : boroughs) {
            Assert.assertEquals("Not all boroughs parsed correctly", b, instance.returnParseBorough(b.toString()));
        }
    }

    @Test
    public void testLowercaseGenericBoroughs() {
        Borough[] boroughs = Borough.values();
        for (Borough b : boroughs) {
            Assert.assertEquals("Allowed lowercase values", null, instance.returnParseBorough(b.toString().toLowerCase()));
        }
    }

    @Test
    public void testNullString() {
        Assert.assertEquals(null, instance.returnParseBorough(null));
    }
}
