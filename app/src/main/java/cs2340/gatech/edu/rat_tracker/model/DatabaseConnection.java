package cs2340.gatech.edu.rat_tracker.model;

import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Created by dayynn on 10/4/17.
 */

public class DatabaseConnection {
    private static final DatabaseConnection ourInstance = new DatabaseConnection();

    private Connection connection;
    private static final String TAG = "DatabaseConnection";

    public static DatabaseConnection getInstance() {
        return ourInstance;
    }

    private DatabaseConnection() {
        try {
            this.connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/begone_rot?user=root&password=dpagan55");
        } catch (Exception e) {
            Log.d(TAG, "Failed to connect!");
        }
    }

    public Statement getStatement() {
        try {
            return connection.createStatement();
        } catch (Exception e) {
            return null;
        }
    }
}
