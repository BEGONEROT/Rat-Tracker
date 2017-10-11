package cs2340.gatech.edu.rat_tracker.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

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
    private HashMap<Integer, RatSighting> rats;
    private List<Integer> keyList;

    /**
     * Constructs a Model Object, initializes users and current_user
     */
    //constructor
    private Model() {
        this.users = new ArrayList<User>();
        this.current_user = null;
        try {
            readRatData();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Parses the rat data from Rat_Sightings.csv when the application is started. Rat data is
     * stored in a HashMap using the unique key as a key
     */
    public void readRatData() throws IOException {
        // open file input stream
        BufferedReader reader = new BufferedReader(new FileReader("Rat_Sightings.csv"));

        // read file line by line
        String line;
        Scanner scanner;
        Integer key;
        String[] raw;
        RatSighting data;

        while ((line = reader.readLine()) != null) {
            scanner = new Scanner(line);
            while (scanner.hasNext()) {
                raw = scanner.nextLine().split(",");
                raw[raw.length - 2] = raw[raw.length - 2].replace("\"(","");
                key = Integer.parseInt(raw[0]);
                keyList.add(key);
                data = new RatSighting(raw);
                rats.put(key, data);
            }
        }

        //close reader
        reader.close();
    }

    /**
     * For use in RataData screen
     *
     * @return all rats stored in the app
     */
    public HashMap<Integer, RatSighting> getAllRatData() {
        return rats;
    }

    /**
     * For getting just a list of the keys. Easier to keep track of individual data points
     *
     * @return all keys in the rats HashMap
     */
    public List<Integer> getKeyList() { return keyList; }

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
