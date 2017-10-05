package cs2340.gatech.edu.rat_tracker.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dayynn on 9/28/17.
 */

public class Model {
    private static final Model ourInstance = new Model();

    public static Model getInstance() {
        return ourInstance;
    }

    //objects stored
    private List<User> users;
    private User current_user;

    /**
     * Constructs a Model Object, initializes users and current_user
     */
    //constructor
    private Model() {
        this.users = new ArrayList<User>();
        this.current_user = null;
    }

    /**
     * Sees if the user is an existing user
     *
     * @param amialive user being checked
     * @return true if user exist, false otherwise
     */
    public boolean userExists(User amialive) {
        for (User user: users) {
            if (user.toString().equals(amialive.toString())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Finds a user if they are there
     *
     * @param amialive user trying to be got
     * @return user if they are found, null otherwise
     */
    public User getUser(User amialive) {
        for (User user: users) {
            if (user.toString().equals(amialive.toString())) {
                return user;
            }
        }
        return null;
    }

    /**
     * Adds a user
     *
     * @param addme user to be added
     */
    public void addUser(User addme) {
        users.add(addme);
    }

    /**
     * Set the current_user to user passed through
     *
     * @param user user current_user will be set to
     */
    public void setCurrentUser(User user) {
        current_user = user;
    }

    /**
     * Getter for current_user
     *
     * @return current_user
     */
    public User getCurrentUser() {
        return current_user;
    }
}
