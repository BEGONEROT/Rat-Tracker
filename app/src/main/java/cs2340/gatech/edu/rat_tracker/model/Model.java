package cs2340.gatech.edu.rat_tracker.model;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by dayynn on 9/28/17.
 */

@SuppressWarnings("ALL")
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
    //private HashMap<Integer, RatSighting> rats = new HashMap<>(100);
    private ArrayList<RatSighting> rats = new ArrayList<>();
    //private List<Integer> keyList;
    private FirebaseDatabase database;
    private final String TAG = "Model: ";

    /**
     * Constructs a Model Object, initializes users and current_user
     */
    //constructor
    private Model() {
        //this.users = new ArrayList<User>();
        //rats.put(1, new RatSighting(1,"Today","House","Zip","Address","City","Borough",12.234,1234.25));
        //readRatData();
        //this.current_user = null;
        //rats.put(2, new RatSighting(new String[] {"2","Today","","","","","","House","Zip","Address","","","","","","","City","Borough","12.234","1234.25",""}));
        //rats.put(3, new RatSighting(new String[] {"3","Today","","","","","","House","Zip","Address","","","","","","","City","Borough","12.234","1234.25",""}));

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
     * stored in an ArrayList using the unique key as a key
     */
    public void readRatData() {
        rats.clear();
        database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("RatSightings");

        //myRef.orderByChild("Created Date").limitToLast(10).addListenerForSingleValueEvent(new ValueEventListener() {
        myRef.limitToLast(100).addListenerForSingleValueEvent(new ValueEventListener() {

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

                    rats.add(new RatSighting(snapshot.getKey().toString(),
                            snapshot.child("Created Date").getValue().toString(),
                            parseLocationType(snapshot.child("Location Type").getValue().toString()),
                            snapshot.child("Incident Zip").getValue().toString(),
                            snapshot.child("Incident Address").getValue().toString(),
                            snapshot.child("City").getValue().toString(),
                            parseBorough(snapshot.child("Borough").getValue().toString()),
                            Double.parseDouble(snapshot.child("Latitude").getValue().toString()),
                            Double.parseDouble(snapshot.child("Longitude").getValue().toString())));
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w(TAG, "Error loading rat data");
            }
        });

        myRef = database.getReference("RatSightingsTemp");

        //myRef.orderByChild("Created Date").limitToLast(10).addListenerForSingleValueEvent(new ValueEventListener() {
        myRef.limitToFirst(100).addListenerForSingleValueEvent(new ValueEventListener() {

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

                    rats.add(new RatSighting(snapshot.getKey().toString(),
                            snapshot.child("Created Date").getValue().toString(),
                            parseLocationType(snapshot.child("Location Type").getValue().toString()),
                            snapshot.child("Incident Zip").getValue().toString(),
                            snapshot.child("Incident Address").getValue().toString(),
                            snapshot.child("City").getValue().toString(),
                            parseBorough(snapshot.child("Borough").getValue().toString()),
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
     * For use in RatData screen
     *
     * @return all rats stored in the app
     */
    public ArrayList<RatSighting> getAllRatData() {
        return rats;
    }
/*
    /**
     * For getting just a list of the keys. Easier to keep track of individual data points
     *
     * @return all keys in the rats HashMap
     *
    public List<Integer> getKeyList() { return keyList; }
*/

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
     */
    public void addNewSighting(String addressType, String borough, String city, String created_date, String address, String zip, double latitude, double longitude, String location_type) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("RatSightingsTemp").push();
        //use this to set data of each value where 'hello' is the key and 'world' is the value
        //myRef.child("hello").setValue("world");
        myRef.child("Address Type").setValue(addressType);
        myRef.child("Borough").setValue(borough);
        myRef.child("City").setValue(city);
        myRef.child("Created Date").setValue(created_date);
        myRef.child("Incident Address").setValue(address);
        myRef.child("Incident Zip").setValue(zip);
        myRef.child("Latitude").setValue(latitude);
        myRef.child("Longitude").setValue(longitude);
        myRef.child("Location Type").setValue(location_type);
        rats.add(0, new RatSighting("123", created_date, LocationType.fromString(location_type), zip, address, city, Borough.valueOf(borough), latitude, longitude));
        readRatData();
    }

    private LocationType parseLocationType(String parseme) {
        LocationType retval = null;
        for (LocationType location: LocationType.values()) {
            if (location.toString().equals(parseme)) {
                retval = location;
            }
        }
        return retval;
    }

    private Borough parseBorough(String parseme) {
        Borough retval = null;
        for (Borough borough: Borough.values()) {
            if (borough.toString().equals(parseme)) {
                retval = borough;
            }
        }
        return  retval;
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
