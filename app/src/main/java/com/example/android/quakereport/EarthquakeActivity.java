package com.example.android.quakereport;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class EarthquakeActivity extends AppCompatActivity {

    public static final String LOG_TAG = EarthquakeActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_activity);

        // Create a fake list of earthquake locations.
        ArrayList<Quake> earthquakes = new ArrayList<>();
        earthquakes.add(new Quake(7.5,"San Francisco", "Feb 2, 2016"));
        earthquakes.add(new Quake(6.1,"London", "July 20, 2015"));
        earthquakes.add(new Quake(3.9,"Tokyo", "Nov 10, 2014"));
        earthquakes.add(new Quake(5.4, "Mexico City", "May 3, 2014"));
        earthquakes.add(new Quake(2.8, "Moscow", "Jan 31, 2013"));
        earthquakes.add(new Quake(4.9, "Rio de Janeiro", "Aug 19, 2012"));
        earthquakes.add(new Quake(1.6,"Paris", "Oct 30, 2011"));

        // Find a reference to the {@link ListView} in the layout
        ListView earthquakeListView = findViewById(R.id.list);

        // Create a new {@link ArrayAdapter} of earthquakes
       QuakeAdapter adapter = new QuakeAdapter(this, 0, earthquakes);

        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        earthquakeListView.setAdapter(adapter);
    }
}
