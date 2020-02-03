package com.example.ud839_tourguide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class PlaceAdapter extends ArrayAdapter<Place> {

    private ArrayList<Place> mPlaces;

    public PlaceAdapter(Context context, ArrayList<Place> places) {
        super(context, 0, places);
        mPlaces = places;
    }

    static class ViewHolder {
        ImageView thumbnail;
        TextView name;
        TextView location;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;

        ViewHolder holder;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.single_attraction,
                    parent, false);
            holder = new ViewHolder();
            holder.thumbnail = (ImageView) listItemView.findViewById(R.id.thumbnail);
            holder.name = (TextView) listItemView.findViewById(R.id.place);
            holder.location = (TextView) listItemView.findViewById(R.id.location);

            listItemView.setTag(holder);
        } else {
            holder = (ViewHolder) listItemView.getTag();
        }

        Place place = mPlaces.get(position);
        holder.thumbnail.setImageResource(place.getThumbnailResourceId());
        holder.name.setText(place.getName());
        holder.location.setText(place.getLocation());

        return listItemView;
    }
}
