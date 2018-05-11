package com.example.android.quakereport;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class QuakeAdapter extends ArrayAdapter<Earthquake> {
    public QuakeAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Earthquake> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;

        class ViewHolder {
            private TextView magnitude;
            private TextView location;
            private TextView date;
        }
        ViewHolder holder;

        if (convertView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.quake_view, parent, false);
            holder = new ViewHolder();
            holder.magnitude = listItemView.findViewById(R.id.magnitude_view);
            holder.location = listItemView.findViewById(R.id.city_view);
            holder.date = listItemView.findViewById(R.id.date_view);
            listItemView.setTag(holder);
        } else {
            holder = (ViewHolder) listItemView.getTag();
        }

        Earthquake currentQuake = getItem(position);
        holder.magnitude.setText(String.valueOf(currentQuake.getMagnitude()));
        holder.location.setText(currentQuake.getLocation());
        holder.date.setText(String.valueOf(currentQuake.getDate()));

        return listItemView;
    }
}

