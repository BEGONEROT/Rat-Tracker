package cs2340.gatech.edu.rat_tracker.model;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.List;

/**
 * Created by dayynn on 9/28/17.
 */

public class Model {
    private static final Model ourInstance = new Model();

    public static Model getInstance() {
        return ourInstance;
    }

    /*
    Unique Key          0
	Date                1
	Location Type       7
	Incident Zip        8
	Incident Address    9
	City                16
	Borough             17
	Latitude            len - 3
	Longitude           len - 2
     */

    //objects stored
    //private List<User> users;
    //private User current_user;
    private HashMap<Integer, RatSighting> rats = new HashMap<>(100);
    private List<Integer> keyList;
    private FirebaseDatabase database;
    private final String TAG = "Model: ";

    /**
     * Constructs a Model Object, initializes users and current_user
     */
    //constructor
    private Model() {
        //this.users = new ArrayList<User>();
        readRatData();
        //this.current_user = null;
        //rats.put(1, new RatSighting(new String[] {"1","Today","","","","","","House","Zip","Address","","","","","","","City","Borosugh","12.234","1234.25",""}));
        //rats.put(2, new RatSighting(new String[] {"2","Today","","","","","","House","Zip","Address","","","","","","","City","Borosugh","12.234","1234.25",""}));
        //rats.put(3, new RatSighting(new String[] {"3","Today","","","","","","House","Zip","Address","","","","","","","City","Borosugh","12.234","1234.25",""}));

        /*
        try {
            readRatData();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        */
    }

    /**
     * Parses the rat data from Rat_Sightings.csv when the application is started. Rat data is
     * stored in a HashMap using the unique key as a key
     */
    private void readRatData() {
        database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("RatSightings");

        myRef.orderByChild("Created Date").limitToFirst(50).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.w(TAG, "Snapshot: " + dataSnapshot.toString());
                for (DataSnapshot snapshot: dataSnapshot.getChildren()) {
                    Log.w(TAG, "key: " + snapshot.getKey());
                    Log.w(TAG, "date: " + snapshot.child("Created Date").getValue().toString());
                    Log.w(TAG, "type: " + snapshot.child("Location Type").getValue().toString());
                    Log.w(TAG, "zip: " + snapshot.child("Incident Zip").getValue().toString());
                    Log.w(TAG, "address: " + snapshot.child("Incident Address").getValue().toString());
                    Log.w(TAG, "city: " + snapshot.child("City").getValue().toString());
                    Log.w(TAG, "lat: " + snapshot.child("Latitude").getValue().toString());
                    Log.w(TAG, "long: " + snapshot.child("Longitude").getValue().toString());

                    rats.put(Integer.parseInt(snapshot.getKey()), new RatSighting(Integer.parseInt(snapshot.getKey()),
                            snapshot.child("Created Date").getValue().toString(),
                            snapshot.child("Location Type").getValue().toString(),
                            snapshot.child("Incident Zip").getValue().toString(),
                            snapshot.child("Incident Address").getValue().toString(),
                            snapshot.child("City").getValue().toString(),
                            snapshot.child("Borough").getValue().toString(),
                            Double.parseDouble(snapshot.child("Latitude").getValue().toString()),
                            Double.parseDouble(snapshot.child("Longitude").getValue().toString())));
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w(TAG, "Error loading rat data");
            }
        });

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


//    /**
//     * Generates a new unique key for a new rat sighting.
//     * MAY NEED CODE TO GET IT FROM THE DATABASE INSTEAD OF USING THE LOCAL CACHE OF DATA
//     * @return new key integer
//     */
//    public int getNextKey() {
//        return keyList.(keyList.size() - 1) + 1;
//    }

    /**
     * Updates local info and database info with a new RatSighting
     * TODO: Add code for updating the database
     * @param newRat the new RatSighting created that needs to be saved
     * @return boolean whether adding the new RatSighting was successful or not
     */
    public boolean addNewSighting(RatSighting newRat) {
        rats.put(newRat.getKey(), newRat);
        keyList.add(newRat.getKey());
        /*
        ADD DATABASE CODE HERE
         */
        return true;
    }

    /**
     * TODO: update the database with any new users or new rats
     * This may require some new instance variables that temporarily store any new data
     * @return whether updating was successful or not
     */
    private boolean updateDatabase() {
        return false;
    }

    /* /**
     * Sees if the user is an existing user
     *
     * @param amialive user being checked
     * @return true if user exist, false otherwise
     *
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
     *
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
     *
    public void addUser(User addme) {
        users.add(addme);
    }

    /**
     * Set the current_user to user passed through
     *
     * @param user user current_user will be set to
     *
    public void setCurrentUser(User user) {
        current_user = user;
    }

    /**
     * Getter for current_user
     *
     * @return current_user
     *
    public User getCurrentUser() {
        return current_user;
    }
    */
}
