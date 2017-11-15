package cs2340.gatech.edu.rat_tracker.PasswordTest.src;

import java.util.Objects;


/**
 * Class for updating password.
 */
public class UpdatePassword {

    private static String currentPassword;

    /**
     * method for updating password
     * @param oldPass old pass to check against
     * @param newPass new password
     * @param confirmNewPass new password to confirm
     * @throws FailedToUpdateException exception thrown if failed update
     */
    public static void updatePassword(String oldPass, String newPass,
                                      String confirmNewPass) throws FailedToUpdateException {
        if (Objects.equals(oldPass, "")
                || Objects.equals(newPass, "")
                || Objects.equals(confirmNewPass, "")) {
            throw new IllegalArgumentException("params cannot be empty");
        } else {
            currentPassword = getCurrentPassword();
            if (Objects.equals(oldPass, currentPassword)) {
                if (!Objects.equals(oldPass, newPass)) {
                    if (Objects.equals(newPass, confirmNewPass)) {
                        setCurrentPassword(newPass);
                        return;
                    }
                    throw new FailedToUpdateException("New password cannot be old password");
                }
                throw new FailedToUpdateException("New passwords must match.");
            }
            throw new FailedToUpdateException("Old password does not match");
        }
    }

    /**
     * getter for current password
     * @return current password
     */
    public static String getCurrentPassword() {
        return currentPassword;
    }

    /**
     * setter for current password
     * @param newPass new password to set to
     */
    public static void setCurrentPassword(String newPass) {
        currentPassword = newPass;
    }
}
