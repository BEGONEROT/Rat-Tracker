package cs2340.gatech.edu.rat_tracker.model;

/**
 * Created by dayynn on 9/28/17.
 */

public class User {
    public boolean isAdmin;
    private String username;
    private String password;

    /**
     * This is a constructor to create a user object
     *
     * @param username the user tag the user will be identified by
     * @param password the password that allows you to use the user
     *                 account
     * @param isAdmin boolean for whether or not user is an admin
     */
    public User(String username, String password, boolean isAdmin) {
        this.isAdmin = isAdmin;
        this.username = username;
        this.password = password;
    }

    /**
     * No args constructor for User()
     */
    public User() {
        this("user", "pass", false);
    }

    /**
     * Getter for the username
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Getter for password
     *
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter for password
     *
     * @param password new password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Setter for username
     *
     * @param username new username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return this.username + this.password;
    }
}
