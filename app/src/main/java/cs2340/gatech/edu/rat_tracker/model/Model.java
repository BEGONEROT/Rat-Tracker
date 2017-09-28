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

    //constructor
    private Model() {
        this.users = new ArrayList<User>();
        this.current_user = null;
    }

    public boolean userExists(User amialive) {
        for (User user: users) {
            if (user.toString().equals(amialive.toString())) {
                return true;
            }
        }
        return false;
    }

    public User getUser(User amialive) {
        for (User user: users) {
            if (user.toString().equals(amialive.toString())) {
                return user;
            }
        }
        return null;
    }

    public void addUser(User addme) {
        users.add(addme);
    }

    public void setCurrentUser(User user) {
        current_user = user;
    }

    public User getCurrentUser() {
        return current_user;
    }
}
