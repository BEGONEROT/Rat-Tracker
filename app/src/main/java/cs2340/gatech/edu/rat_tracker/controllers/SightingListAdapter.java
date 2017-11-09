package cs2340.gatech.edu.rat_tracker.controllers;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import android.view.View;
import java.util.Collection;
import java.util.ArrayList;


import cs2340.gatech.edu.rat_tracker.model.RatSighting;
import cs2340.gatech.edu.rat_tracker.R;

/**
 *
 * Created by dwarr on 10/11/2017.
 */

public class SightingListAdapter extends RecyclerView.Adapter<SightingListAdapter.ViewHolder> {

    private ArrayList<RatSighting> data;
    private Context mContext;

    /**
     * This will create the standard item view the recyclerView will use
     */
    protected static class ViewHolder extends RecyclerView.ViewHolder {
        protected TextView borough;
        protected TextView date;
        protected TextView address;

        /**
         * Takes in a view
         * @param v view
         */
        protected ViewHolder(View v) {
            super(v);
            borough = (TextView) v.findViewById(R.id.borough);
            address = (TextView) v.findViewById(R.id.address);
            date = (TextView) v.findViewById(R.id.date);
        }
    }

    /**
     * Makes the collection of Rat Sightings into an adapter
     *
     * @param context the current activity
     * @param ratData collection of rat data values
     */
    public SightingListAdapter(Context context, Collection<RatSighting> ratData) {
        data = new ArrayList<RatSighting>(ratData);
        mContext = context;
    }

    /**
     * Getter for context
     *
     * @return context
     */
    public Context getContext() {
        return mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rat_sightings, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        RatSighting rat = data.get(position);
        holder.borough.setText(rat.getBorough().toString());
        holder.address.setText(rat.getIncidentAddress());
        holder.date.setText(rat.getStringDate());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    /*
 * This method gets an ArrayList of the rat data.
 *
 * @return rat data
 */
    public ArrayList<RatSighting> getData() {
        return data;
    }
}
