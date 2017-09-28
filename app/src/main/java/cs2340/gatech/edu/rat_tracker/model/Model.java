package cs2340.gatech.edu.rat_tracker.model;

/**
 * Created by dayynn on 9/28/17.
 */

class Model {
    private static final Model ourInstance = new Model();

    static Model getInstance() {
        return ourInstance;
    }

    private Model() {
    }
}
