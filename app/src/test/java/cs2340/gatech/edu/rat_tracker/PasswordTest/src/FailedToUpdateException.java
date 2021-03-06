package cs2340.gatech.edu.rat_tracker.PasswordTest.src;

/**
 *
 * Exception for failed update
 *
 * @author Aadarsh Padiyath
 * @version 1.0
 *
 */
public class FailedToUpdateException extends Exception {
    /**
     * Constructor for exception
     * @param str message
     */
    public FailedToUpdateException(String str) {
        super(str);
    }
}
