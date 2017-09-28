package cs2340.gatech.edu.rat_tracker.controllers;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;

import cs2340.gatech.edu.rat_tracker.R;

/**
 * Notification dialog for a failed login attempt
 *
 * Created by Dallas on 9/24/2017.
 */

public class LoginNotification extends DialogFragment {
    /**
     * Constructor for the Notification
     * @return the AlertDialog object that was constructed
     */
    public Dialog onCreateDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.login_failed_title)
                .setMessage(R.string.login_failed_title)
                .setNeutralButton(R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // If user hits OK, shouldn't do anything for now
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }
}
