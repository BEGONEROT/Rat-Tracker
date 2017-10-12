package cs2340.gatech.edu.rat_tracker.model;

import android.os.AsyncTask;
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
            //this.connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/begone_rot");
            this.connection = null;
            Connect();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            Log.d(TAG, "shit man");
        }
    }


    public static void setConnection(Connection connection) {
        getInstance().setConnectionHelp(connection);
    }

    private class Connect extends AsyncTask<String, Void, Void> {
        @Override
        protected Void doInBackground(String... urls) {
            String response = "";
            Connection conn;
            try {
                Class.forName("org.mariadb.jdbc.Driver").newInstance();

            } catch (Exception e) {
                Log.d(TAG, "class load");
            }
            try {
                System.gc();
                conn = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/test?user=root");
                //DatabaseConnection.setConnection(conn);
            } catch (Exception e) {
                e.printStackTrace();
                Log.d(TAG, "shit man connection");
            }
            return null;

        }
    }



    public Statement getStatement() {
        try {
            return connection.createStatement();
        } catch (Exception e) {
            return null;
        }
    }



    private void setConnectionHelp(Connection connection) {
        this.connection = connection;
    }

    public void Connect() {
        Connect task = new Connect();
        task.execute("", null, null);
    }



}
