package com.example.ajay.tourguide;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class InformationAdapter extends ArrayAdapter<Information> {

    public InformationAdapter(Activity context, ArrayList<Information> info) {
        super(context, 0, info);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Information currentInfo = getItem(position);

        TextView sightName = (TextView) listItemView.findViewById(R.id.sight_name);

        sightName.setText(currentInfo.getmPlaceName());

        TextView sightDescription = (TextView) listItemView.findViewById(R.id.sight_description);

        sightDescription.setText(currentInfo.getmPlaceDescription());

        // Find the TextView in the list_item.xml layout with the ID image
        ImageView imageResourceId = (ImageView) listItemView.findViewById(R.id.image);

        if (currentInfo.hasImage()) {
            imageResourceId.setImageResource(currentInfo.getImageResourceId());
        } else {
            imageResourceId.setVisibility(View.GONE);
        }

        return listItemView;
    }
}
