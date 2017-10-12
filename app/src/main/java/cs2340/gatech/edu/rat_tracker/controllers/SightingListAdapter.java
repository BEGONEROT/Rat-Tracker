package cs2340.gatech.edu.rat_tracker.controllers;

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
 * Created by dwarr on 10/11/2017.
 */

public class SightingListAdapter extends RecyclerView.Adapter<SightingListAdapter.ViewHolder> {

    private ArrayList<RatSighting> data;


    protected static class ViewHolder extends RecyclerView.ViewHolder {
        protected TextView key;
        protected TextView date;
        protected ViewHolder(View v) {
            super(v);
            key = (TextView) v.findViewById(R.id.key);
            date = (TextView) v.findViewById(R.id.date);
        }
    }

    public SightingListAdapter(Collection<RatSighting> ratData) {
        data = new ArrayList<RatSighting>(ratData);
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
        holder.key.setText(rat.getKey().toString());
        holder.date.setText(rat.getDate());
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
