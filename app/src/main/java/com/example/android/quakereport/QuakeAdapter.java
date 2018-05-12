package com.example.android.quakereport;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class QuakeAdapter extends ArrayAdapter<Earthquake> {
    private static final String LOCATION_SEPARATOR = " of ";

    public QuakeAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Earthquake> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;

        class ViewHolder {
            private TextView magnitude;
            private TextView offsetLocation;
            private TextView primaryLocation;
            private TextView date;
            private TextView time;
        }
        ViewHolder holder;

        if (convertView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.quake_view, parent, false);
            holder = new ViewHolder();
            holder.magnitude = listItemView.findViewById(R.id.magnitude_view);
            holder.offsetLocation = listItemView.findViewById(R.id.offset_location);
            holder.primaryLocation = listItemView.findViewById(R.id.primary_location);
            holder.date = listItemView.findViewById(R.id.date_view);
            holder.time = listItemView.findViewById(R.id.time_view);
            listItemView.setTag(holder);
        } else {
            holder = (ViewHolder) listItemView.getTag();
        }

        Earthquake currentQuake = getItem(position);

        DecimalFormat decimalFormat = new DecimalFormat("0.0");
        holder.magnitude.setText(decimalFormat.format(currentQuake.getMagnitude()));

        String location = currentQuake.getLocation();
        String offset;
        String primary;
        if (location.contains(LOCATION_SEPARATOR)) {
            String[] parts = location.split(LOCATION_SEPARATOR);
            offset = parts[0] + LOCATION_SEPARATOR;
            primary = parts[1];
        } else {
            offset = getContext().getString(R.string.near_the);
            primary = currentQuake.getLocation();
        }
        holder.offsetLocation.setText(offset);
        holder.primaryLocation.setText(primary);

        Date dateObject = new Date(currentQuake.getDate());
        SimpleDateFormat dateFormatter = new SimpleDateFormat("DD.MM.yyyy");
        String dateToDisplay = dateFormatter.format(dateObject);
        holder.date.setText(dateToDisplay);

        SimpleDateFormat timeFormatter = new SimpleDateFormat("HH.mm");
        String formattedTime = timeFormatter.format(dateObject);
        holder.time.setText(formattedTime);

        return listItemView;
    }
}

