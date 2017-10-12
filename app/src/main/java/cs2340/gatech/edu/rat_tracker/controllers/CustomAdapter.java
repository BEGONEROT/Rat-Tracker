package cs2340.gatech.edu.rat_tracker.controllers;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.Collection;
import java.util.ArrayList;


import cs2340.gatech.edu.rat_tracker.model.RatSighting;
import cs2340.gatech.edu.rat_tracker.R;
import cs2340.gatech.edu.rat_tracker.model.RatSighting;

/**
 * Created by dwarr on 10/11/2017.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private ArrayList<RatSighting> data;


    protected static class ViewHolder extends RecyclerView.ViewHolder {
        protected TextView myTextView;
        protected ViewHolder(TextView v) {
            super(v);
            myTextView = v;
        }
        protected TextView getTextView() {
            return myTextView;
        }
    }

    public CustomAdapter (Collection<RatSighting> ratData) {
        data = new ArrayList<RatSighting>(ratData);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        TextView v = (TextView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rat_sightings, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        RatSighting rat = data.get(position);
        holder.getTextView().setText("Rat Report: " + rat.getKey().toString() + " " + rat.getDate() );
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
