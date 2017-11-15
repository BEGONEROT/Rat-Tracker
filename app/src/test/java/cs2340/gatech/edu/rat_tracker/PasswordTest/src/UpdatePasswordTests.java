package cs2340.gatech.edu.rat_tracker.PasswordTest.src;

import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;


/**
 * Update Password Tests
 */
public class UpdatePasswordTests {
    private static final int TIMEOUT = 200;

    private String currentPassword;
    private String newPassword;
    private String confirmNewPassword;
    private String incorrectPassword;

    @Before
    public void setUp() {
        UpdatePassword.setCurrentPassword("OldPass");
        currentPassword = UpdatePassword.getCurrentPassword();
        newPassword = "NewPass";
        confirmNewPassword = "NewPass";
        incorrectPassword = "IncorrectPass";
    }

    @Test(timeout = TIMEOUT)
    public void testUpdatePasswordExceptions() {
        int count = 0;
        try {
            UpdatePassword.updatePassword("", newPassword, confirmNewPassword);
        } catch (IllegalArgumentException e) {
            count++;
        } catch (FailedToUpdateException e) {
            //Do nothing
        }
        try {
            UpdatePassword.updatePassword(currentPassword, "", confirmNewPassword);
        } catch (IllegalArgumentException e) {
            count++;
        } catch (FailedToUpdateException e) {
            //Do nothing
        }
        try {
            UpdatePassword.updatePassword(currentPassword, newPassword, "");
        } catch (IllegalArgumentException e) {
            count++;
        } catch (FailedToUpdateException e) {
            //Do nothing
        }
        try {
            UpdatePassword.updatePassword(incorrectPassword, newPassword, confirmNewPassword);
        } catch (FailedToUpdateException e) {
            count++;
        }
        try {
            UpdatePassword.updatePassword(currentPassword, newPassword, incorrectPassword);
        } catch (FailedToUpdateException e) {
            count++;
        }
        try {
            UpdatePassword.updatePassword(currentPassword, currentPassword, currentPassword);
        } catch (FailedToUpdateException e) {
            count++;
        }
        assertEquals(6, count);
    }

    @Test(timeout = TIMEOUT)
    public void testSuccessfulUpdate() {
        try {
            UpdatePassword.updatePassword(currentPassword, newPassword, confirmNewPassword);
            assertEquals(newPassword, UpdatePassword.getCurrentPassword());
        } catch (FailedToUpdateException e) {
            fail();
        }
    }

}
