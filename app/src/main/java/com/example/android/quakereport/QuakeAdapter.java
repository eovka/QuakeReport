package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
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

        GradientDrawable magnitudeDrawable = (GradientDrawable) holder.magnitude.getBackground();
        int magnitudeColor = getMagnitudeColor(currentQuake.getMagnitude());
        magnitudeDrawable.setColor(magnitudeColor);

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
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd.MM.yyyy");
        String dateToDisplay = dateFormatter.format(dateObject);
        holder.date.setText(dateToDisplay);

        SimpleDateFormat timeFormatter = new SimpleDateFormat("HH.mm");
        String formattedTime = timeFormatter.format(dateObject);
        holder.time.setText(formattedTime);

        return listItemView;
    }

    public int getMagnitudeColor(Double magnitude) {
        int color;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                color = R.color.magnitude1;
                break;
            case 2:
                color = R.color.magnitude2;
                break;
            case 3:
                color = R.color.magnitude3;
                break;
            case 4:
                color = R.color.magnitude4;
                break;
            case 5:
                color = R.color.magnitude5;
                break;
            case 6:
                color = R.color.magnitude6;
                break;
            case 7:
                color = R.color.magnitude7;
                break;
            case 8:
                color = R.color.magnitude8;
                break;
            case 9:
                color = R.color.magnitude9;
                break;
            default:
                color = R.color.magnitude10plus;
        }
        return ContextCompat.getColor(getContext(), color);
    }
}

