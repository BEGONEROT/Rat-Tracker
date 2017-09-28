package cs2340.gatech.edu.rat_tracker.model;

/**
 * Created by dayynn on 9/28/17.
 */

public class User {
    public boolean isAdmin;
    private String username;
    private String password;

    public User(String username, String password, boolean isAdmin) {
        this.isAdmin = isAdmin;
        this.username = username;
        this.password = password;
    }

    public User() {
        this("user", "pass", false);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return this.username + this.password;
    }
}
