package cs2340.gatech.edu.rat_tracker.controllers;

import android.support.v7.app.AppCompatActivity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.content.Intent;

import cs2340.gatech.edu.rat_tracker.R;

public class RataData extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rata_data);
    }

    @Override
    public void onListItemClick(ListView item, View v, int position, long id)  {
        Intent intent = new Intent(getBaseContext(), RatDetails.class);
        intent.putExtra("SIGHTING", ratSighting);
        startActivity(intent);
    }
    
}
