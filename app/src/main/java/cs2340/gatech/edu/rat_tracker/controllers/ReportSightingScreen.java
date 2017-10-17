package cs2340.gatech.edu.rat_tracker.controllers;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import cs2340.gatech.edu.rat_tracker.R;
import cs2340.gatech.edu.rat_tracker.model.RatSighting;

/**
 * Created by davonprewitt on 10/15/17.
 */



public class ReportSightingScreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_sighting_screen);
        final Button submit = (Button) findViewById(R.id.submit);






        Spinner residenceTypeSpinner = (Spinner) findViewById(R.id.residenceTypeSpinner);


        ArrayAdapter<String> adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, RatSighting.resTypes);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        residenceTypeSpinner.setAdapter(adapter);


        TextView cityField = (TextView) findViewById(R.id.cityText);


        TextView boroughField = (TextView) findViewById(R.id.boroughText);



        TextView addressField = (TextView) findViewById(R.id.address);


        submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String residenceType = (String) residenceTypeSpinner.getSelectedItem();
                String city = (String) cityField.getText().toString();
                String borough = (String) boroughField.getText().toString();
                String address = addressField.getText().toString();





            }

        });






    }


}
