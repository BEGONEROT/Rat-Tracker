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

    //constructor
    private Model() {
        this.users = new ArrayList<User>();
        //NOTE: remove this to stop population of default user
        users.add(new User());
    }

    public boolean userExists(User amialive) {
        for (User user: users) {
            if (user.toString().equals(amialive.toString())) {
                return true;
            }
        }
        return false;
    }

    public void addUser(User addme) {
        users.add(addme);
    }
}
